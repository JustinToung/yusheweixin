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
import cn.java.service.PropertyService;
import cn.java.service.UserInfoService;
import cn.java.util.AesUtil;
import cn.java.util.ConstantsUntil;
import cn.java.util.WxHttpClientUtil;
import cn.java.util.JsonResult;

@RestController
public class WxLoginController {

	@Autowired
	PropertyService ps;
	@Autowired
	UserInfoService userInfoService;
	
//	, @RequestParam("avatarUrl") String avatarUrl,
//	@RequestParam("nickName") String nickName, @RequestParam("gender") String gender,
//	@RequestParam("city") String city, @RequestParam("province") String province

	@PostMapping("/tologin.do")
	public JsonResult wx_Login(@RequestParam("code") String code,
			@RequestParam("encryptedData") String encryptedData,
			@RequestParam("iv")String iv,UserInfoEntity user) {
//		System.out.println("===="+code);
		System.out.println(user.getAvatarUrl()+"=="+user.getNickName()+"=="+
				user.getGender()+"=="+user.getCity()+"=="+user.getProvince()
				);
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
		
		Map<String, Object> result = new HashMap<>(); 
		
		try {
			//获取微信的UnionId信息
			String union_id=AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
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
				user.setUnionId(union_id);
				user.setPosition(0);
				if ("1".equals(user.getGender())) {
					user.setGender("男");
				}else {
					user.setGender("女");
				}
				
				int num = userInfoService.insertUserInfo(user);
				if (num!=1) {
					return new JsonResult(JsonResult.ERROR);
				}
			}
			result.put("user",user);
//			result.put("session_key", session_key); 
//			result.put("open_id", open_id);
//			result.put("union_id", union_id);
//			System.out.println(new JsonResult(result, JsonResult.SUCCESS));
			return new JsonResult(result, JsonResult.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new JsonResult(JsonResult.ERROR);
		}

		
		
		
	}

}
