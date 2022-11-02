package com.zyn.zzu.tinytwitter.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyn.zzu.tinytwitter.entity.FollowEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyn.zzu.common.utils.PageUtils;
import com.zyn.zzu.common.utils.Query;

import com.zyn.zzu.tinytwitter.dao.PostCommentDao;
import com.zyn.zzu.tinytwitter.entity.PostCommentEntity;
import com.zyn.zzu.tinytwitter.service.PostCommentService;


@Service("postCommentService")
public class PostCommentServiceImpl extends ServiceImpl<PostCommentDao, PostCommentEntity> implements PostCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PostCommentEntity> page = this.page(
                new Page<>(),
                new QueryWrapper<PostCommentEntity>()
        );

        return new PageUtils(page);
    }

}