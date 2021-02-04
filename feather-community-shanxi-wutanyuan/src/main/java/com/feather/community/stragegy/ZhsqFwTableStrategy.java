package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqFw;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqFwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 14:10
 * @description 房屋查询策略
 */
@Component
public class ZhsqFwTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqFwService zhsqFwService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqFw zhsqFw = new ZhsqFw();
        zhsqFw.setLdid(searchEntity.getLdid());
        zhsqFw.setLdmc(searchEntity.getName());
        zhsqFw.setMph(searchEntity.getMph());
        zhsqFw.setFwrzqk(searchEntity.getFwrzqk());
        List<ZhsqFw> zhsqFws = zhsqFwService.selectZhsqFwList(zhsqFw);
        TableDataInfo tableDataInfo = getDataTable(zhsqFws);
        return tableDataInfo;
    }
}
