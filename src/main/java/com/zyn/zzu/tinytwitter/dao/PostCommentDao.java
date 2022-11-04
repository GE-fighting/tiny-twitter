package com.zyn.zzu.tinytwitter.dao;

import com.zyn.zzu.tinytwitter.entity.PostCommentEntity;
//import com.baomidou.mybatisplus.core.mapper.Mapper;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * 
 * 
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:11
 */
@Mapper
public interface PostCommentDao extends BaseMapper<PostCommentEntity> {
	
}
