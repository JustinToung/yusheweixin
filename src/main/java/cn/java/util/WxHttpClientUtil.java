package cn.java.util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 发送请求的工具类(获取微信的openId、session_key等数据)
 * @author Administrator
 *
 */
public class WxHttpClientUtil {
	/**
	 * get请求方式发送请求，带参
	 * @param url 请求路径
	 * @param param 参数
	 * @return 返回请求后的参数
	 */
	public static String doGet(String url, Map<String, String> param) {
		// 创建HttpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;

		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			// 如果有参数传入 将参数加入地址中
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultString;
	}

	/**
	 * get请求方式发送请求，不带参
	 * @param url 请求路径
	 * @return 返回请求后的参数
	 */
	public static String doGet(String url) {
		return doGet(url, null);
	}
	/**
	 * Post请求方式发送请求，带参
	 * @param url 请求路径
	 * @param param 参数
	 * @return 返回请求后的参数
	 */
	public static String doPost(String url, Map<String, String> param) {
		// 创建HttpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpclient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return resultString;

	}
	/**
	 * Post请求方式发送请求，不带参
	 * @param url 请求路径
	 * @return 返回请求后的参数
	 */
    public static String doPost(String url) {
        return doPost(url, null);
    }
    /**
	 * Post请求方式发送请求，带参
	 * @param url 请求路径
	 * @param param 参数 json格式
	 * @return 返回请求后的参数
	 */
    public static String doPostJson(String url, String json) { 
    	// 创建Httpclient对象 
    	CloseableHttpClient httpclient = HttpClients.createDefault(); 
    	CloseableHttpResponse response = null; 
    	String resultString = ""; 
    	try { 
    		// 创建Http Post请求 HttpPost 
    		HttpPost httPost= new HttpPost(url); 
    		// 创建请求内容 
    		StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON); 
    		httPost.setEntity(entity); 
    		// 执行http请求 
    		response = httpclient.execute(httPost); 
    		resultString = EntityUtils.toString(response.getEntity(), "utf-8"); } 
    	catch (Exception e) { 
    		e.printStackTrace(); 
    		} finally { 
    			try { 
    				response.close(); 
    				} catch (IOException e) { 
    					e.printStackTrace(); 
    					} 
    			} 
    	return resultString; 
    	}

}
