package com.zyn.zzu.tinytwitter.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyn.zzu.tinytwitter.entity.FollowEntity;
import com.zyn.zzu.tinytwitter.service.FollowService;
import com.zyn.zzu.common.utils.PageUtils;
import com.zyn.zzu.common.utils.R;



/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:11
 */
@RestController
@RequestMapping("tinytwitter/follow")
public class FollowController {
//    没有实现类，所有报错，要先实现这个接口，再注入到spring容器中
    @Autowired
    private FollowService followService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = followService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
//    @RequestMapping("/info/{id}")
//    public R info(@PathVariable("id") Integer id){
//		FollowEntity follow = followService.getById(id);
//
//        return R.ok().put("follow", follow);
//    }

    /**
     * 保存
     */
//    @RequestMapping("/save")
//    public R save(@RequestBody FollowEntity follow){
//		followService.save(follow);
//
//        return R.ok();
//    }

    /**
     * 修改
     */
//    @RequestMapping("/update")
//    public R update(@RequestBody FollowEntity follow){
//		followService.updateById(follow);
//
//        return R.ok();
//    }

    /**
     * 删除
     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Integer[] ids){
//		followService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
