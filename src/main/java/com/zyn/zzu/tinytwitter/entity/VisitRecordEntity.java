package com.zyn.zzu.tinytwitter.entity;



import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.*;

/**
 * 
 * 
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:10
 */
@Data
@Table(name = "visit_record")
public class VisitRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
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
