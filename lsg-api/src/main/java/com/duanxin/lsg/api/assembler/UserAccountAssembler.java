package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.UserAccountDto;
import com.duanxin.lsg.domain.user.entity.UserAccountDO;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAccountAssembler
 * @date 2020/11/18 10:29
 */
public class UserAccountAssembler {

    public static UserAccountDto toDto(UserAccountDO userAccountDO, int userId) {
        UserAccountDto dto = new UserAccountDto();
        dto.setId(userAccountDO.getId());
        dto.setUserId(userId);
        dto.setAccountSn(userAccountDO.getAccountSn());
        dto.setBalance(userAccountDO.getBalance());
        return dto;
    }
}
