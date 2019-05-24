package cn.java.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import cn.java.entity.LoginEntity;

/**
 * 
 * @author zxc
 *
 */
public interface LoginDao {
	
	//手机号码
	/*@Insert("INSERT into yezhu VALUES(null,#{arg0})")
	int addlogin(String wx_phone);
	*/
	
	
	//查询goods表所有数据
	@Select("SELECT * FROM goods")
	List<LoginEntity> getAllGoods();
	
	//第二种分页方法  pageHelper
	@Select("SELECT * FROM goods")
	 List<LoginEntity>  getqw();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
