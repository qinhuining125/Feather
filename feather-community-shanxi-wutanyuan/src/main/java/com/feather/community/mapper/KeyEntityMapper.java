package com.feather.community.mapper;

import com.feather.community.domain.ZhsqCl;
import com.feather.community.pojo.KeyEntity;

import java.util.List;

/**
 * 查询统计的时候该转换的类型Mapper接口
 *
 * @author fancy
 * @date 2020-05-15
 */
public interface KeyEntityMapper {
    /**
     * 查询类型对象列表
     *
     * @param keyEntity
     * @return 对象集合
     */
    List<KeyEntity> selectKeyEntityList(KeyEntity keyEntity);

    /**
     * 查询类型对象列表
     *
     * @param type
     * @return 对象集合
     */
    List<KeyEntity> selectKeyEntityListByType(String type);
}
