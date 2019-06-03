package cn.java.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 物业实体类
 * @author LIXIAOWANG
 *
 */
@Data
public class Property implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4894871198026358143L;
	
	private int id;
	private String wy_user;//物业
	private String wy_pwd;//密码
	private String wy_business;//营业执照
	private String wy_project;//入驻项目
	private  String wy_admin;//管理人员

}
