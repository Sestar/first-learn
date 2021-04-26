package com.sestar.bootmultiple.mapstrut.convert;

import org.apache.http.client.utils.DateUtils;

import java.util.Date;

/**
 * 用于 mapstrut 对象转换的基本工具类
 *
 * @author zhangxinxin
 * @date 2019/5/6 19:58
 **/
public class BaseConvertor {

    /**
     * 时间格式
     */
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间格式
     */
    private static final String[] DEFAULT_DATE_PATTERNS = new String[] {
        DEFAULT_DATE_PATTERN
    };

    public Date asDate(String date) {
        return DateUtils.parseDate(date, DEFAULT_DATE_PATTERNS);
    }

    public String asString(Date date) {
        return DateUtils.formatDate(date, DEFAULT_DATE_PATTERN);
    }

}
