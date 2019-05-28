package cn.java.service;

import java.util.List;

import cn.java.entity.Property;
import cn.java.exception.AppException;
import cn.java.vo.PropertyQuery;

/**
 * 物业数据逻辑层
 * @author LIXIAOWANG
 *
 */
public interface PropertyService {
	// 新增物业
	public int insert(Property property) throws AppException;
	//通用查询
	public List<Property> queryByComm(PropertyQuery query);
	//通过ID查询
	public Property queryById(int id);

}
