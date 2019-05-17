package cn.java.service;

import java.util.List;

import cn.java.dto.ResultDto;
import cn.java.entity.OwnerEntity;

public interface OwnerService {
	//注册业主
	public ResultDto<String> registerOwner(OwnerEntity ownerEntity);
//手机号查询
	public List<OwnerEntity> selectByYz(String yz);
}
