package com.zyn.zzu.tinytwitter.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.zyn.zzu.common.utils.R;
import com.zyn.zzu.tinytwitter.dao.VisitRecordDao;

import com.zyn.zzu.tinytwitter.entity.VisitRecordEntity;
import com.zyn.zzu.tinytwitter.service.LruCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.zyn.zzu.tinytwitter.service.VisitRecordService;
import tk.mybatis.mapper.entity.Example;


@Service("visitRecordService")
public class VisitRecordServiceImpl implements VisitRecordService {
    @Autowired
    private VisitRecordDao visitRecordDao;

    LruCache lru = new LruCache(100);


    @Override
    public R vistContent(Integer contentId) {
        //从数据库找到当日100个数据,最经常访问的，put 再get
        List<Integer> res = getContents();
        if (res != null) {
            for (int i = 0; i < res.size() - 1; i++) {
                lru.put(res.get(i));
            }
        }
        lru.get(contentId);
        return R.ok();
    }

    public List<Integer> getContents() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date time = calendar.getTime();
        Example example = new Example(VisitRecordEntity.class);
        example.createCriteria().andGreaterThan("visitAt", time);

        List<Integer> list = visitRecordDao.selectByExample(example)
                .stream().collect(Collectors.groupingBy(VisitRecordEntity::getPostCommentId))
                .entrySet().stream().map(entry -> {
                    JSONObject object = new JSONObject();
                    object.put("contentId", entry.getKey());
                    object.put("size", entry.getValue().size());
                    return object;
                }).sorted(Comparator.comparing(obj -> ((JSONObject) obj).getInteger("size")).reversed())
                .map(obj -> obj.getInteger("contentId")).collect(Collectors.toList());
        if (list.size() > 100) {
            return list.subList(0, 100);
        }
        return list;
    }

    @Override
    public List<Integer> getHotContents() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date time = calendar.getTime();
        Example example = new Example(VisitRecordEntity.class);
        example.createCriteria().andGreaterThan("visitAt", time);

        List<Integer> list = visitRecordDao.selectByExample(example)
                .stream().collect(Collectors.groupingBy(VisitRecordEntity::getPostCommentId))
                .entrySet().stream().map(entry -> {
                    JSONObject object = new JSONObject();
                    object.put("contentId", entry.getKey());
                    object.put("size", entry.getValue().size());
                    return object;
                }).sorted(Comparator.comparing(obj -> ((JSONObject) obj).getInteger("size")).reversed())
                .map(obj -> obj.getInteger("contentId")).collect(Collectors.toList());
        if (list.size() > 15) {
            return list.subList(0, 15);
        }
        return list;
    }
}