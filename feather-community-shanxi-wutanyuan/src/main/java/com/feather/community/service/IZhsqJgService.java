package com.feather.community.service;

import com.feather.community.domain.ZhsqJg;
import java.util.List;

/**
 * 井盖Service接口
 * 
 * @author fancy
 * @date 2020-12-11
 */
public interface IZhsqJgService 
{
    /**
     * 查询井盖
     * 
     * @param jgid 井盖ID
     * @return 井盖
     */
    public ZhsqJg selectZhsqJgById(String jgid);

    /**
     * 查询井盖列表
     * 
     * @param zhsqJg 井盖
     * @return 井盖集合
     */
    public List<ZhsqJg> selectZhsqJgList(ZhsqJg zhsqJg);

    /**
     * 新增井盖
     * 
     * @param zhsqJg 井盖
     * @return 结果
     */
    public int insertZhsqJg(ZhsqJg zhsqJg);

    /**
     * 修改井盖
     * 
     * @param zhsqJg 井盖
     * @return 结果
     */
    public int updateZhsqJg(ZhsqJg zhsqJg);

    /**
     * 批量删除井盖
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhsqJgByIds(String ids);

    /**
     * 删除井盖信息
     * 
     * @param jgid 井盖ID
     * @return 结果
     */
    public int deleteZhsqJgById(String jgid);
}
