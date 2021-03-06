package cn.java.service;

import cn.java.entity.UserInfoEntity;

/**
 * 用户信息业务逻辑接口类
 * 
 * @author LIXIAOWANG
 *
 */
public interface UserInfoService {
	// 通过用户openId查询
	public UserInfoEntity queryByOpenId(String openId);

	// 新增用户
	public int insertUserInfo(UserInfoEntity user);

	// 修改用户信息
	public int updateUserInfo(UserInfoEntity user);

	// 加入社区
	public int joinCommunity(int communityId, int userId);
	//通过id查询用户信息
	public UserInfoEntity selectById(int id);
	//查询每个社区的人数
	public int queryCount(int communityId);
}
