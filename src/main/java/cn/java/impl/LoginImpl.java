package cn.java.impl;
/**
 * zxc
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.LoginDao;
import cn.java.service.LoginService;
@Service
public class LoginImpl implements LoginService{
	@Autowired
	LoginDao logindao;


	
}
