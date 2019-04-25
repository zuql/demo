package cn.tedu.dao;

import java.util.List;

import cn.tedu.pojo.User;

/**
 * �������������û����ҵ��
ע�⣺
1��	���� + ���� = UserMapper.xml��namespace��ֵ
2��	�ӿ��з����� =  UserMapper.xml�ж����SQL��idֵ
3��	�����ķ���ֵ���ͺͲ�������Ҫ��UserMapper.xmlӳ���ļ�������һ��
 */
public interface UserMapperDao {

//      ��ѯuser�����������
//<select id="findAll" resultType="User">
//		select * from user 
//</select>
	//������=idֵ������ֵ����=resultTypeֵ
	public List<User> findAll(); 
	
	
//	<!-- ��ѯ�ܼ�¼�� -->
//	<select id="count" resultType="int">
//		select count(*) from user
//	</select>
	//������=idֵ������ֵ����=resultTypeֵ
	public int count();
	
//	<!-- ����id��ѯ��¼ -->
//	<select id="findOne" 
//			resultType="cn.tedu.pojo.User"
//			parameterType="int">
//		select * from user where id=#{id}
//	</select>
	//������=idֵ������ֵ����=resultTypeֵ
	public User findOne(int userId);
	
	
//	����һ����¼ 
//	<insert id="save" 
//			parameterType="cn.tedu.pojo.User">
//		
//		insert into user values
//		(null,#{name},#{addr},#{age})
//	</insert>
	//������=idֵ������ֵ����=resultTypeֵ
	public void save(User user);
	
	
	
	
	
	
}
