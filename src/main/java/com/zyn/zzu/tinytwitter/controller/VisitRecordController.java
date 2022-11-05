package com.zyn.zzu.tinytwitter.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.zyn.zzu.tinytwitter.service.VisitRecordService;

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

    @RequestMapping("/getHotContents")
    public R getHotContent(){
        List<Integer> hotContents = visitRecordService.getHotContents();
        return R.ok().put("hotContentId",hotContents);
    }

    @RequestMapping("/getVisitContent")
    public R vistContent (@RequestParam Integer contentId) {
        visitRecordService.vistContent(contentId);
        return R.ok();
    }
}
