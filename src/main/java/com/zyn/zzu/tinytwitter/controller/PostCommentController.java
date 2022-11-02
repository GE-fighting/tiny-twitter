package com.zyn.zzu.tinytwitter.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyn.zzu.tinytwitter.entity.PostCommentEntity;
import com.zyn.zzu.tinytwitter.service.PostCommentService;
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
@RequestMapping("tinytwitter/postcomment")
public class PostCommentController {
    @Autowired
    private PostCommentService postCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = postCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{commentId}")
    public R info(@PathVariable("commentId") Integer commentId){
		PostCommentEntity postComment = postCommentService.getById(commentId);

        return R.ok().put("postComment", postComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PostCommentEntity postComment){
		postCommentService.save(postComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PostCommentEntity postComment){
		postCommentService.updateById(postComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] commentIds){
		postCommentService.removeByIds(Arrays.asList(commentIds));

        return R.ok();
    }

}
