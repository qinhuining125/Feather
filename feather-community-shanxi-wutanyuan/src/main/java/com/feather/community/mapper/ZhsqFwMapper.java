package com.feather.community.mapper;

import java.util.List;
import java.util.Map;

import com.feather.community.domain.ZhsqFw;

/**
 * 房屋Mapper接口
 *
 * @author fancy
 * @date 2020-05-14
 */
public interface ZhsqFwMapper {
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
     * 根据楼栋ID列表获取房屋列表
     * @param ldids
     * @return
     */
    List<ZhsqFw> selectZhsqFwByLdids(List<String> ldids);

    /**
     * 查询房屋（数据字典）
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
     * 删除房屋
     *
     * @param fwid
     *            房屋ID
     * @return 结果
     */
    int deleteZhsqFwById(String fwid);

    /**
     * 批量删除房屋
     *
     * @param fwids
     *            需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqFwByIds(String[] fwids);

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

    List<Map<String, Object>> getFwXx(Map<String, Object> maps);

    int getRySl(Map<String, Object> maps);

    /**
     * 智慧社区房屋统计
     * @return
     */
    List<Map<String, String>> sqglFwTj();
}