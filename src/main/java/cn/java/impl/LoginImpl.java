package cn.java.impl;




import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

/**
 * zxc
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.LoginDao;
import cn.java.entity.LoginEntity;
import cn.java.service.LoginService;
@Service
@Transactional
public class LoginImpl implements LoginService{
	@Autowired
	LoginDao logindao;

	
	
	//查询goods表所有数据
	@Override
	public List<LoginEntity> getqAllGoods() {
		return logindao.getAllGoods();
	}



	@Override
	public String getqw() {
		return logindao.getqw();
		
		
	}


	
}
