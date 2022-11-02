package com.zyn.zzu.tinytwitter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyn.zzu.common.utils.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.zyn.zzu.tinytwitter.dao.FollowDao;
import com.zyn.zzu.tinytwitter.entity.FollowEntity;
import com.zyn.zzu.tinytwitter.service.FollowService;


@Service("followService")
public class FollowServiceImpl extends ServiceImpl<FollowDao, FollowEntity> implements FollowService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FollowEntity> page = this.page(
                new Page<>(),
                new QueryWrapper<FollowEntity>()
        );

        return new PageUtils(page);
    }

}