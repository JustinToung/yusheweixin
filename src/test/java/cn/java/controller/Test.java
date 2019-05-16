package cn.java.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.java.entity.UserInfoEntity;
import cn.java.service.UserInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
	
	@Autowired
	UserInfoService us;
	
	@org.junit.Test
	public void testQueryUserInfo() {
		UserInfoEntity queryByOpenId = us.queryByOpenId("1000");
		System.out.println(queryByOpenId.getOpenId());
		
	}

}
