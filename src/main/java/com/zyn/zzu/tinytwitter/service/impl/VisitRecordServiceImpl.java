package com.zyn.zzu.tinytwitter.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyn.zzu.tinytwitter.entity.UserEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyn.zzu.common.utils.PageUtils;
import com.zyn.zzu.common.utils.Query;

import com.zyn.zzu.tinytwitter.dao.VisitRecordDao;
import com.zyn.zzu.tinytwitter.entity.VisitRecordEntity;
import com.zyn.zzu.tinytwitter.service.VisitRecordService;


@Service("visitRecordService")
public class VisitRecordServiceImpl extends ServiceImpl<VisitRecordDao, VisitRecordEntity> implements VisitRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<VisitRecordEntity> page = this.page(
                new Page<>(),
                new QueryWrapper<VisitRecordEntity>()
        );

        return new PageUtils(page);
    }

}