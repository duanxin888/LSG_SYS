package com.duanxin.lsg.domain.recycleOrder.entity;

import com.duanxin.lsg.domain.recycleOrder.entity.valueobject.RecycleBookInfo;
import com.duanxin.lsg.infrastructure.client.entity.AlISBNResult;
import com.duanxin.lsg.infrastructure.common.enums.ConstantEnum;
import com.duanxin.lsg.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className RecycleOrderDetailsDO
 * @date 2020/11/22 17:48
 */
@Setter
@Getter
public class RecycleOrderDetailsDO {

    private int id;

    private int recycleOrderId;

    private RecycleBookInfo recycleBookInfo;

    private int bookLevelId;

    private Deleted deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;

    public void create(int recycleOrderId, AlISBNResult isbnResult) {
        this.setRecycleOrderId(recycleOrderId);
        RecycleBookInfo bookInfo = new RecycleBookInfo();
        AlISBNResult.BookResult result = isbnResult.getResult();
        bookInfo.setBookName(result.getBookName());
        bookInfo.setBookAuthor(result.getBookAuthor());
        bookInfo.setBookDetails(result.getBookDetails());
        bookInfo.setBookPic(result.getBookPic());
        bookInfo.setBookISBN10(result.getBookISBN10());
        bookInfo.setBookISBN13(result.getBookISBN13());
        bookInfo.setBookPrice(new BigDecimal(result.getPrice()));

        this.setRecycleBookInfo(bookInfo);
        this.setDeleted(Deleted.NOT_DELETE);
        this.setCdate(LocalDateTime.now());
        this.setCreator(ConstantEnum.CREATOR.getKey());
        this.setEdate(LocalDateTime.now());
        this.setEditor(ConstantEnum.CREATOR.getKey());
    }
}
