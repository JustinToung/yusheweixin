package cn.java.controller;

import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.java.entity.LoginEntity;
import cn.java.service.LoginService;
import cn.java.util.HttpClientUtil;

/**
 * 用户登录类
 * 
 * @author zxc
 *
 */
@Controller
public class LoginController {
	// 用户名
	private String Uid = "aabbcc123";
	// 接口安全秘钥
	private String Key = "d41d8cd98f00b204e980";
	// 手机号码，
	private String smsMob = "";
	// 短信内容
	private String smsText = "";

	// 点击获取验证码 获取手机号码并发送验证码到该手机号
	@RequestMapping(method = RequestMethod.POST, value = "/getcode.do")
	@ResponseBody
	public String addphone(String wx_phone) {
		HttpClientUtil client = HttpClientUtil.getInstance();
		smsMob = wx_phone;
		smsText = "您的验证码是" + getRandNum();
		// UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
		if (result > 0) {
			System.out.println("UTF8成功发送条数==" + result);
		} else {
			System.out.println(client.getErrorMsg(result));
		}
		System.out.println("随机验证码" + smsText);
		return wx_phone;
	}

	// 生成一个6位随机数 作为验证码发送给用户
	public String getRandNum() {
		Random random = new Random();
		String rt = "";
		for (int i = 0; i < 6; i++) {
			rt += random.nextInt(10);
		}
		return rt;
	}

	/**
	 * 点击 登陆 获取验证码进行判断是否输入正确
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/denglu.do")
	@ResponseBody
	public String register(String wx_phone, String wx_yanzheng, HttpSession sess) {
		// 截取字符串进行对比
		String sms = smsText;
		int i = 6;
		sms = sms.substring(i);
		if (wx_yanzheng.equals(sms)) {
			return "登录成功";
		} else {
			return "登录失败，请重新登录";
		}
	}

	// 测试------------------------------------------------------------------------------------

	@Autowired
	private LoginService ls;

	// 第一种分页 方法 dataTable
	@RequestMapping("/dataTable.do")
	public String togoodspage(ModelMap model) {
		List<LoginEntity> goodList = ls.getqAllGoods();
		model.addAttribute("goodList", goodList);
		return "/fount/index";

	}

	// 第二种分页方法 pageHelper
	//返回json数据
	@RequestMapping("/pageHelper.do")
	@ResponseBody
	public PageInfo<LoginEntity> findgoods(int page, int pageSize) {
		// pageHelper帮助我们生成分页语句
		List<LoginEntity> listgoods = ls.getqw();
		// 底层原理改写sql语句
		PageHelper.startPage(page, pageSize);
		// 返回给客户端展示使用
		PageInfo<LoginEntity> goodslist = new PageInfo<LoginEntity>(listgoods);
		return goodslist;
	}
	
	
	//默认访问首页
	@RequestMapping("/")
	public String classindexshouye() {
		LoginEntity aa=new LoginEntity();
		return "/admin/shouye";
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
