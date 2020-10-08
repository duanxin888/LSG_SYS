package com.duanxin.lsg.persistent.module;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccount
 * @date 2020/10/08 19:43
 */
@Setter
@Getter
public class UserAccount {

    private int id;

    private String accountSn;

    private BigDecimal balance;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
