package com.zyn.zzu.tinytwitter.service.impl;


import com.zyn.zzu.common.utils.R;
import com.zyn.zzu.tinytwitter.dao.FollowDao;
import com.zyn.zzu.tinytwitter.entity.FollowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


import com.zyn.zzu.tinytwitter.service.FollowService;
import tk.mybatis.mapper.entity.Example;


@Service("followService")
public class FollowServiceImpl implements FollowService {
    /**
     * 关注其他用户
     *
     * @param followerId 发起关注者 id
     * @param followeeId 被关注者 id
     */
    @Autowired
    private FollowDao followDao;

    public R follow(Integer followerId, Integer followeeId) {
        // 1、被关注人不能是自己
        if (followeeId == followerId) {
            throw new RuntimeException("自己不能关注自己哦~");
        }
        // 2、获取我自己的关注列表
        Example example = new Example(FollowEntity.class);
        example.createCriteria().andEqualTo("followerId", followerId);
        List<Integer> followingList = followDao
                .selectByExample(example).stream().map(FollowEntity::getFolloweeId).collect(Collectors.toList());
        ;
        if (followingList.contains(followeeId)) {
            throw new RuntimeException("已关注，不能重复关注呢~");
        }
        Date nowDate = new Date();
        followDao.insertSelective(new FollowEntity() {{
            setFollowerId(followerId);
            setFolloweeId(followeeId);
            setCreateAt(nowDate);
        }});
        return R.ok();
    }


    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     *
     * @param followerId 发起取消关注的人的 id
     * @param followeeId 被取消关注的人的 id
     */
    public R unFollow(Integer followerId, Integer followeeId) {
        // 1、获取我自己的关注列表
        Example example = new Example(FollowEntity.class);
        example.createCriteria().andEqualTo("followerId", followerId);
        List<Integer> followingList = followDao.selectByExample(example).stream().map(FollowEntity::getFolloweeId).collect(Collectors.toList());
        ;
        // 2、判断取消关注的人是否在关注列表里面
        if (followingList == null || !followingList.contains(followeeId)) {
            throw new RuntimeException("未关注，无法取消关注~");
        }
        // 3、取消关注即删除
        Example unfollowExample = new Example(FollowEntity.class);
        unfollowExample.createCriteria()
                .andEqualTo("followerId", followerId)
                .andEqualTo("followeeId", followeeId);
        followDao.deleteByExample(unfollowExample);
        return R.ok();
    }
}