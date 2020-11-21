package com.duanxin.lsg.domain.user.entity;

import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.common.enums.SerialNumberEnum;
import com.duanxin.lsg.infrastructure.common.enums.VersionEnum;
import com.duanxin.lsg.infrastructure.utils.HttpUtil;
import com.duanxin.lsg.infrastructure.utils.SnUtil;
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
        this.setAccountSn(SnUtil.generateAccountSn());
        this.setBalance(BigDecimal.ZERO);
        this.setDeleted(Deleted.NOT_DELETE);
        this.setCdate(LocalDateTime.now());
        this.setCreator(ConstantEnum.CREATOR.getKey());
        this.setEdate(LocalDateTime.now());
        this.setEditor(ConstantEnum.CREATOR.getKey());
        return this;
    }

    public UserAccountDO deduction(BigDecimal totalPrice) {
        this.setBalance(this.getBalance().subtract(totalPrice));
        this.setEdate(LocalDateTime.now());
        this.setEditor(HttpUtil.request().getRemoteHost());
        return this;
    }
}
