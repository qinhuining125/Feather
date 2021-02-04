package com.feather.generator.domain;

import javax.validation.constraints.NotBlank;

import com.feather.common.constant.FeatherConstants;
import com.feather.common.core.domain.BaseEntity;
import com.feather.common.utils.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 代码生成业务字段表 gen_table_column
 * 
 * @author feather
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenTableColumn extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long columnId;

    /** 归属表编号 */
    private Long tableId;

    /** 列名称 */
    private String columnName;

    /** 列描述 */
    private String columnComment;

    /** 列类型 */
    private String columnType;

    /** JAVA类型 */
    private String javaType;

    /** JAVA字段名 */
    @NotBlank(message = "Java属性不能为空")
    private String javaField;

    /** 是否主键（1是） */
    private Byte isPk;

    /** 是否自增（1是） */
    private Byte isIncrement;

    /** 是否必填（1是） */
    private Byte isRequired;

    /** 是否为插入字段（1是） */
    private Byte isInsert;

    /** 是否编辑字段（1是） */
    private Byte isEdit;

    /** 是否列表字段（1是） */
    private Byte isList;

    /** 是否查询字段（1是） */
    private Byte isQuery;

    /** 查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围） */
    private String queryType;

    /** 显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件） */
    private String htmlType;

    /** 字典类型 */
    private String dictType;

    /** 排序 */
    private Integer sort;

    public boolean isPk() {
        return FeatherConstants.isTrue(isPk);
    }

    public boolean isInsert() {
        return FeatherConstants.isTrue(isInsert);
    }

    public boolean isEdit() {
        return FeatherConstants.isTrue(isEdit);
    }

    public boolean isList() {
        return FeatherConstants.isTrue(isList);
    }

    public boolean isQuery() {
        return FeatherConstants.isTrue(isQuery);
    }

    public boolean isSuperColumn() {
        return isSuperColumn(this.javaField);
    }

    public static boolean isSuperColumn(String javaField) {
        return StringUtils.equalsAnyIgnoreCase(javaField, "createBy", "createByid", "createTime", "updateBy",
                "updateByid", "updateTime", "remark");
    }

    public String readConverterExp() {
        String remarks = StringUtils.substringBetween(this.columnComment, "（", "）");
        StringBuffer sb = new StringBuffer();
        if (StringUtils.isNotEmpty(remarks)) {
            for (String value : remarks.split(" ")) {
                if (StringUtils.isNotEmpty(value)) {
                    Object startStr = value.subSequence(0, 1);
                    String endStr = value.substring(1);
                    sb.append("").append(startStr).append("=").append(endStr).append(",");
                }
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            return this.columnComment;
        }
    }
}