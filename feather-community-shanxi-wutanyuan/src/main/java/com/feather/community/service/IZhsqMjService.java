package com.feather.community.service;

import com.feather.community.domain.ZhsqMj;

import java.util.List;

/**
 * 门禁Service接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface IZhsqMjService {
    /**
     * 查询门禁
     * 
     * @param mjid 门禁ID
     * @return 门禁
     */
    public ZhsqMj selectZhsqMjById(String mjid);

    /**
     * 查询门禁列表
     * 
     * @param zhsqMj 门禁
     * @return 门禁集合
     */
    public List<ZhsqMj> selectZhsqMjList(ZhsqMj zhsqMj);

    /**
     * 新增门禁
     * 
     * @param zhsqMj 门禁
     * @return 结果
     */
    public int insertZhsqMj(ZhsqMj zhsqMj);

    /**
     * 修改门禁
     * 
     * @param zhsqMj 门禁
     * @return 结果
     */
    public int updateZhsqMj(ZhsqMj zhsqMj);

    /**
     * 批量删除门禁
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqMjByIds(String ids);

    /**
     * 删除门禁信息
     * 
     * @param mjid 门禁ID
     * @return 结果
     */
    public int deleteZhsqMjById(String mjid);
}
