package com.feather.community.mapper;

import java.util.List;

import com.feather.community.domain.ZhsqZnsb;

/**
 * communityMapper接口
 * 
 * @author fancy
 * @date 2020-09-01
 */
public interface ZhsqZnsbMapper {
    /**
     * 查询community
     * 
     * @param id
     *            communityID
     * @return community
     */
    public ZhsqZnsb selectZhsqZnsbById(String id);

    /**
     * 查询community列表
     * 
     * @param zhsqZnsb
     *            community
     * @return community集合
     */
    public List<ZhsqZnsb> selectZhsqZnsbList(ZhsqZnsb zhsqZnsb);

    /**
     * 新增community
     * 
     * @param zhsqZnsb
     *            community
     * @return 结果
     */
    public int insertZhsqZnsb(ZhsqZnsb zhsqZnsb);

    /**
     * 修改community
     * 
     * @param zhsqZnsb
     *            community
     * @return 结果
     */
    public int updateZhsqZnsb(ZhsqZnsb zhsqZnsb);

    /**
     * 删除community
     * 
     * @param id
     *            communityID
     * @return 结果
     */
    public int deleteZhsqZnsbById(String id);

    /**
     * 批量删除community
     * 
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqZnsbByIds(String[] ids);
}
