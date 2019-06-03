package cn.java.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 帖子信息实体类
 * @author LIXIAOWANG
 *
 */
@Data
public class PostInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3987204706297568958L;
	
	private int id;		//帖子id
	private String title; //帖子标题
	private String content;//帖子内容
	private int typeId;		//帖子类型id
	private int userId;		//发帖人id
	private Date createTime;//发帖时间
	private Date updateTime;//修改时间


}
