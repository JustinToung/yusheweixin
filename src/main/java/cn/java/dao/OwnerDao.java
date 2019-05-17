package cn.java.dao;

import java.util.List;

import cn.java.entity.OwnerEntity;

public interface OwnerDao {
	//注册
	public int registerOwner(OwnerEntity ownerEntity);
	
	//通过手机号查询业主信息  用于注册
	public List<OwnerEntity> selectByYz(String yz);
}
