package com.feather.common.core.domain;

import java.util.Date;
import java.util.Map;

public interface IFeatherEntity {

    String getSearchValue();

    void setSearchValue(String searchValue);

    String getCreateBy();

    void setCreateBy(String createBy);

    Long getCreateByid();

    void setCreateByid(Long createByid);

    Date getCreateTime();

    void setCreateTime(Date createTime);

    String getUpdateBy();

    void setUpdateBy(String updateBy);

    Long getUpdateByid();

    void setUpdateByid(Long updateByid);

    Date getUpdateTime();

    void setUpdateTime(Date updateTime);

    Byte getStatus();

    void setStatus(Byte status);

    String getRemark();

    void setRemark(String remark);

    Map<String, Object> getParams();

    void setParams(Map<String, Object> params);
}
