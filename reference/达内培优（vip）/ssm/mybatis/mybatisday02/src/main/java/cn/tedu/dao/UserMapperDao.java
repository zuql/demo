package cn.tedu.dao;

import java.util.List;

import cn.tedu.pojo.User;

/**
 * 这个类用来完成用户表的业务
注意：
1、	包名 + 类名 = UserMapper.xml中namespace的值
2、	接口中方法名 =  UserMapper.xml中定义的SQL的id值
3、	方法的返回值类型和参数类型要和UserMapper.xml映射文件中类型一致
 */
public interface UserMapperDao {

//      查询user表的所有数据
//<select id="findAll" resultType="User">
//		select * from user 
//</select>
	//方法名=id值，返回值类型=resultType值
	public List<User> findAll(); 
	
	
//	<!-- 查询总记录数 -->
//	<select id="count" resultType="int">
//		select count(*) from user
//	</select>
	//方法名=id值，返回值类型=resultType值
	public int count();
	
//	<!-- 根据id查询记录 -->
//	<select id="findOne" 
//			resultType="cn.tedu.pojo.User"
//			parameterType="int">
//		select * from user where id=#{id}
//	</select>
	//方法名=id值，返回值类型=resultType值
	public User findOne(int userId);
	
	
//	新增一条记录 
//	<insert id="save" 
//			parameterType="cn.tedu.pojo.User">
//		
//		insert into user values
//		(null,#{name},#{addr},#{age})
//	</insert>
	//方法名=id值，返回值类型=resultType值
	public void save(User user);
	
	
	
	
	
	
}
