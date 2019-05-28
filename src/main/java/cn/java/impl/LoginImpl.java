package cn.java.impl;




import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

/**
 * zxc
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.java.dao.LoginDao;
import cn.java.entity.LoginEntity;
import cn.java.service.LoginService;
@Service
@Transactional
//redis缓存注解 并取名--LoginImplCache
@CacheConfig(cacheNames= {"LoginImplCache"})
public class LoginImpl implements LoginService{
	@Autowired
	LoginDao logindao;

	
	
	//查询goods表所有数据
	@Override
	//把查询的数据存入redis缓存里面
	@Cacheable(key="'getqAllGoods'")
	public List<LoginEntity> getqAllGoods() {
		return logindao.getAllGoods();
	}



	//第二种分页方法  pageHelper
	@Override
	public List<LoginEntity> getqw() {
		return logindao.getAllGoods();
	}


	//添加数据到数据库
	@Override
	//添加时清空redis达到予数据库同步显示-删除相关的redis缓存数据
	@CacheEvict(key="'getqAllGoods'")
	public void addgood() {
		System.out.println("添加成功--------");
	}

	


	
}
