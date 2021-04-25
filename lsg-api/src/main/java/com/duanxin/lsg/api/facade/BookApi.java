package com.duanxin.lsg.api.facade;

import com.duanxin.lsg.api.assembler.BookAssembler;
import com.duanxin.lsg.api.assembler.BookCategoryAssembler;
import com.duanxin.lsg.api.assembler.RecycleOrderAssembler;
import com.duanxin.lsg.api.assembler.RecycleOrderDetailsAssembler;
import com.duanxin.lsg.api.dto.BookDto;
import com.duanxin.lsg.infrastructure.common.enums.SearchType;
import com.duanxin.lsg.application.service.BookApplicationService;
import com.duanxin.lsg.application.service.RecycleOrderApplicationService;
import com.duanxin.lsg.application.service.SearchApplicationService;
import com.duanxin.lsg.domain.book.entity.BookCategoryDO;
import com.duanxin.lsg.domain.book.entity.BookDO;
import com.duanxin.lsg.domain.recycleOrder.entity.RecycleOrderDO;
import com.duanxin.lsg.infrastructure.common.api.ResponseResult;
import com.duanxin.lsg.infrastructure.common.exception.LSGCheckException;
import com.duanxin.lsg.infrastructure.common.exception.ResultEnum;
import org.apache.commons.lang3.math.NumberUtils;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className BookController
 * @date 2020/10/12 22:07
 */
@RestController
@RequestMapping("/api/v1/books")
public class BookApi {

    @Autowired
    private BookApplicationService bookApplicationService;
    @Autowired
    private RecycleOrderApplicationService recycleOrderApplicationService;
    @Autowired
    private SearchApplicationService searchApplicationService;
    @Autowired
    private StringEncryptor stringEncryptor;

    @GetMapping
    public ResponseResult encrypt(String str) {
        return ResponseResult.success(stringEncryptor.encrypt(str));
    }

    @GetMapping("/search/{searchContent}/type/{searchType}")
    public ResponseResult searchBook(@PathVariable("searchContent") String searchContent,
                                     @PathVariable("searchType") SearchType searchType) {
        return ResponseResult.success(searchApplicationService.search(searchContent, searchType).
                stream().map(BookAssembler::toDto).collect(Collectors.toList()));
    }

    @PutMapping("/users/{userId}/recycling")
    public ResponseResult submitRecyclingOrder(@PathVariable("userId") int userId) {
        recycleOrderApplicationService.submitRecyclingOrder(userId);
        return ResponseResult.success();
    }

    @DeleteMapping("/recycle/details/{detailsId}")
    public ResponseResult deleteRecycleOrderDetails(@PathVariable("detailsId") int detailsId) {
        recycleOrderApplicationService.deleteRecycleOrderDetails(detailsId);
        return ResponseResult.success();
    }

    @PostMapping("/users/{userId}/recycle/{isbn}")
    public ResponseResult addRecycleBook(@PathVariable("userId") int userId,
                                         @PathVariable("isbn") String isbn) {
        if (!(isbn.length() == 10 || isbn.length() == 13) || !NumberUtils.isDigits(isbn)) {
            throw new LSGCheckException(ResultEnum.RECYCLE_BOOK_ISBN_IS_NOT_RULE);
        }
        return ResponseResult.success(RecycleOrderDetailsAssembler.toDto(
                recycleOrderApplicationService.addRecycleBook(userId, isbn)));
    }

    @GetMapping("/users/{userId}/recycling")
    public ResponseResult getRecyclingOrders(@PathVariable("userId") int userId) {
        RecycleOrderDO recycleOrder = recycleOrderApplicationService.getRecyclingOrders(userId);
        if (Objects.isNull(recycleOrder)) {
            return ResponseResult.success();
        }
        return ResponseResult.success(RecycleOrderAssembler.toDto(recycleOrder));
    }

    @GetMapping("/users/{userId}/recycled")
    public ResponseResult getRecycledOrders(@PathVariable("userId") int userId) {
        return ResponseResult.success(recycleOrderApplicationService.getRecycledOrders(userId).stream().
                map(RecycleOrderAssembler::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/categories")
    public ResponseResult categories() {
        List<BookCategoryDO> categories = bookApplicationService.categories();
        return ResponseResult.success(categories.stream().map(BookCategoryAssembler::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseResult bookInfo(@PathVariable("id") int bookId) {
        return ResponseResult.success(BookAssembler.toDto(bookApplicationService.getBookInfoById(bookId)));
    }

    @GetMapping("/categories/{id}")
    public ResponseResult booksByCategory(@PathVariable("id") int categoryId) {
        List<BookDO> bookDOS = bookApplicationService.getBooksByCategoryId(categoryId);
        return ResponseResult.success(bookDOS.stream().map(BookAssembler::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/levels/{id}")
    public ResponseResult showBookLevels(@PathVariable("id") int bookId) {
        return ResponseResult.success(BookAssembler.toDto(bookApplicationService.getLevelsByBookId(bookId)));
    }
}
