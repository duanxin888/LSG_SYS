package com.duanxin.lsg.infrastructure.repository.mapper;

import com.duanxin.lsg.infrastructure.repository.po.UserShoppingCartPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author duanxin
 * @version 1.0
 * @className UserShoppingCartMapper
 * @date 2020/10/24 16:50
 */
public interface UserShoppingCartMapper {

    List<UserShoppingCartPO> selectCartsByUserId(@Param("userId") int userId);

    void insert(@Param("cart") UserShoppingCartPO cart);

    void updateCartQuantity(@Param("userId") int userId,
                            @Param("bookId") int bookId,
                            @Param("levelName") String levelName,
                            @Param("quantity") int quantity,
                            @Param("deleted") int deleted);

    UserShoppingCartPO selectByUserIdAndBookIdAndLevelId(@Param("userId") int userId,
                                                         @Param("bookId") int bookId,
                                                         @Param("bookLevelName") String bookLevelName);

    void updateUserCartStatus(@Param("userId") int userId,
                              @Param("bookId") int bookId,
                              @Param("bookLevelName") String bookLevelName,
                              @Param("deleted") int deleted);
}
