package cn.java.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户信息实体类
 * @author LIXIAOWANG
 *
 */
@Data
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
	
}
