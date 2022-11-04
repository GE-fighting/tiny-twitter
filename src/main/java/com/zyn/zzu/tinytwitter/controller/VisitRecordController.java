package com.zyn.zzu.tinytwitter.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyn.zzu.tinytwitter.entity.VisitRecordEntity;
import com.zyn.zzu.tinytwitter.service.VisitRecordService;
import com.zyn.zzu.common.utils.PageUtils;
import com.zyn.zzu.common.utils.R;



/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:10
 */
@RestController
@RequestMapping("tinytwitter/visitrecord")
public class VisitRecordController {
    @Autowired
    private VisitRecordService visitRecordService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = visitRecordService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{recordId}")
//    public R info(@PathVariable("recordId") Integer recordId){
//		VisitRecordEntity visitRecord = visitRecordService.getById(recordId);
//
//        return R.ok().put("visitRecord", visitRecord);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    public R save(@RequestBody VisitRecordEntity visitRecord){
//		visitRecordService.save(visitRecord);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody VisitRecordEntity visitRecord){
//		visitRecordService.updateById(visitRecord);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Integer[] recordIds){
//		visitRecordService.removeByIds(Arrays.asList(recordIds));
//
//        return R.ok();
//    }

}
