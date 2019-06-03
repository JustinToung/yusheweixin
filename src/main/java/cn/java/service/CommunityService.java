package cn.java.service;

import cn.java.entity.CommunityInfoEntity;
/**
 * 创建社区
 * @author LIXIAOWANG
 *
 */
public interface CommunityService {
	//创建社区
	public int insert(CommunityInfoEntity info);
	//通过id查询
	public CommunityInfoEntity selectById(int id);
}
