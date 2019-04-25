package cn.tedu.dao;

import java.util.List;

import cn.tedu.pojo.UserInfo;

/*
 * 这个接口用来完成对象关联关系
 */
public interface UserInfoDao {

	//根据用户id查询用户扩展信息
	/*
	 * <select id="findExtraByUser" 
	 * 		resultMap="userextraRM">
		select * from user_info t1,user_extra t2
		where t1.id=t2.user_id and t1.id=#{id}
		</select>
	*/
	public UserInfo findExtraByUser(int userId);
	
	
	//根据用户id查询所有订单信息 
	/*<select id="findOrdersByUser"
			resultMap="orderRM">
		select * from user_info t1,orders t2
		where t1.id=t2.user_id and t1.id=#{id}
	</select>
	*/
	public List<UserInfo> findOrdersByUser(int userId);
	
	
	
	
	
	
	
	
	
}
