package cn.java.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import cn.java.entity.CommunityInfoEntity;

/**
 * 创建社区
 * @author LIXIAOWANG
 *
 */
public interface CommunityDao {
	
	/**
	 * 创建建社区
	 * @param info
	 * @return
	 */
	@Insert("insert into CommunityInfo values(#{id},#{communityName},#{communityAddress},#{communityImage},#{communityExplain})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	public int insert(CommunityInfoEntity info);
	/**
	 * 通过id查询社区
	 * @param id
	 * @return
	 */
	@Select("select * from CommunityInfo where id=#{id}")
	public CommunityInfoEntity selectById(int id);
}
