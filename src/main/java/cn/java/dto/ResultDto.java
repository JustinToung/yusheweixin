package cn.java.dto;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;



//线程安全实现Serializable接口
public class ResultDto<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7808729790324292434L;

	private String code;

	private String msg;
	//T代表什么类型都可以  一般用用封装类的使用
	private T data;

	// 构造函数赋值
	public ResultDto(String code, String msg) {

		this.code = code;
		this.msg = msg;

	}

	public ResultDto(String code, String msg, T data) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.msg = msg;
		this.data=data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
