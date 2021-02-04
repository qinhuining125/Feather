package com.feather.community.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 社区资产Mapper接口
 *
 * @author fancy
 * @date 2020-05-14
 */
public interface ZhsqZnafMapper {
    public List<Map> getCountSb(@Param("sqid") String sqid, @Param("xqid") String xqid);

    public List<Map> getYcList(@Param("sqid") String sqid, @Param("xqid") String xqid);

    public List<Map> getCountMj(@Param("sqid") String sqid, @Param("xqid") String xqid);

    public List<Map> getMjjcList(@Param("sqid") String sqid, @Param("xqid") String xqid);

    public List<Map> getCountZj(@Param("sqid") String sqid, @Param("xqid") String xqid);

    public List<Map> getZjjcList(@Param("sqid") String sqid, @Param("xqid") String xqid);

    public List<Map> getCountDg(@Param("sqid") String sqid, @Param("xqid") String xqid);

    public List<Map> getDgjcList(@Param("sqid") String sqid, @Param("xqid") String xqid);

    public List<Map> getSxtList(@Param("wzlx") String wzlx, @Param("sqid") String sqid, @Param("xqid") String xqid);

    //设备统计
    public List<Map<String, Object>> getSbtj(@Param("sqid") String sqid, @Param("xqid") String xqid);

    //报警统计
    public List<Map<String, Object>> getBjtj(@Param("sqid") String sqid, @Param("xqid") String xqid);

    //报警处置
    public List<Map<String, Object>> getBjcz(Map<String, Object> maps);

    //异常内容
    public List<Map<String, Object>> getYcnr(@Param("sqid") String sqid, @Param("xqid") String xqid);

    //视频列表
    public List<Map<String, Object>> getSplb();

    //门禁出入
    public List<Map<String, Object>> getMjjc(@Param("page")Integer page, @Param("size")Integer size,@Param("jczt")String jczt);
      //门禁出入记录总数
    public  Integer getMjjcCount(@Param("jczt")String jczt);
    //门禁出入总记录
    public List<Map<String, Object>> getMj();

    //道杆车辆
    public List<Map<String, Object>> getDg();
    //道杆车辆出入记录总数
    public List<Map<String, Object>> getDgjc(@Param("page")Integer page, @Param("size")Integer size,@Param("jczt")String jczt);
    //门禁出入总记录
    public Integer getDgjcCount(@Param("jczt")String jczt);

    //烟感展示
    public List<Map<String, Object>> getYgzs(@Param("page")Integer page, @Param("size")Integer size);
    //烟感展示总记录
    public List<Map<String, Object>> getYg();
    //烟感展示总数
    public Integer getYgzsCount();

    //井盖展示
    public List<Map<String, Object>> getJgzs(@Param("page")Integer page, @Param("size")Integer size);
    //井盖展示总记录
    public  List<Map<String, Object>> getJg();
    //井盖展示总数
    public Integer getJgzsCount();

    //水表展示
    public List<Map<String, Object>> getSbzs(@Param("page")Integer page, @Param("size")Integer size);
    //水表总记录
   public List<Map<String, Object>> getSb();
    //水表展示总数
    public Integer getSbzsCount();



    //新闻公告
    public List<Map<String, Object>> getXwgg(@Param("sqid") String sqid, @Param("xqid") String xqid);




}