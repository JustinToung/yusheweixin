package cn.java.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import cn.java.entity.PostInfoEntity;

/**
 * 帖子信息数据访问
 * @author LIXIAOWANG
 *
 */
public interface PostInfoDao {
	
	//发布帖子
	@Insert("insert into postInfo(id,title,content,typeId,userId,createTime) values(#{id},#{title},#{content},#{typeId},#{userId},#{createTime})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public int insertPost(PostInfoEntity postInfo);
}
