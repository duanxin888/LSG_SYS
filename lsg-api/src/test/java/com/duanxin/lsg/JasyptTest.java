package com.duanxin.lsg;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author duanxin
 * @version 1.0
 * @className JasyptTest
 * @date 2020/11/25 20:54
 */
@SpringBootTest
public class JasyptTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void encrypt() {
        System.out.println(stringEncryptor.encrypt("weiming19990304"));
        System.out.println(stringEncryptor.encrypt("18870735026@163.com"));
    }
}
