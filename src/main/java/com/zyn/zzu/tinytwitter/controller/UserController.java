package com.zyn.zzu.tinytwitter.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyn.zzu.tinytwitter.entity.UserEntity;
import com.zyn.zzu.tinytwitter.service.UserService;
import com.zyn.zzu.common.utils.PageUtils;
import com.zyn.zzu.common.utils.R;



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

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = userService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{userId}")
//    public R info(@PathVariable("userId") Integer userId){
//		UserEntity user = userService.getById(userId);
//
//        return R.ok().put("user", user);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    public R save(@RequestBody UserEntity user){
//		userService.save(user);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody UserEntity user){
//		userService.updateById(user);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Integer[] userIds){
//		userService.removeByIds(Arrays.asList(userIds));
//
//        return R.ok();
//    }

}
