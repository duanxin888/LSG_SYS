package com.duanxin.lsg.domain.shoppingcart.entity;

import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserShoppingCart
 * @date 2020/10/24 16:48
 */
@Setter
@Getter
@EqualsAndHashCode(exclude = {"deleted", "cdate", "creator", "edate", "editor"})
public class UserShoppingCartDO {

    private int id;

    private int userId;

    private BookInfo bookInfo;

    private Deleted deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;

    public boolean isAddCart() {
        return bookInfo.getQuantity() > 0;
    }

    public UserShoppingCartDO upQuantity(int quantity) {
        this.bookInfo.setQuantity(this.bookInfo.getQuantity() + quantity);
        return this;
    }

    public UserShoppingCartDO downQuantity(int quantity) {
        if (this.bookInfo.getQuantity() < Math.abs(quantity)) {
            this.deleted = Deleted.IS_DELETED;
        }
        this.bookInfo.setQuantity(this.bookInfo.getQuantity() + quantity);
        return this;
    }

    public UserShoppingCartDO deletedStatus() {
        this.deleted = Deleted.IS_DELETED;
        return this;
    }
}
