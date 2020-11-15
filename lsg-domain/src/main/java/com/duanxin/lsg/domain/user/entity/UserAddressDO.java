package com.duanxin.lsg.domain.user.entity;

import com.duanxin.lsg.domain.user.entity.valueobject.AddressAcquiescence;
import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;
import org.omg.CORBA.portable.Delegate;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressDO
 * @date 2020/11/06 20:00
 */
@Setter
@Getter
public class UserAddressDO {

    private int id;

    private String name;

    private int userId;

    private String province;

    private String city;

    private String county;

    private String addressDetails;

    private String postalCode;

    private String phone;

    private AddressAcquiescence acquiescence;

    private Deleted deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;

    public UserAddressDO create() {
        this.setDeleted(Deleted.NOT_DELETE);
        this.setCdate(LocalDateTime.now());
        this.setCreator(ConstantEnum.CREATOR.getKey());
        this.setEdate(LocalDateTime.now());
        this.setEditor(ConstantEnum.CREATOR.getKey());
        return this;
    }
}
