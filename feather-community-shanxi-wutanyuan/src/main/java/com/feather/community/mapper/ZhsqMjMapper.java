package com.feather.community.mapper;


import com.feather.community.domain.ZhsqMj;

import java.util.List;

/**
 * 门禁Mapper接口
 * 
 * @author fancy
 * @date 2020-05-15
 */
public interface ZhsqMjMapper {
    /**
     * 查询门禁
     * 
     * @param mjid 门禁id
     * @return 门禁
     */
    public ZhsqMj selectZhsqMjById(String mjid);

    /**
     * 查询门禁列表
     * 
     * @param ZhsqMj 门禁id
     *
     * @return 门禁集合
     */
    public List<ZhsqMj> selectZhsqMjList(ZhsqMj ZhsqMj);

    /**
     * 新增门禁
     * 
     * @param ZhsqMj 新增门禁
     *
     * @return 结果
     */
    public int insertZhsqMj(ZhsqMj ZhsqMj);

    /**
     * 修改门禁
     * 
     * @param ZhsqMj 门禁
     *
     * @return 结果
     */
    public int updateZhsqMj(ZhsqMj ZhsqMj);

    /**
     * 删除门禁
     * 
     * @param mjid
     *
     * @return 结果
     */
    public int deleteZhsqMjById(String mjid);

    /**
     * 批量删除门禁
     * 
     * @param mjids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqMjByIds(String[] mjids);
}
