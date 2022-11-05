package com.zyn.zzu.tinytwitter.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyn.zzu.tinytwitter.service.PostCommentService;
import com.zyn.zzu.common.utils.R;



/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:11
 */
@RestController
@RequestMapping("tinytwitter/postcomment")
public class PostCommentController {
    @Autowired
    private PostCommentService postCommentService;

    /**
     * 发布推文
     */
    @RequestMapping("/postComment")
    public R postComment(@RequestParam Integer userId, @RequestParam Integer contentId){
        postCommentService.postTweet(userId,contentId);
        return R.ok();
    }

    /**
     * 主信息流功能
     */
    @RequestMapping("/getNewsFeed")
    public R getNewsFeed(@RequestParam Integer userId){
        List<Integer> newsFeeds =  postCommentService.getNewsFeed(userId);
        return R.ok().put("userId",newsFeeds);
    }

}
