package com.duanxin.lsg.domain.user.entity;

import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.domain.user.entity.valueobject.Gender;
import com.duanxin.lsg.domain.user.entity.valueobject.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserDO
 * @date 2020/11/06 19:55
 */
@Setter
@Getter
public class UserDO {

    private Integer id;

    private String userName;

    private String password;

    private String phone;

    private String userImgUrl;

    private UserAccountDO userAccount;

    private String nickname;

    private String wxOpenid;

    private String wxSessionKey;

    private UserStatus status;

    private Deleted deleted;

    private Gender gender;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;

    private List<UserAddressDO> userAddressDOS;

    private String thirdSession;

    public UserDO create(UserAccountDO userAccountDO, String openid, String sessionKey) {
        this.setStatus(UserStatus.AVAILABLE);
        this.setDeleted(Deleted.NOT_DELETE);
        this.setCdate(LocalDateTime.now());
        this.setCreator(ConstantEnum.CREATOR.getKey());
        this.setEdate(LocalDateTime.now());
        this.setEditor(ConstantEnum.CREATOR.getKey());
        this.setUserAccount(userAccountDO);
        this.setWxOpenid(openid);
        this.setWxSessionKey(sessionKey);
        return this;
    }
}
