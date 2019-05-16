package cn.java.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息实体类
 * @author Administrator
 *
 */
public class UserInfoEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5865541071558719006L;
	
	private int id;			//用户id
	private String openId;	//用户的openId（通过微信授权登陆使产生的code appid secret js_code grant_type 获取）
	private String nickName;//微信名 （前端传过来的）
	private String gender;	//性别      （前端传过来的）
	private String telephone;//电话
	private String avatarUrl;//微信头像   （前端传过来的）
	private String province;//所在省份   （前端传过来的）
	private String city;	//所在市   （前端传过来的）
	private String address;//具体地址
	private Date createtime;//创建时间
	private Date updatetime;//修改时间
	private Date logintime;//登录时间
	private int updatecount;//修改次数（每个用户只能修改一次）
	private String unionId;//用户unionId(通过session_key,iv,encryptedData获取)
	private String username;//自己定的用户名
	private int position;//判断业主还是物业  （暂定 1 是业主 -1是物业）
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	public int getUpdatecount() {
		return updatecount;
	}
	public void setUpdatecount(int updatecount) {
		this.updatecount = updatecount;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	


}
