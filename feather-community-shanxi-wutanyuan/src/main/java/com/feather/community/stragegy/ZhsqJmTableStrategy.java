package com.feather.community.stragegy;

import com.feather.common.core.page.TableDataInfo;
import com.feather.community.domain.ZhsqJm;
import com.feather.community.pojo.SearchEntity;
import com.feather.community.service.IZhsqJmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-16 11:52
 * @description 居民查询策略
 */
@Component
public class ZhsqJmTableStrategy extends AbstraceTableStrategy {
    @Autowired
    IZhsqJmService zhsqJmService;

    @Override
    public TableDataInfo tableQueryStrategy(SearchEntity searchEntity) {
        ZhsqJm zhsqJm = new ZhsqJm();
        zhsqJm.setXm(searchEntity.getName());
        zhsqJm.setSfdj(searchEntity.getSfdj());
        zhsqJm.setSfkc(searchEntity.getSfkc());
        zhsqJm.setSfxmsf(searchEntity.getSfxmsf());
        zhsqJm.setSftyjr(searchEntity.getSftyjr());
        zhsqJm.setSfdb(searchEntity.getSfdb());
        zhsqJm.setSfcj(searchEntity.getSfcj());
        zhsqJm.setSfcz(searchEntity.getSfcz());
        List<ZhsqJm> zhsqJms = zhsqJmService.selectZhsqJmList(zhsqJm);
        TableDataInfo tableDataInfo = getDataTable(zhsqJms);
        return tableDataInfo;
    }
}
