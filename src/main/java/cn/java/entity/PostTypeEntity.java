package cn.java.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 帖子类型实体类
 * @author LIXIAOWANG
 *
 */
@Data
public class PostTypeEntity implements Serializable {

	/**
	 *    
	 */
	private static final long serialVersionUID = 7475429211715043489L;
	
	private int idp;//类型id 
	private String name;//帖子名称
	private String description;//帖子描述

}
