package com.feather.community.util;

import com.feather.common.core.page.TableDataInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-17 10:11
 * @description 因为long没办法转int 所以折中方案
 */
public class MyTableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private int total;

    /**
     * 列表数据
     */
    private List<?> rows;

    /**
     * 合计行
     **/
    private Object totalRow;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private int msg;

    /**
     * 表格数据对象
     */
    public MyTableDataInfo() {

    }

    public MyTableDataInfo(TableDataInfo tableDataInfo) {
        String totalStr = tableDataInfo.getTotal() + "";
        this.total = Integer.parseInt(totalStr);
        this.rows = tableDataInfo.getRows();
        this.totalRow = tableDataInfo.getTotalRow();
        this.code = tableDataInfo.getCode();
        this.msg = tableDataInfo.getMsg();
    }

    public int getTotal() {
        return total;
    }

    public void setTotals(int totals) {
        this.total = totals;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public Object getTotalRow() {
        return totalRow;
    }

    public void setTotalRows(int totalRow) {
        this.totalRow = totalRow;
    }
}
