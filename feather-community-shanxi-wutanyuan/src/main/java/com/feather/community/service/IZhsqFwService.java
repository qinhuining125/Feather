package com.feather.community.service;

import java.util.List;
import java.util.Map;

import com.feather.community.domain.ZhsqFw;

/**
 * 房屋Service接口
 *
 * @author fancy
 * @date 2020-05-14
 */
public interface IZhsqFwService {
    /**
     * 查询房屋
     *
     * @param fwid
     *            房屋ID
     * @return 房屋
     */
    ZhsqFw selectZhsqFwById(String fwid);

    /**
     * 查询房屋列表
     *
     * @param zhsqFw
     *            房屋
     * @return 房屋集合
     */
    List<ZhsqFw> selectZhsqFwList(ZhsqFw zhsqFw);

    /**
     * 根据楼栋获取房屋
     * @param ldids
     * @return
     */
    List<ZhsqFw> selectZhsqFwByLdids(List<String> ldids);

    /**
     * 房屋列表（数据字典）
     * @return
     */
    List<Map<String, String>> selectZhsqFwType();

    /**
     * 新增房屋
     *
     * @param zhsqFw
     *            房屋
     * @return 结果
     */
    int insertZhsqFw(ZhsqFw zhsqFw);

    /**
     * 修改房屋
     *
     * @param zhsqFw
     *            房屋
     * @return 结果
     */
    int updateZhsqFw(ZhsqFw zhsqFw);

    /**
     * 批量删除房屋
     *
     * @param ids
     *            需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqFwByIds(String ids);

    /**
     * 删除房屋信息
     *
     * @param fwid
     *            房屋ID
     * @return 结果
     */
    int deleteZhsqFwById(String fwid);

    /**
     * 查询入住率
     * 
     * @param maps
     * @return
     */
    Map<String, Object> selectRzlCount(Map<String, Object> maps);

    /**
     * 查询入住类型统计
     * 
     * @param maps
     * @return
     */
    List<Map<String, Object>> selectTjCount(Map<String, Object> maps);

    Map<String, Object> getFwXx(Map<String, Object> maps);

    /**
     * 社区管理房屋统计
     * @return
     */
    List<Map<String, String>> sqglFwTj();
}