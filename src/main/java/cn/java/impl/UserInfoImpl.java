package cn.java.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.java.dao.UserInfoDao;
import cn.java.entity.UserInfoEntity;
import cn.java.service.UserInfoService;

/**
 * 用户信息业务逻辑实现类
 * @author LIXIAOWANG
 *
 */
@Service
@Transactional
public class UserInfoImpl implements UserInfoService {
	
	@Autowired
	UserInfoDao userInfoDao;
	
	/**
	 * 通过用户openId查询
	 * @param 传入的openId
	 * @return 返回查询到的信息
	 */
	public UserInfoEntity queryByOpenId(String openId) {
		// TODO Auto-generated method stub
		return userInfoDao.queryByOpenId(openId);
	}

	/**
	 * 新增用户
	 * @param 传入的参数
	 * @return 返回成功结果
	 */
	public int insertUserInfo(UserInfoEntity user) {
		int result = userInfoDao.insertUserInfo(user);
		return result;
	}

	/**
	 * 修改用户信息
	 * @param 传入的参数
	 * @return 返回成功结果
	 */
	public int updateUserInfo(UserInfoEntity user) {
		int result = userInfoDao.updateUserInfo(user);
		return result;
	}

	/**
	 * 加入社区
	 */
	@Transactional(rollbackFor=Exception.class)
	public int joinCommunity(int communityId, int userId) {
		return userInfoDao.joinCommunity(communityId, userId);
	}

	/**
	 * 通过id查询用户信息
	 * @param 传入的参数
	 * @return 返回成功结果
	 */
	public UserInfoEntity selectById(int id) {
		return userInfoDao.selectById(id);
	}

	/**
	 * 通过社区id查询每个社区的人数
	 * @param 传入的参数
	 * @return 返回成功结果
	 */
	public int queryCount(int communityId) {
		// TODO Auto-generated method stub
		return userInfoDao.queryCount(communityId);
	}

}
