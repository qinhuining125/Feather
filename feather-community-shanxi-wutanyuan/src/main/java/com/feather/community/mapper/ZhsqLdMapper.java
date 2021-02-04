package com.feather.community.mapper;


import com.feather.community.domain.ZhsqLd;

import java.util.List;
import java.util.Map;

/**
 * 楼栋Mapper接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface ZhsqLdMapper {
    /**
     * 查询楼栋
     * 
     * @param ldid 楼栋id
     * @return 楼栋
     */
    ZhsqLd selectZhsqLdById(String ldid);

    /**
     * 查询楼栋列表
     * 
     * @param zhsqLd 楼栋id
     *
     * @return 楼栋集合
     */
    List<ZhsqLd> selectZhsqLdList(ZhsqLd zhsqLd);

    /**
     * 查询楼栋（数据字典）
     * @return
     */
    List<Map<String, String>> selectZhsqLdType();

    /**
     * 新增楼栋
     * 
     * @param zhsqLd 新增楼栋
     *
     * @return 结果
     */
    int insertZhsqLd(ZhsqLd zhsqLd);

    /**
     * 修改楼栋
     * 
     * @param zhsqLd 楼栋
     *
     * @return 结果
     */
    int updateZhsqLd(ZhsqLd zhsqLd);

    /**
     * 删除楼栋
     * 
     * @param ldid
     *
     * @return 结果
     */
    int deleteZhsqLdById(String ldid);

    /**
     * 批量删除楼栋
     * 
     * @param ldids 需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqLdByIds(String[] ldids);
}
