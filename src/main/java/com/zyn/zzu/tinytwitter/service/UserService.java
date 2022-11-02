package com.zyn.zzu.tinytwitter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyn.zzu.common.utils.PageUtils;
import com.zyn.zzu.tinytwitter.entity.UserEntity;

import java.util.Map;

/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:10
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

