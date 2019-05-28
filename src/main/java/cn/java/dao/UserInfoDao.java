package cn.java.dao;

import cn.java.entity.UserInfoEntity;

/**
 * 用户信息的数据访问层
 * @author LIXIAOWANG
 *
 */
public interface UserInfoDao {
	//通过用户openId查询
	public UserInfoEntity queryByOpenId(String openId);
	//新增用户
	public int insertUserInfo(UserInfoEntity user);
	//修改用户信息
	public int updateUserInfo(UserInfoEntity user);

}
