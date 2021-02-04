package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqCl;
import com.feather.community.domain.ZhsqFw;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqClService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 14:18
 * @description 车辆查询策略
 */
@Component
public class ZhsqClTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqClService zhsqClService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqCl zhsqCl = new ZhsqCl();
        zhsqCl.setClhm(searchEntity.getName());
        zhsqCl.setCx(searchEntity.getCx());
        List<ZhsqCl> zhsqCls = zhsqClService.selectZhsqClList(zhsqCl);
        TableDataInfo tableDataInfo = getDataTable(zhsqCls);
        return tableDataInfo;
    }
}
