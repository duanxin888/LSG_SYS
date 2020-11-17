package com.duanxin.lsg.infrastructure.utils;
import	java.text.NumberFormat;

import com.duanxin.lsg.infrastructure.common.enums.SerialNumberEnum;
import com.duanxin.lsg.infrastructure.common.enums.VersionEnum;

import java.text.NumberFormat;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className SnUtil
 * @date 2020/11/17 20:50
 */
public class SnUtil {

    private SnUtil() {

    }

    /**
     * order sn: 用户id(11位) + 年月日时分秒(16位) + 订单编号(2位)
     * */
    public static String generateOrderSn(int userId) {
        LocalDateTime now = LocalDateTime.now();
        NumberFormat format = NumberFormat.getInstance();
        return new StringBuilder(numberFormat(format, 11, userId)).
                append(numberFormat(format, 4, now.getYear())).
                append(numberFormat(format, 2, now.getMonthValue())).
                append(numberFormat(format, 2, now.getDayOfMonth())).
                append(numberFormat(format, 2, now.getHour())).
                append(numberFormat(format, 2, now.getMinute())).
                append(numberFormat(format, 2, now.getSecond())).
                append(VersionEnum.ORDER_SN_VERSION.getVersionId()).
                toString();
    }

    /**
     * account sn: 账户编号标识(2位) + 年月日时分秒(16位) + 版本号(2位)
     * */
    public static String generateAccountSn() {
        LocalDateTime now = LocalDateTime.now();
        NumberFormat format = NumberFormat.getInstance();
        return new StringBuilder(SerialNumberEnum.ACCOUNT_SN.getSn()).
                append(numberFormat(format, 4, now.getYear())).
                append(numberFormat(format, 2, now.getMonthValue())).
                append(numberFormat(format, 2, now.getDayOfMonth())).
                append(numberFormat(format, 2, now.getHour())).
                append(numberFormat(format, 2, now.getMinute())).
                append(numberFormat(format, 2, now.getSecond())).
                append(VersionEnum.ACCOUNT_SN_VERSION.getVersionId()).
                toString();
    }

    private static String numberFormat(NumberFormat format, int size, int num) {
        format.setGroupingUsed(false);
        format.setMinimumIntegerDigits(size);
        format.setMaximumIntegerDigits(size);
        return format.format(num);
    }
}
