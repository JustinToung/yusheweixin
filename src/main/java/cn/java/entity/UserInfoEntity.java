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
	private String nickName;//微信名 （前端传过来的）
	private String userName;//自己定的用户名
	private String telephone;//电话
	private String yusheName;//予舍号
	private String address;//具体地址
	private String company;//公司
	private String job;//职位
	private String openId;	//用户的openId（通过微信授权登陆使产生的code appid secret js_code grant_type 获取）
	private String unionId;//用户unionId(通过session_key,iv,encryptedData获取)
	private String avatarUrl;//微信头像   （前端传过来的）
	private String province;//所在省份   （前端传过来的）
	private String city;	//所在市   （前端传过来的）
	private Date createtime;//创建时间
	private Date updatetime;//修改时间
	private Date logintime;//登录时间
	private int enable;//是否为管理员 1是管理员 0是用户
	private Date birthday;//生日
	private String gender;	//性别      （前端传过来的）
	private String password;//密码
	private String idcard;//身份证
	private String doorplate;//门牌号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getYusheName() {
		return yusheName;
	}
	public void setYusheName(String yusheName) {
		this.yusheName = yusheName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
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
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getDoorplate() {
		return doorplate;
	}
	public void setDoorplate(String doorplate) {
		this.doorplate = doorplate;
	}
	
	
	

	


}
