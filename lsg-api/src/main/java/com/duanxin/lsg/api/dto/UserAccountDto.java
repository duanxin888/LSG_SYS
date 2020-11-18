package com.duanxin.lsg.api.dto;

import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccountDto
 * @date 2020/11/18 10:21
 */
@Setter
@Getter
public class UserAccountDto {

    private int id;

    private int userId;

    private String accountSn;

    private BigDecimal balance;
}
