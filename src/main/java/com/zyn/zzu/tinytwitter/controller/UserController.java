package com.zyn.zzu.tinytwitter.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyn.zzu.tinytwitter.service.UserService;



/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:10
 */
@RestController
@RequestMapping("tinytwitter/user")
public class UserController {
    @Autowired
    private UserService userService;
}
