package cn.java.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import cn.java.util.ConstantsUntil;

/**
 * 从小程序上传图片到服务器
 * @author Administrator
 *
 */
@Controller
public class UpLoadController {
	
	/**
	 * 上传图片到服务器
	 * @param file
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,consumes="multipart/form-data",value="/upload/server.do")
	@ResponseBody
	public String serverUpload(MultipartFile file) {
		//UUID算法
		String pfix=UUID.randomUUID().toString();
		//生成文件名
		String filename=pfix+file.getOriginalFilename();
		System.out.println(filename);
		//调用Jersey服务
		Client client=new Client();
		//将图片定义成web资源
		WebResource wr=client.resource(ConstantsUntil.IMGSERVER+filename);
		try {
			//将源文件以二进制流的形式写入web资源中
			wr.put(String.class,file.getBytes());
			//返回完整路径
			return ConstantsUntil.IMGSERVER+filename;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}

}
