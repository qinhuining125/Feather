package com.feather.framework.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feather.common.enums.BusinessType;
import com.feather.common.enums.ResourceType;
import com.feather.system.domain.SysDictData;
import com.feather.system.service.ISysDictDataService;

/**
 * Feather首创 html调用 thymeleaf 实现字典读取
 * 
 * @author feather
 */
@Service("dict")
public class DictService {
    @Autowired
    private ISysDictDataService dictDataService;

    private List<SysDictData> operationType = new ArrayList<>();
    private List<SysDictData> resourceType = new ArrayList<>();

    public DictService() {
        // 操作类型
        SysDictData insert = new SysDictData();
        insert.setDictValue(BusinessType.INSERT.ordinal() + "");
        insert.setDictLabel(BusinessType.INSERT.getLabel());
        insert.setListClass("info");
        operationType.add(insert);

        SysDictData update = new SysDictData();
        update.setDictValue(BusinessType.UPDATE.ordinal() + "");
        update.setDictLabel(BusinessType.UPDATE.getLabel());
        update.setListClass("info");
        operationType.add(update);

        SysDictData delete = new SysDictData();
        delete.setDictValue(BusinessType.DELETE.ordinal() + "");
        delete.setDictLabel(BusinessType.DELETE.getLabel());
        delete.setListClass("danger");
        operationType.add(delete);

        SysDictData grant = new SysDictData();
        grant.setDictValue(BusinessType.GRANT.ordinal() + "");
        grant.setDictLabel(BusinessType.GRANT.getLabel());
        grant.setListClass("primary");
        operationType.add(grant);

        SysDictData export = new SysDictData();
        export.setDictValue(BusinessType.EXPORT.ordinal() + "");
        export.setDictLabel(BusinessType.EXPORT.getLabel());
        export.setListClass("warning");
        operationType.add(export);

        SysDictData imp = new SysDictData();
        imp.setDictValue(BusinessType.IMPORT.ordinal() + "");
        imp.setDictLabel(BusinessType.IMPORT.getLabel());
        imp.setListClass("warning");
        operationType.add(imp);

        SysDictData force = new SysDictData();
        force.setDictValue(BusinessType.FORCE.ordinal() + "");
        force.setDictLabel(BusinessType.FORCE.getLabel());
        force.setListClass("warning");
        operationType.add(force);

        SysDictData gencode = new SysDictData();
        gencode.setDictValue(BusinessType.GENCODE.ordinal() + "");
        gencode.setDictLabel(BusinessType.GENCODE.getLabel());
        gencode.setListClass("primary");
        operationType.add(gencode);

        SysDictData clean = new SysDictData();
        clean.setDictValue(BusinessType.CLEAN.ordinal() + "");
        clean.setDictLabel(BusinessType.CLEAN.getLabel());
        clean.setListClass("danger");
        operationType.add(clean);

        SysDictData api = new SysDictData();
        api.setDictValue(BusinessType.API.ordinal() + "");
        api.setDictLabel(BusinessType.API.getLabel());
        api.setListClass("primary");
        operationType.add(api);

        SysDictData upload = new SysDictData();
        upload.setDictValue(BusinessType.UPLOAD.ordinal() + "");
        upload.setDictLabel(BusinessType.UPLOAD.getLabel());
        upload.setListClass("info");
        operationType.add(upload);

        SysDictData download = new SysDictData();
        download.setDictValue(BusinessType.DOWNLOAD.ordinal() + "");
        download.setDictLabel(BusinessType.DOWNLOAD.getLabel());
        download.setListClass("info");
        operationType.add(download);

        SysDictData other = new SysDictData();
        other.setDictValue(BusinessType.OTHER.ordinal() + "");
        other.setDictLabel(BusinessType.OTHER.getLabel());
        other.setListClass("success");
        operationType.add(other);

        // 资源类型
        SysDictData resApi = new SysDictData();
        resApi.setDictValue(ResourceType.API.ordinal() + "");
        resApi.setDictLabel(ResourceType.API.getLabel());
        resApi.setListClass("primary");
        resourceType.add(resApi);

        SysDictData resFile = new SysDictData();
        resFile.setDictValue(ResourceType.FILE.ordinal() + "");
        resFile.setDictLabel(ResourceType.FILE.getLabel());
        resFile.setListClass("info");
        resourceType.add(resFile);

        SysDictData resProxy = new SysDictData();
        resProxy.setDictValue(ResourceType.PROXY.ordinal() + "");
        resProxy.setDictLabel(ResourceType.PROXY.getLabel());
        resProxy.setListClass("success");
        resourceType.add(resProxy);
    }

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType
     *            字典类型
     * @return 参数键值
     */
    public List<SysDictData> getType(String dictType) {
        return dictDataService.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType
     *            字典类型
     * @param dictValue
     *            字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue) {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }

    public List<SysDictData> getOperationType() {
        return operationType;
    }

    public String getOperationLabel(String opValue) {
        String label = "";
        if (opValue != null) {
            for (SysDictData dictData : operationType) {
                if (opValue.equals(dictData.getDictValue())) {
                    label = dictData.getDictLabel();
                    break;
                }
            }
        }
        return label;
    }

    public List<SysDictData> getResourceType() {
        return resourceType;
    }

    public String getResourceLabel(String resValue) {
        String label = "";
        if (resValue != null) {
            for (SysDictData dictData : resourceType) {
                if (resValue.equals(dictData.getDictValue())) {
                    label = dictData.getDictLabel();
                    break;
                }
            }
        }
        return label;
    }
}
