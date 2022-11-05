package com.zyn.zzu.tinytwitter.service;



import com.zyn.zzu.common.utils.R;

import java.util.Map;

/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:11
 */
public interface FollowService  {

    R unFollow(Integer followerId, Integer followeeId);

    R follow(Integer followerId, Integer followeeId);

}

