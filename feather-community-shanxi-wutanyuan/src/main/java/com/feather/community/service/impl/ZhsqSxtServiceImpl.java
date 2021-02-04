package com.feather.community.service.impl;

import com.feather.common.core.domain.AjaxResult;
import com.feather.common.core.text.Convert;

import com.feather.common.utils.ExceptionUtil;
import com.feather.community.domain.ZhsqSxt;
import com.feather.community.mapper.ZhsqSxtMapper;
import com.feather.community.service.IZhsqSxtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 摄像头Service业务层处理
 * 
 * @author fancy
 * @date 2020-05-15
 */
@Service
public class ZhsqSxtServiceImpl implements IZhsqSxtService {
    @Autowired
    private ZhsqSxtMapper zhsqSxtMapper;

    /**
     * 查询摄像头
     * 
     * @param ldid 摄像头ID
     * @return 摄像头
     */
    @Override
    public ZhsqSxt selectZhsqSxtById(String ldid) {
        return zhsqSxtMapper.selectZhsqSxtById(ldid);
    }

    /**
     * 查询摄像头列表
     * 
     * @param zhsqLd 摄像头
     * @return 摄像头
     */
    @Override
    public List<ZhsqSxt> selectZhsqSxtList(ZhsqSxt zhsqLd) {
        return zhsqSxtMapper.selectZhsqSxtList(zhsqLd);
    }

    /**
     * 新增摄像头
     * 
     * @param zhsqLd 摄像头
     * @return 结果
     */
    @Override
    public int insertZhsqSxt(ZhsqSxt zhsqLd) {
        return zhsqSxtMapper.insertZhsqSxt(zhsqLd);
    }

    /**
     * 修改摄像头
     * 
     * @param zhsqLd 摄像头
     * @return 结果
     */
    @Override
    public int updateZhsqSxt(ZhsqSxt zhsqLd) {
        return zhsqSxtMapper.updateZhsqSxt(zhsqLd);
    }

    /**
     * 删除摄像头对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZhsqSxtByIds(String ids) {
        return zhsqSxtMapper.deleteZhsqSxtByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除摄像头信息
     * 
     * @param ldid 摄像头ID
     * @return 结果
     */
    @Override
    public int deleteZhsqSxtById(String ldid) {
        return zhsqSxtMapper.deleteZhsqSxtById(ldid);
    }

    @Override
    public AjaxResult getSxtTj(Map<String, Object> params){
        Map<String, String> result = new HashMap<>(16);
        try {
            List<Map<String, String>> sxt = zhsqSxtMapper.getSxtTj(params);
            if (sxt != null && sxt.size() > 0) {
                for (Map<String, String> map : sxt) {
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
}
