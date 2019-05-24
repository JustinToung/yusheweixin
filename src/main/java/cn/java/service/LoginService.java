package cn.java.service;

import java.util.List;

import cn.java.entity.LoginEntity;



/**
 * 
 * @author zxc
 *
 */
public interface LoginService {

	
	//查询goods表所有数据
		public List<LoginEntity> getqAllGoods();
		//2
		public String getqw();
	
}
