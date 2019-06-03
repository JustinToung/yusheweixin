package cn.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.Module.SetupContext;

import cn.java.entity.CommunityInfoEntity;
import cn.java.service.CommunityService;
import cn.java.util.ConstantsUntil;
import cn.java.util.FileServerUtil;

/**
 * 创建社区
 * @author LIXIAOWANG
 *
 */
@Controller
@RequestMapping("/community")
public class CommunityController {
	@Autowired
	CommunityService cService;
	
	
	/**
	 * 创建社区
	 * @param communityName
	 * @param communityAddress
	 * @param communityImage
	 * @return
	 */
	@PostMapping("/setup.do") 
	@ResponseBody
	public Object setUp(@RequestParam("communityName")String communityName,@RequestParam("communityAddress")String communityAddress,
			@RequestParam("communityImage")MultipartFile communityImage) {
		CommunityInfoEntity info=new CommunityInfoEntity();
		info.setCommunityName(communityName);
		info.setCommunityAddress(communityAddress);
		String image = FileServerUtil.fileUpload(communityImage);
		info.setCommunityImage(image);
		//创建社区
		int id = cService.insert(info);
		JSONObject json=new JSONObject();
		if (id!=0) {
			json.put("code", "200");
			json.put("message", "创建成功");
			json.put("data", info);
		}else {
			json.put("code", "400");
			json.put("message", "创建失败");
		}
		return json;
	}
	
	/**
	 * 上传图片
	 * @param file
	 * @return
	 */
	@RequestMapping("/uploadfile.do")
	@ResponseBody
	public Object upload(MultipartFile file) {
		String fileName = FileServerUtil.fileUpload(file);
		JSONObject json=new JSONObject();
		json.put("code", "200");
		json.put("message", "上传成功");
		json.put("data", fileName);
		return json;
	}
	/**
	 * 删除图片
	 * @param path
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="/deletefile.do",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object delete(String path) {
		String result = FileServerUtil.deleteFile(path);
		JSONObject json=new JSONObject();
		json.put("data", result);
		return json;
	}

}
