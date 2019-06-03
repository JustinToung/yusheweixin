package cn.java.service;

import java.util.List;

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
	//查询所用社区信息
	public List<CommunityInfoEntity> selectAll();
}
