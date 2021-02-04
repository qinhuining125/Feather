package com.feather.community.mapper;

import java.util.List;
import java.util.Map;

import com.feather.community.domain.ZhsqJm;

/**
 * 居民Mapper接口
 * 
 * @author fancy
 * @date 2020-05-14
 */
public interface ZhsqJmMapper {
    /**
     * 查询居民
     * 
     * @param jmid
     *            居民ID
     * @return 居民
     */
    ZhsqJm selectZhsqJmById(String jmid);

    /**
     * 查询居民列表
     * 
     * @param zhsqJm
     *            居民
     * @return 居民集合
     */
    List<ZhsqJm> selectZhsqJmList(ZhsqJm zhsqJm);

    /**
     * 居民数据字典
     * @return
     */
    List<Map<String, String>> selectZhsqJmType();

    /**
     * 新增居民
     * 
     * @param zhsqJm
     *            居民
     * @return 结果
     */
    int insertZhsqJm(ZhsqJm zhsqJm);

    /**
     * 修改居民
     * 
     * @param zhsqJm
     *            居民
     * @return 结果
     */
    int updateZhsqJm(ZhsqJm zhsqJm);

    /**
     * 删除居民
     * 
     * @param jmid
     *            居民ID
     * @return 结果
     */
    int deleteZhsqJmById(String jmid);

    /**
     * 批量删除居民
     * 
     * @param jmids
     *            需要删除的数据ID
     * @return 结果
     */
    int deleteZhsqJmByIds(String[] jmids);

    List<Map> getPersonInfo(Map<String, Object> maps);

    List<Map<String, Object>> getFwRy(Map<String, Object> maps);

    /**
     * 重点人员统计
     * @param param
     * @return
     */
    List<Map<String, String>> getZdryTj(Map<String, Object> param);

    /**
     * 获取社区概况统计
     * @param param
     * @return
     */
    List<Map<String, String>> getSqgkTj(Map<String, Object> param);

    /**
     * 常驻人口统计
     * @param param
     * @return
     */
    List<Map<String, String>> getSfczTj(Map<String, Object> param);

    /**
     * 年龄结构统计
     * @param param
     * @return
     */
    List<Map<String, String>> getNljgTj(Map<String, Object> param);

    /**
     * 性别统计
     * @param param
     * @return
     */
    List<Map<String, String>> getXbTj(Map<String, Object> param);

    /**
     * 民族统计
     * @param param
     * @return
     */
    List<Map<String, String>> getMzTj(Map<String, Object> param);



    Map<String, Object> getZhsqJmById(String jmid);

    /**
     * 查询重点人员楼栋信息
     * 
     * @return
     */
    List<Map<String, Object>> getZdRyLd();
}
