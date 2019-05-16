package cn.java.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.java.service.PropertyService;
import cn.java.util.AesUtil;
import cn.java.util.ConstantsUntil;
import cn.java.util.WxHttpClientUtil;
import cn.java.util.JsonResult;

@RestController
public class WxLoginController {

	@Autowired
	PropertyService ps;
	
//	, @RequestParam("avatarUrl") String avatarUrl,
//	@RequestParam("nickName") String nickName, @RequestParam("gender") String gender,
//	@RequestParam("city") String city, @RequestParam("province") String province

	@PostMapping("/tologin.do")
	public JsonResult wx_Login(@RequestParam("code") String code,@RequestParam("encryptedData") String encryptedData,@RequestParam("iv")String iv) {
//		System.out.println("===="+code);
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
		
		Map<String, String> result = new HashMap<>(); 
		
		try {
			//获取微信的UnionId信息
			String union_id=AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
			// 根据返回的user实体类，判断用户是否是新用户，不是的话，更新最新登录时间，是的话，将用户信息存到数据库
			// User user = userService.selectByOpenId(open_id);
			// if(user != null){
			// user.setUserNewLogin(new Date());
			// userService.updateById(user);
			// }else{
			// User insert_user = new User();
			// insert_user.setUserHead(userHead);
			// insert_user.setUserName(userName);
			// insert_user.setUserGender(userGender);
			// insert_user.setUserNewLogin(new Date());
			// insert_user.setUserCity(userCity);
			// insert_user.setUserProvince(userProvince);
			// insert_user.setUserOpenid(open_id);
			// map.put("user",insert_user)
			// System.out.println("insert_user:"+insert_user.toString());
			// // 添加到数据库
			// Boolean flag = userService.insert(insert_user);
			// if(!flag){
			// return new JsonResult(JsonResult.ERROR);
			// }
			// }
			System.out.println(union_id);
			result.put("session_key", session_key); 
			result.put("open_id", open_id);
			result.put("union_id", union_id);
//			System.out.println(new JsonResult(result, JsonResult.SUCCESS));
			return new JsonResult(result, JsonResult.SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new JsonResult(JsonResult.ERROR);
		}

		
		
		
	}

}
