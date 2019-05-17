package cn.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.java.util.HttpClientUtil;

/**
 * 用户登录类
 * 
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	
	
	// 注入service 类

	
	// 手机号码
	private String wx_phone;
	// 用户名
	private String Uid = "aabbcc123";
	// 接口安全秘钥
	private String Key = "d41d8cd98f00b204e980";

	// 手机号码，
	private String smsMob = getlogin(wx_phone);
	// 短信内容
	private String smsText = "您的验证码是" + getRandNum();

	// 生成一个4位随机数 作为验证码发送给用户
	public static int getRandNum() {
		int yzm = (int) (Math.random() * 10000);
		return yzm;
	}

	// 点击获取验证码 获取手机号码并发送验证码到该手机号
	@RequestMapping(method = RequestMethod.POST, value = "/getcode.do")
	@ResponseBody
	public String getlogin(String wx_phone) {
		
		// 获取到的手机号码存入数据库
		//loginService.setlogin(wx_phone);
		
		
		HttpClientUtil client = HttpClientUtil.getInstance();
		smsMob = wx_phone;
		
		// UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
		if (result > 0) {
			System.out.println("UTF8成功发送条数==" + result);
		} else {
			System.out.println(client.getErrorMsg(result));
		}
		return wx_phone;
	}
	

	/**
	 * 点击 登陆 获取验证码进行判断是否输入正确
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/denglu.do")
	@ResponseBody
	public String register(String wx_phone, String wx_yanzheng, HttpSession sess) {
		System.out.println("手机号码---" + wx_phone);
		System.out.println("验证码------" + wx_yanzheng);
		// 获取页面输入的手机号码和验证码后查询数据库进行判断
		// 判断类型 业主或者物业
		// 根据账号类型进入页面
		sess.setAttribute("wx_yanzheng", "wx_yanzheng");
		sess.setAttribute(smsText, "smsText");
		return wx_yanzheng;
	}

}
