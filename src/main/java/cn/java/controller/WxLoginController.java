package cn.java.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.java.entity.UserInfoEntity;
import cn.java.service.UserInfoService;
import cn.java.util.AesUtil;
import cn.java.util.ConstantsUntil;
import cn.java.util.WxHttpClientUtil;

/**
 * @author LIXIAOWANG
 *	微信授权
 */
@RestController
public class WxLoginController {

	@Autowired
	UserInfoService userInfoService;
	
	
	/**
	 * 微信授权登陆
	 * @param code 
	 * @param user 用户信息
	 * @return
	 */
	@PostMapping("/tologin.do")
	public Object wx_Login(@RequestParam("code") String code,
			/*@RequestParam("encryptedData") String encryptedData,
			@RequestParam("iv")String iv,*/UserInfoEntity user) {
		// 配置请求参数
		Map<String, String> param = new HashMap<>();
		param.put("appid", ConstantsUntil.WX_LOGIN_APPID);
		param.put("secret", ConstantsUntil.WX_LOGIN_SECRET);
		param.put("js_code", code);
		param.put("grant_type", ConstantsUntil.WX_LOGIN_GRANT_TYPE);
		// 发送请求
		String wxResult = WxHttpClientUtil.doGet(ConstantsUntil.WX_LOGIN_URL, param);
		JSONObject jsonObject = JSONObject.parseObject(wxResult);
		// 获取参数返回
		String open_id = jsonObject.get("openid").toString();
		String session_key = jsonObject.get("session_key").toString();
		
		JSONObject json=new JSONObject();
		
		try {
			//获取微信的UnionId信息
//			String union_id=AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
			// 根据返回的user实体类，判断用户是否是新用户，不是的话，更新最新登录时间，是的话，将用户信息存到数据库
			UserInfoEntity userInfo=userInfoService.queryByOpenId(open_id);
			if (userInfo!=null) {
				//该用户存在
				userInfo.setLogintime(new Date());
				//修改登录时间
				userInfoService.updateUserInfo(userInfo);
//				System.out.println("登录");
			}else {
				user.setOpenId(open_id);
				user.setCreatetime(new Date());
				user.setLogintime(new Date());
//				user.setUnionId(union_id);
				user.setUnionId(null);
				user.setEnable(1);
				
				int num = userInfoService.insertUserInfo(user);
				if (num!=1) {
					json.put("code", 0);
					json.put("message","授权失败");
					return json;
				}
			}
			Map<String, Object> map=new HashMap<>();
			map.put("avatarUrl", userInfo.getAvatarUrl());
			map.put("nickName", userInfo.getNickName());
			map.put("userName", userInfo.getUserName());
			map.put("yusheName", userInfo.getYusheName());
			map.put("telephone", userInfo.getTelephone());
			map.put("address",userInfo.getAddress());
			map.put("company", userInfo.getCompany());
			map.put("job", userInfo.getJob());
//			json.put("user",userInfo);
			json.put("user", map);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			json.put("code", 1);
			json.put("message", "授权失败");
			return json;
		}

	}

}
