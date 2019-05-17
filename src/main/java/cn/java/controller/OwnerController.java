package cn.java.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.java.dto.ResultDto;
import cn.java.entity.OwnerEntity;
import cn.java.service.OwnerService;
import cn.java.util.ResultUtil;

@Controller
public class OwnerController {
	@Autowired
	private OwnerService ownerService;

	 

public String login(String yz,String psd,String confirmpsd) {
		System.out.println("手机号"+yz);
		System.out.println("密码"+psd);
		System.out.println("密码2"+confirmpsd);
		return null;
	}
	
	
	
	

	@RequestMapping(value = "/registerOwner.do", method = { RequestMethod.POST })
	@ResponseBody	
	public ResultDto<String> registerOwner(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		// 设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 星号表示所有的异域请求都可以接受，
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		// 获取微信小程序get的参数值并打印
		String yz = request.getParameter("yz");
		
	//	System.out.println(yz);
		
		String psd = request.getParameter("psd");
		String confirmpsd = request.getParameter("confirmpsd");
		// 注册信息装入ownerEntity
		OwnerEntity ownerEntity = new OwnerEntity();
		ownerEntity.setConfirmpsd(confirmpsd);
		ownerEntity.setPsd(psd);
		ownerEntity.setYz(yz);
		// String msg = ownerService.registerOwner(ownerEntity);
		//手机号空
/*		if(yz == null || yz.length() <= 0||yz.equals("")) {
			return ResultUtil.fail("手机号码不能为空");
		}*/
		
		// 手机号长度不是11位
/*		if (yz.length() != 11) {
			return ResultUtil.fail("手机号码不是11位，请重新输入");
		}
		*/
		//判断手机号正则   
		//String regex="^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\\\d{8}$";
		String regex="^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
		if (!yz.matches(regex)) {
			return ResultUtil.fail("请输入正确的手机号");
		}
		
		// 查询数据库中当前手机号的业主信息
		List<OwnerEntity> selectByYz = ownerService.selectByYz(ownerEntity.getYz());
		// System.out.println(selectByYz.size());
		if (selectByYz.size() != 0) {
			return ResultUtil.fail("该手机号已注册，请重新输入或找回密码！");
		}
		
		if (StringUtils.isBlank(ownerEntity.getPsd())) {
			return ResultUtil.fail("密码不能为空");
		}
		
		// 判断密码长度
		if (ownerEntity.getPsd().length() < 6) {
			return ResultUtil.fail("密码至少6位，请重新输入");
		}
		if (!(ownerEntity.getPsd().equals(ownerEntity.getConfirmpsd()))) {
			return ResultUtil.fail("密码不一致，请重新输入");
		}
		//调用service层的注册方法  验证是否注册成功
		ResultDto<String> registerResult = ownerService.registerOwner(ownerEntity);
		//判断注册是否成功
		if (!(registerResult.getCode().equals(ResultUtil.SUCCESS_CODE)) ){
			return ResultUtil.success("注册失败，请重新输入");
		}
		return ResultUtil.success("注册成功，请前往登录页面");

	}

}
