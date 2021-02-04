package com.feather.community.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.feather.common.core.domain.AjaxResult;
import com.feather.common.utils.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.common.core.text.Convert;
import com.feather.community.domain.ZhsqJm;
import com.feather.community.mapper.ZhsqJmMapper;
import com.feather.community.service.IZhsqJmService;

/**
 * 居民Service业务层处理
 *
 * @author fancy
 * @date 2020-05-14
 */
@Service
public class ZhsqJmServiceImpl implements IZhsqJmService {
    @Autowired
    private ZhsqJmMapper zhsqJmMapper;

    /**
     * 查询居民
     *
     * @param jmid 居民ID
     * @return 居民
     */
    @Override
    public ZhsqJm selectZhsqJmById(String jmid) {
        return zhsqJmMapper.selectZhsqJmById(jmid);
    }

    /**
     * 查询居民列表
     *
     * @param zhsqJm 居民
     * @return 居民
     */
    @Override
    public List<ZhsqJm> selectZhsqJmList(ZhsqJm zhsqJm) {
        return zhsqJmMapper.selectZhsqJmList(zhsqJm);
    }

    @Override
    public List<Map<String, String>> selectZhsqJmType(){
        return zhsqJmMapper.selectZhsqJmType();
    }

    /**
     * 新增居民
     *
     * @param zhsqJm 居民
     * @return 结果
     */
    @Override
    public int insertZhsqJm(ZhsqJm zhsqJm) {
        return zhsqJmMapper.insertZhsqJm(zhsqJm);
    }

    /**
     * 修改居民
     *
     * @param zhsqJm 居民
     * @return 结果
     */
    @Override
    public int updateZhsqJm(ZhsqJm zhsqJm) {
        return zhsqJmMapper.updateZhsqJm(zhsqJm);
    }

    /**
     * 删除居民对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqJmByIds(String ids) {
        return zhsqJmMapper.deleteZhsqJmByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除居民信息
     *
     * @param jmid 居民ID
     * @return 结果
     */
    @Override
    public int deleteZhsqJmById(String jmid) {
        return zhsqJmMapper.deleteZhsqJmById(jmid);
    }

    @Override
    public List<Map> getPersonInfo(Map<String, Object> maps) {
        return zhsqJmMapper.getPersonInfo(maps);
    }

    @Override
    public List<Map<String, Object>> getFwRy(Map<String, Object> maps) {
        return zhsqJmMapper.getFwRy(maps);
    }

    @Override
    public AjaxResult getZdryTj(Map<String, Object> params) {
        params.put("state", "是");
        Map<String, String> result = new HashMap<>(16);
        try {
            List<Map<String, String>> zdry = zhsqJmMapper.getZdryTj(params);
            if (zdry != null && zdry.size() > 0) {
                for (Map<String, String> map : zdry) {
                    String res = map.get("rs");
                    String[] arr = res.split(",");
                    result.put(arr[0], arr[1]);
                }
            }
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult getSqgkTj(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>(16);
        try {
            List<Map<String, String>> sqgk = zhsqJmMapper.getSqgkTj(params);
            if (sqgk != null && sqgk.size() > 0) {
                for (Map<String, String> map : sqgk) {
                    String res = map.get("sl");
                    String[] arr = res.split(",");
                    result.put(arr[0], arr[1]);
                }
            }
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult getSfczTj(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>(16);
        try {
            params.put("czrk", "常驻人口");
            params.put("wlrk", "外来人口");
            List<Map<String, String>> sfcz = zhsqJmMapper.getSfczTj(params);
            if (sfcz != null && sfcz.size() > 0) {
                for (Map<String, String> map : sfcz) {
                    String res = map.get("sl");
                    String[] arr = res.split(",");
                    result.put(arr[0], arr[1]);
                }
            }
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult getNljgTj(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>(16);
        try {
            List<Map<String, String>> nljg = zhsqJmMapper.getNljgTj(params);
            if (nljg != null && nljg.size() > 0) {
                for (Map<String, String> map : nljg) {
                    String nl = map.get("nl");
                    String sl = map.get("sl");
                    result.put(nl, sl);
                }
            }
            return AjaxResult.success(nljg);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult getXbTj(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>(16);
        try {
            List<Map<String, String>> xbtj = zhsqJmMapper.getXbTj(params);
            if (xbtj != null && xbtj.size() > 0) {
                for (Map<String, String> map : xbtj) {
                    String xb = map.get("xb");
                    String sl = map.get("sl");
                    result.put(xb, sl);
                }
            }
            return AjaxResult.success(xbtj);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult getMzTj(Map<String, Object> params) {
        Map<String, String> result = new HashMap<>(16);
        try {
            List<Map<String, String>> mztj = zhsqJmMapper.getMzTj(params);
            if (mztj != null && mztj.size() > 0) {
                for (Map<String, String> map : mztj) {
                    String xb = map.get("mz");
                    String sl = map.get("sl");
                    result.put(xb, sl);
                }
            }
            return AjaxResult.success(mztj);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    @Override
    public AjaxResult getZhsqJmById(String jmid) {
        try {
            Map<String, Object> result = zhsqJmMapper.getZhsqJmById(jmid);
            return AjaxResult.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            String errInfo = ExceptionUtil.getExceptionMessage(e);
            return AjaxResult.error(errInfo);
        }
    }

    /**
     * 查询重点人员楼栋信息
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> getZdRyLd() {
        return zhsqJmMapper.getZdRyLd();
    }
}
