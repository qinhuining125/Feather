package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 11:55
 * @description 抽象策略类
 */
public abstract class AbstraceTableStrategy implements TableStrategy {

    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }
}
