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
 * @date 2022-11-02 13:11:11
 */
@Data
@Table(name = "follow")
public class FollowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	private Integer id;
	/**
	 * 关注人id
	 */
	private Integer followerId;
	/**
	 * 被关注人id
	 */
	private Integer followeeId;
	/**
	 * 关注时间
	 */
	private Date createAt;

}
