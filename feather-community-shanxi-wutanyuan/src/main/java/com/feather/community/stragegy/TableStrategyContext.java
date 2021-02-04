package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.pojo.SearchEntity;
import org.springframework.stereotype.Component;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 11:49
 * @description 表查询策略
 */
@Component
public class TableStrategyContext {
    private TableStrategy tableStrategy;

    public void setTableStrategy(TableStrategy tableStrategy) {
        this.tableStrategy = tableStrategy;
    }

    public TableDataInfo handle(SearchEntity searchEntity) {
        return tableStrategy.tableQueryStrategy(searchEntity);
    }
}
