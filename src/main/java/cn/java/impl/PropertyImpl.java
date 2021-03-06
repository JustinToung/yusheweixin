package cn.java.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.java.dao.PropertyDao;
import cn.java.entity.PropertyInfoEntity;
import cn.java.exception.AppException;
import cn.java.service.PropertyService;
import cn.java.vo.PropertyQuery;
/**
 * 物业业务逻辑层
 * @author LIXIAOWANG
 *
 */
@Service
@Transactional
public class PropertyImpl implements PropertyService {
	
	@Autowired
	PropertyDao pdao;
	
	
	/**
	 * @param 新增物业
	 * @return 
	 * @throws AppException 
	 */
	@Transactional(rollbackFor=Exception.class)
	public int insert(PropertyInfoEntity property) throws AppException {
		//接受返回值
		int result= pdao.insert(property);
		if (result!=1) {
			throw new AppException(1001, "新增失败");
		}
		return result;
	}
	/**
	 * @param 传过来的数据
	 * @return 返回查询结果
	 */
	public List<PropertyInfoEntity> queryByComm(PropertyQuery query) {
		
		return pdao.queryByComm(query);
	}
	@Override
	public PropertyInfoEntity queryById(int id) {
		// TODO Auto-generated method stub
		return pdao.queryById(id);
	}

}
