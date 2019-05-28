package cn.java.entity;

import java.io.Serializable;

/**
 * 物业实体类
 * @author LIXIAOWANG
 *
 */
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWy_user() {
		return wy_user;
	}
	public void setWy_user(String wy_user) {
		this.wy_user = wy_user;
	}
	public String getWy_pwd() {
		return wy_pwd;
	}
	public void setWy_pwd(String wy_pwd) {
		this.wy_pwd = wy_pwd;
	}
	public String getWy_business() {
		return wy_business;
	}
	public void setWy_business(String wy_business) {
		this.wy_business = wy_business;
	}
	public String getWy_project() {
		return wy_project;
	}
	public void setWy_project(String wy_project) {
		this.wy_project = wy_project;
	}
	public String getWy_admin() {
		return wy_admin;
	}
	public void setWy_admin(String wy_admin) {
		this.wy_admin = wy_admin;
	}
	
	

}
