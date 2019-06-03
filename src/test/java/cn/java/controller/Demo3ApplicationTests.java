package cn.java.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.java.entity.PropertyInfoEntity;
import cn.java.exception.AppException;
import cn.java.service.PropertyService;
import cn.java.vo.PropertyQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo3ApplicationTests {

	
	public void contextLoads() {
		System.out.println("测试");
	}
	@Autowired
	PropertyService ps;
	
	
	public void testInsert() {
		PropertyInfoEntity property =new PropertyInfoEntity();
		property.setWy_user("qwe");
		property.setWy_pwd("qwe");
		property.setWy_business("qwe");
		property.setWy_project("qwe");
		property.setWy_admin("qwe");
		try {
			ps.insert(property);
			System.out.println("成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	@Test
	public void testQueryComm() {
		PropertyQuery query=new PropertyQuery();
		query.setWy_user("1");
		ps.queryByComm(query);
		System.out.println("success");
	}

}
