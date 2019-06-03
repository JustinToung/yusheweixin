package cn.java.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.java.dao.CommunityDao;
import cn.java.entity.CommunityInfoEntity;
import cn.java.service.CommunityService;

/**
 * 创建社区
 * 
 * @author LIXIAOWANG
 *
 */
@Service
@Transactional
public class CommunityImpl implements CommunityService {

	@Autowired
	CommunityDao cDao;

	/**
	 * 创建社区
	 */
	@Transactional(rollbackFor = Exception.class)
	public int insert(CommunityInfoEntity info) {
		// TODO Auto-generated method stub
		return cDao.insert(info);
	}

	/**
	 * 通过id查询社区
	 */
	public CommunityInfoEntity selectById(int id) {
		// TODO Auto-generated method stub
		return cDao.selectById(id);
	}

	/**
	 * 查询所有的社区
	 */
	public List<CommunityInfoEntity> selectAll() {
		// TODO Auto-generated method stub
		return cDao.selectAll();
	}
	
	

}
