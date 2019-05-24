package cn.java.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * 程序启动类
 * @author Administrator
 *
 */
//包扫描  controller service cn.java.controller,cn.java.service,cn.java.impl,cn.java.entity,cn.java.vo
//@SpringBootApplication(scanBasePackages= {"cn.java.controller,cn.java.service,cn.java.impl,cn.java.util"})
@SpringBootApplication(scanBasePackages= {"cn.java.controller","cn.java.impl","cn.java.service","cn.java.util","cn.java.Tasks"})
//默认配置  
@EnableAutoConfiguration
//扫描mapper
@MapperScan(basePackages= {"cn.java.dao"})
//开启redis 缓存
//扫描定时器开启器注解  ---扫描包,"cn.java.Tasks"
@EnableScheduling
public class Demo3Application extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
		System.out.println("启动成功------------------------------------");      
	}
	
	@Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}
