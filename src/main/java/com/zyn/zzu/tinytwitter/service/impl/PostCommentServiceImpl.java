package com.zyn.zzu.tinytwitter.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyn.zzu.common.utils.R;
import com.zyn.zzu.tinytwitter.dao.FollowDao;
import com.zyn.zzu.tinytwitter.dao.UserDao;
import com.zyn.zzu.tinytwitter.entity.FollowEntity;
import com.zyn.zzu.tinytwitter.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyn.zzu.common.utils.PageUtils;

import com.zyn.zzu.tinytwitter.dao.PostCommentDao;
import com.zyn.zzu.tinytwitter.entity.PostCommentEntity;
import com.zyn.zzu.tinytwitter.service.PostCommentService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;


@Service
public class PostCommentServiceImpl extends ServiceImpl<PostCommentDao, PostCommentEntity> implements PostCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PostCommentEntity> page = this.page(
                new Page<>(),
                new QueryWrapper<PostCommentEntity>()
        );

        return new PageUtils(page);
    }

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
            public List<Integer> getNewsFeed(int userId) {
                UserEntity user = userDao.selectById(userId);
                if (user == null) {
                    throw new RuntimeException("该用户不存在!");
                }
                //1、用户 id 和他关注的用户列表id
                //todo 用sql
                FollowEntity followList = followDao.selectById(userId);
                List<Integer> idList = followList.stream().map(FollowEntity::getfolloweeId).collect(Collectors.toList());
                //2、如果关注列表是空，直接返回用户自己的推文
                if(CollectionUtils.isEmpty(idList)){
                    return new ArrayList<>();
                }
                idList.add(userId);
                List<Integer> res = new ArrayList<>(15);
                //3、查询用户关注的人或者是用户自己发布的推文，根据时间排序
                Example example = new Example(PostCommentEntity.class);
                example.setOrderByClause("create_time desc");
                Example.Criteria criteria = example.createCriteria();
                criteria.andIn("id", idList);
                res = postCommentDao.selectByExample(example);
                //todo提取前15条
                return res;
            }

}