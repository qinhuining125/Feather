package com.feather.community.service;

import com.feather.common.core.domain.AjaxResult;
import com.feather.community.domain.ZhsqSxt;

import java.util.List;
import java.util.Map;

/**
 * 摄像头Service接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface IZhsqSxtService {
    /**
     * 查询摄像头
     * 
     * @param sxtid 摄像头ID
     * @return 车辆
     */
    ZhsqSxt selectZhsqSxtById(String sxtid);

    /**
     * 查询摄像头列表
     * 
     * @param zhsqSxt 摄像头
     * @return 摄像头集合
     */
    List<ZhsqSxt> selectZhsqSxtList(ZhsqSxt zhsqSxt);

    /**
     * 新增摄像头
     * 
     * @param zhsqSxt 摄像头
     * @return 结果
     */
    int insertZhsqSxt(ZhsqSxt zhsqSxt);

    /**
     * 修改摄像头
     * 
     * @param zhsqSxt 摄像头
     * @return 结果
     */
    int updateZhsqSxt(ZhsqSxt zhsqSxt);

    /**
     * 批量删除摄像头
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqSxtByIds(String ids);

    /**
     * 删除摄像头信息
     * 
     * @param sxtid 摄像头ID
     * @return 结果
     */
    int deleteZhsqSxtById(String sxtid);

    /**
     * 获取摄像头统计
     * @return
     */
    AjaxResult getSxtTj(Map<String, Object> params);
}
