package cn.java.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.java.entity.PropertyInfoEntity;
import cn.java.exception.AppException;
import cn.java.service.PropertyService;
import cn.java.util.LicenseNumberRegexUtil;
import cn.java.vo.PropertyQuery;

/**
 * @author LIXIAOWANG
 * 业务视图层 用来和前端页面交互	
 */
@Controller
public class PropertyController {
	
	@Autowired
	PropertyService ps;
	
	
	/**
	 * 物业注册方法 
	 * @param property 注册信息
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.POST,value="/propertyRegiste.do")
	@ResponseBody
	public String insert(@RequestBody PropertyInfoEntity property) {
		
		PropertyQuery query=new PropertyQuery();
		query.setWy_user(property.getWy_user());
//		boolean result=LicenseNumberRegexUtil.isLicense_18(property.getWy_business());
//		if (result!=true) {
//			return "business_error";
//		}
		
		//判断手机号是否已存在
		List<PropertyInfoEntity> comm = ps.queryByComm(query);
		if (comm==null || comm.size()!=1) {
			try {
				//注册
				ps.insert(property);
				return "success";
			} catch (AppException e) {
				// TODO Auto-generated catch block
				return "error";
			}
		}
		return "nonunique";
	}
	
//	@RequestMapping(method=RequestMethod.GET, value="/propertylogin.do")
//	@ResponseBody
//	public String PropertyLogin(PropertyQuery query,HttpSession session) {
//		
//		List<Property> login = ps.queryByComm(query);
//		if (login==null || login.size()!=1) {
//			return "error";
//		}
//		session.setAttribute("USER", login);
//		return "success";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
