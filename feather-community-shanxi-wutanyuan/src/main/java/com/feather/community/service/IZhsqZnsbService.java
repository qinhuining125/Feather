package com.feather.community.service;

import java.util.List;

import com.feather.community.domain.ZhsqZnsb;

/**
 * communityService接口
 * 
 * @author fancy
 * @date 2020-09-01
 */
public interface IZhsqZnsbService {
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
     * 批量删除community
     * 
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqZnsbByIds(String ids);

    /**
     * 删除community信息
     * 
     * @param id
     *            communityID
     * @return 结果
     */
    public int deleteZhsqZnsbById(String id);
}
