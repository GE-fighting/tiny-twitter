package com.zyn.zzu.tinytwitter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyn.zzu.common.utils.PageUtils;
import com.zyn.zzu.tinytwitter.entity.FollowEntity;

import java.util.Map;

/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:11
 */
public interface FollowService extends IService<FollowEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

