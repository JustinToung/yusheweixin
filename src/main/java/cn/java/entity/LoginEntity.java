package cn.java.entity;


import java.io.Serializable;

import lombok.Data;


//@Data
public class LoginEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String goodName;
	private float price;
	private int  nums;
	
	
	@Override
	public String toString() {
		return "LoginEntity [id=" + id + ", goodName=" + goodName + ", price=" + price + ", nums=" + nums + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	
}
