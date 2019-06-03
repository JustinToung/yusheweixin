package cn.java.dao;

import java.util.List;

import cn.java.entity.PropertyInfoEntity;
import cn.java.vo.PropertyQuery;

/**
 * 物业数据操作
 * @author LIXIAOWANG
 *
 */
public interface PropertyDao {
	
	//新增物业
	public int insert(PropertyInfoEntity property);
	//通用查询
	public List<PropertyInfoEntity> queryByComm(PropertyQuery query);
	//通过ID查询
	public PropertyInfoEntity queryById(int id);
	//通过Id删除
	public void deleteById(int id);

}
