package com.zyn.zzu.tinytwitter.entity;



import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:11
 */
@Data
@Table(name = "post_comment")
public class PostCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	private Integer commentId;
	/**
	 * 推文内容
	 */
	private String comment;
	/**
	 * 推文发布者id
	 */
	private Integer createBy;
	/**
	 * 推文发布时间
	 */
	private Date createAt;
	/**
	 * 最近被访问时间
	 */
	private Date lastVisitAt;
	/**
	 * 0-删除，1-正常
	 */
	private Integer status;

}
