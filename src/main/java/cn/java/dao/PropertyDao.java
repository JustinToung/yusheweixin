package cn.java.dao;

import java.util.List;

import cn.java.entity.Property;
import cn.java.vo.PropertyQuery;

/**
 * 物业数据操作
 * @author Administrator
 *
 */
public interface PropertyDao {
	
	//新增物业
	public int insert(Property property);
	//通用查询
	public List<Property> queryByComm(PropertyQuery query);
	//通过ID查询
	public Property queryById(int id);
	//通过Id删除
	public void deleteById(int id);

}
