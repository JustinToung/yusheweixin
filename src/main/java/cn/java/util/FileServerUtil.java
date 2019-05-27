package cn.java.util;

import java.io.File;
import java.util.UUID;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 文件上传服务器和删除服务器中文件工具类
 * 
 * @author LIXIAOWANG
 *
 */
public class FileServerUtil {
	// 图片上传路径
//	private static String filePath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/upload/";
	private static final String filePath = "F:/upload/images";

	/**
	 * 上传文件的方法
	 * 
	 * @param file
	 * @param serverPath
	 * @return
	 */
	public static String serverUpload(MultipartFile file, String serverPath) {
		// UUID算法
		String pfix = UUID.randomUUID().toString();
		// 获取文件名
		String filename = file.getOriginalFilename();
		// 获取文件后缀名
		String suffix = filename.substring(filename.lastIndexOf("."));
		// 生成文件名
		filename = pfix + suffix;
		// 生成文件名
//		String filename = pfix + file.getOriginalFilename();
		// System.out.println(filename);
		// 调用Jersey服务
		Client client = new Client();
		// 将图片定义成web资源
		WebResource wr = client.resource(serverPath + filename);
		try {
			// 将源文件以二进制流的形式写入web资源中
			wr.put(String.class, file.getBytes());
			// 返回完整路径
			return serverPath + filename;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}

	/**
	 * 批量上传文件
	 * 
	 * @param file
	 * @param serverPath
	 * @return
	 */
	public static String bacthFileUpload(MultipartFile[] file, String serverPath) {
		StringBuffer buffer = new StringBuffer();
		for (MultipartFile multipartFile : file) {
			String str = serverUpload(multipartFile, serverPath);
			buffer.append(str);
			buffer.append(",");
		}
		String all = buffer.substring(0, buffer.length() - 1);
		return all;
	}

	/**
	 * 删除服务器的方法
	 * 
	 * @param url
	 */
	public static void deleteServerFile(String url) {
		// 调用Jersey服务
		Client client = new Client();
		// 将图片定义成web资源
		WebResource resource = client.resource(url);
		resource.delete();
		// System.out.println("删除成功");

	}

	/**
	 * 上传文件到本地
	 * 
	 * @param file
	 * @param req
	 * @return
	 */
	public static String fileUpload(MultipartFile file) {
		// 使用UUID算法生成前缀
		String pfix = UUID.randomUUID().toString();
		// 生成文件名 前缀+原始文件名
		String filename = file.getOriginalFilename();
		int lastIndexOf = filename.lastIndexOf(".");
		// 获取后缀名
		String substring = filename.substring(lastIndexOf);
		// 生成文件名 前缀+后缀
		filename = pfix + substring;
		// 文件上传路径
		String path = filePath;
		// 生成目标文件 File.separator分隔符
		File dest = new File(path + File.separator + filename);
		try {
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}
			// 将上传文件写入到目标文件
			file.transferTo(dest);
			// 返回文件名
			return filename;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 批量上传文件到本地
	 * 
	 * @param file
	 * @param serverPath
	 * @return
	 */
	public static String filesUpload(MultipartFile[] file) {
		StringBuffer buffer = new StringBuffer();
		// 将文件一一上传，并将文件名拼接成字符串，用 逗号 隔开 并将字符串返回
		for (MultipartFile multipartFile : file) {
			String str = fileUpload(multipartFile);
			buffer.append(str);
			buffer.append(",");
		}
		String all = buffer.substring(0, buffer.length() - 1);
		return all;
	}

	/**
	 * 删除本地文件
	 * 
	 * @param path
	 * @return
	 */
	public static String deleteFile(String path) {
		String returnInfo = "";
		// 获取文件名
		int lastIndexOf = path.lastIndexOf("/");
		String substring = path.substring(lastIndexOf + 1, path.length());
		// 获取文件所在路径
		substring = filePath + substring;
		// 生成对象文件
		File file = new File(substring);
		// 如果文件存在 删除文件
		if (file.exists()) {
			if (file.delete()) {
				returnInfo = "1-删除成功";
			} else {
				returnInfo = "0-删除失败";
			}
		} else {
			returnInfo = "文件不存在！";
		}
		return returnInfo;
	}

}
