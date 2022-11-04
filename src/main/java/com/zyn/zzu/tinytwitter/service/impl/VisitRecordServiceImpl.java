package com.zyn.zzu.tinytwitter.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.zyn.zzu.tinytwitter.dao.VisitRecordDao;

import com.zyn.zzu.tinytwitter.entity.VisitRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.zyn.zzu.tinytwitter.service.VisitRecordService;
import tk.mybatis.mapper.entity.Example;

import javax.xml.crypto.Data;


@Service("visitRecordService")
public class VisitRecordServiceImpl implements VisitRecordService {
    @Autowired
    private VisitRecordDao visitRecordDao;

    @Override
    public List<Integer> getHotContents() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date time = calendar.getTime();
        Example example = new Example(VisitRecordEntity.class);
        example.createCriteria().andGreaterThan("visitAt",time);

        List<Integer> list = visitRecordDao.selectByExample(example)
                .stream().collect(Collectors.groupingBy(VisitRecordEntity::getPostCommentId))
                .entrySet().stream().map(entry -> {
                    JSONObject object = new JSONObject();
                    object.put("contentId", entry.getKey());
                    object.put("size", entry.getValue().size());
                    return object;
                }).sorted(Comparator.comparing(obj -> ((JSONObject) obj).getInteger("size")).reversed())
                .map(obj -> obj.getInteger("contentId")).collect(Collectors.toList());
        if (list.size()>15){
            return list.subList(0,15);
        }
        return list;
    }
}