package com.zyn.zzu.tinytwitter.dao;

import com.zyn.zzu.tinytwitter.entity.VisitRecordEntity;


import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
 * 
 * 
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:10
 */
@Repository
public interface VisitRecordDao extends Mapper<VisitRecordEntity> {
	
}
