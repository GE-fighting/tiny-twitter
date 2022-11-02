package com.zyn.zzu.tinytwitter.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:10
 */
@Data
@TableName("visit_record")
public class VisitRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Integer recordId;
	/**
	 * 推文id
	 */
	private Integer postCommentId;
	/**
	 * 访问者id
	 */
	private Integer visitId;
	/**
	 * 访问时间
	 */
	private Date visitAt;

}
