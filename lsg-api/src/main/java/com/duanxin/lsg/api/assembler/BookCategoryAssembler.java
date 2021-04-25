package com.duanxin.lsg.api.assembler;

import com.duanxin.lsg.api.dto.BookCategoryDto;
import com.duanxin.lsg.domain.book.entity.BookCategoryDO;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className BookCategoryAssembler
 * @date 2020/11/08 20:49
 */
public class BookCategoryAssembler {

    public static BookCategoryDto toDto(BookCategoryDO bookCategoryDO) {
        BookCategoryDto dto = new BookCategoryDto();
        dto.setId(bookCategoryDO.getId());
        dto.setCategoryName(bookCategoryDO.getCategoryName());
        dto.setSorted(bookCategoryDO.getSorted());
        return dto;
    }

    public static BookCategoryDO toDO(BookCategoryDto dto) {
        BookCategoryDO categoryDO = new BookCategoryDO();
        BeanUtils.copyProperties(dto, categoryDO);
        return categoryDO;
    }
}
