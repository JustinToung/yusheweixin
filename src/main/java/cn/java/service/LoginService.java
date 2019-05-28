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
		
		//第二种分页方法  pageHelper
		public List<LoginEntity>getqw();
		
		//添加数据到数据库  
		void addgood();
}
