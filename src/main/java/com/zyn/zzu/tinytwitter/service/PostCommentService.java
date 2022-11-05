package com.zyn.zzu.tinytwitter.service;


import com.zyn.zzu.common.utils.R;

import java.util.List;

/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:11
 */
public interface PostCommentService {



    R postTweet(int userId, int contentId);

    List<Integer> getNewsFeed(int userId);
}

