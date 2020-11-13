package com.duanxin.lsg.domain.user.entity;

import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.common.enums.SerialNumberEnum;
import com.duanxin.lsg.infrastructure.common.enums.VersionEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccountDO
 * @date 2020/11/07 20:13
 */
@Setter
@Getter
public class UserAccountDO {
    private int id;

    private String accountSn;

    private BigDecimal balance;

    private Deleted deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;

    public UserAccountDO create() {
        this.setAccountSn(generateAccountSn());
        this.setBalance(BigDecimal.ZERO);
        this.setDeleted(Deleted.NOT_DELETE);
        this.setCdate(LocalDateTime.now());
        this.setCreator(ConstantEnum.CREATOR.getKey());
        this.setEdate(LocalDateTime.now());
        this.setEditor(ConstantEnum.CREATOR.getKey());
        return this;
    }

    /**
     * account sn: 账户编号标识(2位) + 年月日时分秒(16位) + 版本号(2位)
     * */
    private String generateAccountSn() {
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

    private String numberFormat(NumberFormat format, int size, int num) {
        format.setGroupingUsed(false);
        format.setMinimumIntegerDigits(size);
        format.setMaximumIntegerDigits(size);
        return format.format(num);
    }
}
