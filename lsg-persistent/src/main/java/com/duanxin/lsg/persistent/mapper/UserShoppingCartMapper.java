package com.duanxin.lsg.persistent.mapper;

import com.duanxin.lsg.persistent.module.UserShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserShoppingCartMapper
 * @date 2020/10/24 16:50
 */
public interface UserShoppingCartMapper {

    List<UserShoppingCart> selectCartsByUserId(@Param("userId") int userId);

    void insert(@Param("cart") UserShoppingCart cart);

    void updateCartQuantity(@Param("userId") int userId,
                            @Param("bookId") int bookId,
                            @Param("levelName") String levelName,
                            @Param("quantity") int quantity);
}
