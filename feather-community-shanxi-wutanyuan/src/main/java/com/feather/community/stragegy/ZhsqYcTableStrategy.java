package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqYc;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqYcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 11:52
 * @description 硬件异常查询策略
 */
@Component
public class ZhsqYcTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqYcService zhsqYcService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqYc zhsqYc=new ZhsqYc();
        List<ZhsqYc> zhsqYcs = zhsqYcService.selectZhsqYcList(zhsqYc);
        TableDataInfo tableDataInfo = getDataTable(zhsqYcs);
        return tableDataInfo;
    }
}
