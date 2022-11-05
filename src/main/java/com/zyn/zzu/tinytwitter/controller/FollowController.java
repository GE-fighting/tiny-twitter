package com.zyn.zzu.tinytwitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyn.zzu.tinytwitter.service.FollowService;
import com.zyn.zzu.common.utils.R;



/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:11
 */
@RestController
@RequestMapping("tinytwitter/follow")
public class FollowController {
//    没有实现类，所有报错，要先实现这个接口，再注入到spring容器中
    @Autowired
    private FollowService followService;

    /**
     * 关注
    */
    @RequestMapping("/follow")
    public R follow(@RequestParam Integer followerId, @RequestParam Integer followeeId){
         followService.follow(followerId, followeeId);
         return R.ok();
    }

    /**
     * 取消关注
     */
    @RequestMapping("/unfollow")
    public R unFollow(@RequestParam Integer followerId, @RequestParam Integer followeeId){
        followService.unFollow(followerId, followeeId);
        return R.ok();
    }
}
