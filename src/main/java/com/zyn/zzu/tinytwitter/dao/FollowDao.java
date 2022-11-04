package com.zyn.zzu.tinytwitter.dao;

import com.zyn.zzu.tinytwitter.entity.FollowEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * 
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:11
 */
@Repository
public interface FollowDao extends Mapper<FollowEntity> {
	
}
