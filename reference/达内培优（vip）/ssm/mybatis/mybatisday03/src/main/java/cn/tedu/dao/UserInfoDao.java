package cn.tedu.dao;

import java.util.List;

import cn.tedu.pojo.UserInfo;

/*
 * ����ӿ�������ɶ��������ϵ
 */
public interface UserInfoDao {

	//�����û�id��ѯ�û���չ��Ϣ
	/*
	 * <select id="findExtraByUser" 
	 * 		resultMap="userextraRM">
		select * from user_info t1,user_extra t2
		where t1.id=t2.user_id and t1.id=#{id}
		</select>
	*/
	public UserInfo findExtraByUser(int userId);
	
	
	//�����û�id��ѯ���ж�����Ϣ 
	/*<select id="findOrdersByUser"
			resultMap="orderRM">
		select * from user_info t1,orders t2
		where t1.id=t2.user_id and t1.id=#{id}
	</select>
	*/
	public List<UserInfo> findOrdersByUser(int userId);
	
	
	
	
	
	
	
	
	
}
