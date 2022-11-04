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
 * @date 2022-11-02 13:11:10
 */
@Data
@Table(name="user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	private Integer userId;
	/**
	 * 用户名
	 */
	private String userName;

}
