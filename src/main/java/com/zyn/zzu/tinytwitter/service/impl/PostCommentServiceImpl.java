package com.zyn.zzu.tinytwitter.service.impl;

import com.zyn.zzu.common.utils.R;
import com.zyn.zzu.tinytwitter.dao.FollowDao;
import com.zyn.zzu.tinytwitter.dao.UserDao;
import com.zyn.zzu.tinytwitter.entity.FollowEntity;
import com.zyn.zzu.tinytwitter.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;



import com.zyn.zzu.tinytwitter.dao.PostCommentDao;
import com.zyn.zzu.tinytwitter.entity.PostCommentEntity;
import com.zyn.zzu.tinytwitter.service.PostCommentService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;


@Service
public class PostCommentServiceImpl implements PostCommentService {



    @Autowired
    private PostCommentDao postCommentDao;

    @Autowired
    private FollowDao followDao;

    @Autowired
    private UserDao userDao;
        /**
         * 发送一条推文.
         *
         * @return
         */
        @Transactional(rollbackFor = Exception.class)
        @Override
        public R postTweet(int userId, int contentId) {
            Date nowDate = new Date();
            UserEntity user = userDao.selectByPrimaryKey(userId);
            if (user == null) {
                throw new RuntimeException("该用户不存在!");
            }
            PostCommentEntity postCommentEntity = new PostCommentEntity();
            postCommentEntity.setCommentId(contentId);
            postCommentEntity.setCreateBy(userId);
            postCommentEntity.setCreateAt(nowDate);
            postCommentEntity.setStatus(1);
            postCommentDao.insert(postCommentEntity);
            return new R();
        }

            /**
             * 检索当前用户新闻推送中最近  15 条推文的 ID 。
             * 新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。
             * 推文必须按照时间顺序由最近到最远排序。
             */
            @Override
            public List<Integer> getNewsFeed(int userId) {
                UserEntity user = userDao.selectByPrimaryKey(userId);
                if (user == null) {
                    throw new RuntimeException("该用户不存在!");
                }
                //1、用户 id 和他关注的用户列表id
                Example followExample = new Example(FollowEntity.class);
                followExample.createCriteria().andEqualTo("followerId",userId);
                List<FollowEntity> followList = followDao.selectByExample(followExample);
                List<Integer> idList = followList.stream().map(FollowEntity::getFolloweeId).collect(Collectors.toList());
                //2、如果关注列表是空，直接返回用户自己的推文
                if(CollectionUtils.isEmpty(idList)){
                    Example postCommentExample = new Example(PostCommentEntity.class);
                    postCommentExample.setOrderByClause("create_at desc");
                    postCommentExample.createCriteria().andEqualTo("createBy",userId);
                    List<Integer> selfCommentList = postCommentDao
                            .selectByExample(postCommentExample).stream().map(PostCommentEntity::getCommentId).collect(Collectors.toList());;
                    if (selfCommentList.size()>15) {
                        return selfCommentList.subList(0, 15);
                    }
                    return selfCommentList;
                }
                idList.add(userId);
                //3、查询用户关注的人或者是用户自己发布的推文，根据时间排序
                Example example = new Example(PostCommentEntity.class);
                example.setOrderByClause("create_at desc");
                Example.Criteria criteria = example.createCriteria();
                criteria.andIn("commentId", idList);
                List<Integer> res = postCommentDao.selectByExample(example).stream().map(PostCommentEntity::getCommentId).collect(Collectors.toList());
                if (res.size()>15) {
                    return res.subList(0, 15);
                }
                return res;
            }
}