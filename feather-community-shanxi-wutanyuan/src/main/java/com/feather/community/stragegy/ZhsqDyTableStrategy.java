package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqDy;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqDyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 14:25
 * @description 智慧社区党员查询策略
 */
@Component
public class ZhsqDyTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqDyService zhsqDyService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqDy zhsqDy = new ZhsqDy();
        zhsqDy.setXm(searchEntity.getName());
        List<ZhsqDy> zhsqDys = zhsqDyService.selectZhsqDyList(zhsqDy);
        TableDataInfo tableDataInfo = getDataTable(zhsqDys);
        return tableDataInfo;
    }
}
