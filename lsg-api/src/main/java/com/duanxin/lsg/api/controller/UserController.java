package com.duanxin.lsg.api.controller;

import com.duanxin.lsg.api.module.WXLoginRequest;
import com.duanxin.lsg.api.service.WXService;
import com.duanxin.lsg.core.base.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author duanxin
 * @version 1.0
 * @className UserController
 * @date 2020/10/06 08:29
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private WXService wxService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody WXLoginRequestDto wxLoginRequestDto) {
        return ResponseResult.success(wxService.login(wxLoginRequestDto));
    }
}
