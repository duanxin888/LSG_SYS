package com.duanxin.lsg.domain.book.entity.valueobject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategory
 * @date 2020/11/08 20:22
 */
@Setter
@Getter
@Builder
public class BookCategory {

    private int id;

    private String categoryName;

    private int sorted;
}
