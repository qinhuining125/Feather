package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqDzz;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqDzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 14:23
 * @description 党组织查询策略
 */
@Component
public class ZhsqDzzTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqDzzService zhsqDzzService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqDzz zhsqDzz = new ZhsqDzz();
        zhsqDzz.setMc(searchEntity.getName());
        List<ZhsqDzz> zhsqDzzs = zhsqDzzService.selectZhsqDzzList(zhsqDzz);
        TableDataInfo tableDataInfo = getDataTable(zhsqDzzs);
        return tableDataInfo;
    }
}
