package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.pojo.SearchEntity;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 11:44
 * @description 表查询策略
 */
public interface TableStrategy {


    TableDataInfo tableQueryStrategy(SearchEntity searchEntity);
}
