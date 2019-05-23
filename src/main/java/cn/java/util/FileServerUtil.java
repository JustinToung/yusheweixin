package cn.java.util;

import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 文件上传服务器和删除服务器中文件工具类
 * @author LIXIAOWANG
 *
 */
public class FileServerUtil {
		
	/**
	 * 上传文件的方法
	 * @param file
	 * @param serverPath
	 * @return
	 */
	public String serverUpload(MultipartFile file,String serverPath) {
		//UUID算法
		String pfix=UUID.randomUUID().toString();
		//生成文件名
		String filename=pfix+file.getOriginalFilename();
//		System.out.println(filename);
		//调用Jersey服务
		Client client=new Client();
		//将图片定义成web资源
		WebResource wr=client.resource(serverPath+filename);
		try {
			//将源文件以二进制流的形式写入web资源中
			wr.put(String.class,file.getBytes());
			//返回完整路径
			return serverPath+filename;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	/**
	 * 批量上传文件
	 * @param file
	 * @param serverPath
	 * @return
	 */
	public String bacthFileUpload(MultipartFile[] file,String serverPath) {
		StringBuffer buffer = new StringBuffer();
 		for (MultipartFile multipartFile : file) {
 			String str = serverUpload(multipartFile,serverPath);
 			buffer.append(str);
 			buffer.append(",");
 		}
 		String all = buffer.substring(0, buffer.length() - 1);		
		return all;
	}
	/**
	 * 删除服务器的方法
	 * @param url 
	 */
	public void deleteServerFile(String url) {
		// 调用Jersey服务
		Client client = new Client();
		// 将图片定义成web资源
		WebResource resource = client.resource(url);
		resource.delete();
//		System.out.println("删除成功");

	}

}
