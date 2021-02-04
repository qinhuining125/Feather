package com.feather.community.util;

import org.apache.logging.log4j.util.Strings;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author nothing
 * @version 1.0
 * @date 2020-12-10 17:17
 * @description 数学计算
 */
public class MathUtil {

    /**
     * 计算百分比
     *
     * @param data 集合
     * @param key1
     * @param key2
     * @return
     */
    public static String getPercent(Map<String, String> data, String key1, String key2) {
        String val1 = data.get(key1);
        String val2 = data.get(key2);
        if(Strings.isNotBlank(val1) && Strings.isNotBlank(val2)){
            return getPercent(val1, val2);
        }
        return  "0.00";
    }

    public static String getPercent(String a, String b) {
        BigDecimal abd=new BigDecimal(a);
        BigDecimal bbd=new BigDecimal(b);
       return  getPercent(abd, bbd);
    }

    public static String getPercent(BigDecimal a, BigDecimal b) {
        String percent =
                b == null ? "-" :
                        b.compareTo(new BigDecimal(0)) == 0 ? "-" :
                                a == null ? "0.00" :
                                        a.multiply(new BigDecimal(100)).divide(b, 2, BigDecimal.ROUND_HALF_UP) + "";
        return percent;
    }

    public static void main(String[] args) {
        String str = getPercent(10 + "", 20 + "");
        System.out.println(str);
    }
}
