package com.duanxin.lsg.infrastructure.client.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className AlISBNResult
 * @date 2020/11/22 21:46
 */
@Setter
@Getter
public class AlISBNResult {

    private String reason;

    private BookResult result;

    @JsonProperty("error_code")
    private int errorCode;

    @Getter
    @Setter
    public static class BookResult {

        @JsonProperty("title")
        private String bookName;

        @JsonProperty("author")
        private String bookAuthor;

        @JsonProperty("images_medium")
        private String bookPic;

        @JsonProperty("summary")
        private String bookDetails;

        @JsonProperty("price")
        private String price;

        @JsonProperty("isbn10")
        private String bookISBN10;

        @JsonProperty("isbn13")
        private String bookISBN13;
    }
}
