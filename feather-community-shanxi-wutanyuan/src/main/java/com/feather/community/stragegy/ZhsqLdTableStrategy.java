package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqLd;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqLdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 14:08
 * @description 楼栋查询策略
 */
@Component
public class ZhsqLdTableStrategy extends AbstraceTableStrategy{
    @Autowired
    IZhsqLdService zhsqLdService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqLd zhsqLd = new ZhsqLd();
        zhsqLd.setLdmc(searchEntity.getName());
        List<ZhsqLd> zhsqLds = zhsqLdService.selectZhsqLdList(zhsqLd);
        TableDataInfo tableDataInfo = getDataTable(zhsqLds);
        return tableDataInfo;
    }
}
