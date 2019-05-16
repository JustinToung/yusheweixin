package cn.java.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 程序启动类
 * @author Administrator
 *
 */
//包扫描  controller service cn.java.controller,cn.java.service,cn.java.impl,cn.java.entity,cn.java.vo
@SpringBootApplication(scanBasePackages= {"cn.java.controller,cn.java.service,cn.java.impl,cn.java.util"})
//默认配置  
@EnableAutoConfiguration
//扫描mapper
@MapperScan(basePackages= {"cn.java.dao"})
public class Demo3Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
		System.out.println("启动成功------------------------------------");      
	}

}
