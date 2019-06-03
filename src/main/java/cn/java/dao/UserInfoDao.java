package cn.java.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.java.entity.UserInfoEntity;

/**
 * 用户信息的数据访问层
 * @author LIXIAOWANG
 *
 */
public interface UserInfoDao {
	//通过用户openId查询
	public UserInfoEntity queryByOpenId(String openId);
	//新增用户
	public int insertUserInfo(UserInfoEntity user);
	//修改用户信息
	public int updateUserInfo(UserInfoEntity user);
	//加入社区
	@Update("update userinfo set community=#{communityId} where id=#{userId} ")
	public int joinCommunity(int communityId,int userId);
	//通过id查询
	@Select("select * from userinfo where id=#{id}")
	public UserInfoEntity selectById(int id);
	//查询每个社区的人数
	@Select("select count(1) count from userinfo where communityId=#{communityId}")
	public int queryCount(int communityId);

}
