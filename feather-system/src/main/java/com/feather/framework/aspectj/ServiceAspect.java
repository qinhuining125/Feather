package com.feather.framework.aspectj;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.feather.common.constant.FeatherConstants;
import com.feather.common.core.domain.IFeatherEntity;
import com.feather.system.domain.SysUser;

@Aspect
@Component
public class ServiceAspect {

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void servicePointCut() {

    }

    @Before("servicePointCut()")
    public void doBefore(JoinPoint point) throws Throwable {
        handleTimeAndUser(point);
    }

    protected void handleTimeAndUser(final JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            String name = method.getName();
            if (name.startsWith("insert")) {
                matchArgs(joinPoint, true);
            } else if (name.startsWith("update")) {
                matchArgs(joinPoint, false);
            }
        }
    }

    private void matchArgs(JoinPoint joinPoint, boolean isInsert) {
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            Date time = new Date();
            UserNameAndId uni = getLoginUserNameAndId();
            for (Object item : args) {
                if (item instanceof IFeatherEntity) {
                    setEntity((IFeatherEntity) item, time, uni, isInsert);
                } else if (item instanceof List) {
                    List<?> list = (List<?>) item;
                    if (list.size() > 0 && list.get(0) instanceof IFeatherEntity) {
                        if (list.get(0) instanceof IFeatherEntity) {
                            for (Object entity : list) {
                                setEntity((IFeatherEntity) entity, time, uni, isInsert);
                            }
                        }
                    }
                }
            }
        }
    }

    private void setEntity(IFeatherEntity entity, Date time, UserNameAndId uni, boolean isInsert) {
        // logger.debug("setEntity(name=" + uni.name + ",id=" + uni.id + ") on "
        // + (isInsert ? "INSERT" : "UPDATE"));
        if (isInsert) {
            if (entity.getCreateTime() == null) {
                entity.setCreateTime(time);
            }
            if (entity.getCreateBy() == null) {
                entity.setCreateBy(uni.name);
            }
            if (entity.getCreateByid() == null) {
                entity.setCreateByid(uni.id);
            }
        }
        if (entity.getUpdateTime() == null) {
            entity.setUpdateTime(time);
        }
        if (entity.getUpdateBy() == null) {
            entity.setUpdateBy(uni.name);
        }
        if (entity.getUpdateByid() == null) {
            entity.setUpdateByid(uni.id);
        }
        if (entity.getStatus() == null) {
            entity.setStatus(FeatherConstants.TRUE_SUCCESS_ENABLED_PRIMARY);
        }
    }

    private UserNameAndId getLoginUserNameAndId() {
        UserNameAndId ni = new UserNameAndId();
        try {
            Subject subject = ThreadContext.getSubject();
            if (subject != null) {
                Object obj = subject.getPrincipal();
                if (obj instanceof SysUser) {
                    SysUser user = (SysUser) obj;
                    ni.name = user.getLoginName();
                    ni.id = user.getUserId();
                }
            }
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return ni;
    }

    static class UserNameAndId {
        String name;
        Long id;
    }
}
