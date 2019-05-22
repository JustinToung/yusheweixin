package cn.java.controller;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.java.entity.PersonEntity;

/**
 * 予舍安卓类
 * 
 * @author zxc
 *
 */
@Controller
public class YusheAndroid {

	/**
	 * 功能描述:通过request的方式来获取到json数据<br/>
	 * 
	 * @param jsonobject
	 *            这个是阿里的 fastjson对象
	 * @return 页面传参数使用---method = RequestMethod.POST, produces =
	 *         "application/json;charset=UTF-8" 注解接收参数--@RequestBody JSONObject
	 *         jsonParam
	 */
	@ResponseBody
	@RequestMapping(value = "/data.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String getByJSON(@RequestBody JSONObject jsonParam) { // 直接将json信息打印出来
		System.out.println(jsonParam.toJSONString());
		// 将获取的json数据封装一层，然后在给返回
		JSONObject result = new JSONObject();
		result.put("code", "1");
		result.put("msg", "true");
		result.put("data", jsonParam);
		return result.toJSONString();
	}

	/**
	 * 返回json数据
	 */
	@ResponseBody
	@RequestMapping("/add.do")
	public String setJson() {
		Map<String, Object> map = new HashedMap();
		map.put("a", "123456");
		map.put("b", "wertwer");
		map.put("c", "sdfgsdfgv");
		map.put("d", "sdfsdf");
		JSONObject json = new JSONObject();
		json.put("code", "1");
		json.put("msg", "true");
		json.put("b", "oihi");
		json.put("c", "oihi");
		return json + "+" + map;
	}

	// 测试json方法------------------------

	/**
	 * --方法1--
	 * 
	 * 利用传统方式： 由实体类生成Json字符串：
	 * 
	 * @return
	 */
	/*
	 * public PersonEntity getPerson(){ return new PersonEntity("张三", "男", 25); }
	 */

	// @Test
	// public void EntityToJson(){
	// JSONObject jsonObject = new JSONObject();
	// jsonObject.put("name", getPerson().getName());
	// jsonObject.put("sex", getPerson().getSex());
	// jsonObject.put("age", getPerson().getAge());
	// System.out.println(jsonObject.toString());
	// }

	/*
	 * 方法1 由Json字符串生成实体类：
	 */

	/*
	 * @Test public void JsonToEntity(){ String jsonString =
	 * "{\"sex\":\"男\",\"name\":\"张三\",\"age\":25}"; JSONObject jsonObject = new
	 * JSONObject(jsonString); PersonEntity person = new
	 * PersonEntity(jsonObject.get("name").toString(),
	 * jsonObject.get("sex").toString(),
	 * Integer.valueOf(jsonObject.get("age").toString()));
	 * System.out.println(person.toString()); }
	 */

	/**
	 * 方法2 利用Jackson方式： 由实体类生成Json字符串：
	 */

	// @Test
	// public void EntityToJson() throws IOException {
	// // 创建实体类并赋值
	// PersonEntity person = new PersonEntity("张三", "男", 28);
	// // 创建mapper
	// ObjectMapper objectMapper = new ObjectMapper();
	// // mapper里面添加实体类
	// String jsonString = objectMapper.writeValueAsString(person);
	// // 输出
	// System.out.println(jsonString);
	// }

	/*
	 * @Test public void JsonToEntity() throws IOException { ObjectMapper
	 * objectMapper = new ObjectMapper(); String jsonString =
	 * "{\"name\":\"张三\",\"sex\":\"男\",\"age\":25}"; PersonEntity person =
	 * objectMapper.readValue(jsonString, PersonEntity.class);
	 * System.out.println(person); }
	 */

	/**
	 * 方法3 利用GSON方式： 由实体类生成Json字符串：
	 */
	
	  @Test public void EntityToJson1() { PersonEntity person = new
	  PersonEntity("张三", "男", 25); }
	  //Gson gson = new Gson();  
	 // String jsonString= gson.toJson(person);  
	  //System.out.println(jsonString); }
	 

	/*
	 * @Test public void JsonToEntity1() { String jsonString =
	 * "{\"name\":\"张三\",\"sex\":\"男\",\"age\":25}"; // Gson gson = new Gson(); //
	 * Person person = gson.fromJson(jsonString, Person.class); //
	 * System.out.println(person.toString()); }
	 */

	/**
	 * 方法4、 利用FastJSON方式 由实体类生成Json字符串：
	 */
	/*
	 * @Test public void EntityToJson4() { PersonEntity person = new
	 * PersonEntity("张三", "男", 25); Object jsonString = JSON.toJSON(person);
	 * System.out.println(jsonString.toString()); }
	 */

	/*
	 * @Test public void JsonToEntity4() { String jsonString =
	 * "{\"name\":\"张三\",\"sex\":\"男\",\"age\":28}"; PersonEntity person =
	 * JSON.parseObject(jsonString, PersonEntity.class);
	 * System.out.println(person.toString()); }
	 */
	
	/**
	 * 四、几种方式的比较
	 * 类型
	 * 传统Json方式：
	 * 复杂的Json数据转换成实体类存在缺陷，性能和功能不够完善
	 * Jackson方式：
	 * 复杂的Json数据转换成实体类存在缺陷，性能和功能优于传统方式
	 * Gson方式：
	 * 功能方面在几种方式中最优，性能方面不如Jackson方式
	 * FastJson方式： 复杂的实体类转换成Json数据存在缺陷，解析json的速度优于其他方式
	 * 
	 */
	  
	  
	  

}
	  
	  
	  
	  
	  
	  
