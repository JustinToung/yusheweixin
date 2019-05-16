package cn.java.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.UserInfoDao;
import cn.java.entity.UserInfoEntity;
import cn.java.service.UserInfoService;

/**
 * 用户信息业务逻辑实现类
 * @author Administrator
 *
 */
@Service
public class UserInfoImpl implements UserInfoService {
	
	@Autowired
	UserInfoDao dao;
	
	/**
	 * 通过用户openId查询
	 * @param 传入的openId
	 * @return 返回查询到的信息
	 */
	public UserInfoEntity queryByOpenId(String openId) {
		// TODO Auto-generated method stub
		return dao.queryByOpenId(openId);
	}

	/**
	 * 新增用户
	 * @param 传入的参数
	 * @return 返回成功结果
	 */
	public int insertUserInfo(UserInfoEntity user) {
		int result = dao.insertUserInfo(user);
		return result;
	}

	/**
	 * 修改用户信息
	 * @param 传入的参数
	 * @return 返回成功结果
	 */
	public int updateUserInfo(UserInfoEntity user) {
		int result = dao.updateUserInfo(user);
		return result;
	}

}
