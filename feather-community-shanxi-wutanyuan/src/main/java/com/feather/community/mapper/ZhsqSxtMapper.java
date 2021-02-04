package com.feather.community.mapper;


import com.feather.community.domain.ZhsqSxt;

import java.util.List;
import java.util.Map;

/**
 * 摄像头Mapper接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface ZhsqSxtMapper {
    /**
     * 查询摄像头
     * 
     * @param sxtid 摄像头id
     * @return 摄像头
     */
    ZhsqSxt selectZhsqSxtById(String sxtid);

    /**
     * 查询摄像头列表
     * 
     * @param ZhsqSxt 摄像头id
     *
     * @return 摄像头集合
     */
    List<ZhsqSxt> selectZhsqSxtList(ZhsqSxt ZhsqSxt);

    /**
     * 新增摄像头
     * 
     * @param ZhsqSxt 新增摄像头
     *
     * @return 结果
     */
    int insertZhsqSxt(ZhsqSxt ZhsqSxt);

    /**
     * 修改摄像头
     * 
     * @param ZhsqSxt 摄像头
     *
     * @return 结果
     */
    int updateZhsqSxt(ZhsqSxt ZhsqSxt);

    /**
     * 删除摄像头
     * 
     * @param sxtid
     *
     * @return 结果
     */
    int deleteZhsqSxtById(String sxtid);

    /**
     * 批量删除摄像头
     * 
     * @param sxtids 需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqSxtByIds(String[] sxtids);

    /**
     * 获取摄像头统计
     * @param params
     * @return
     */
    List<Map<String, String>> getSxtTj(Map<String, Object> params);
}
