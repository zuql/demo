package com.pt.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pt.order.entity.Order;
import com.pt.order.vo.OrderVo;
import com.pt.order.vo.SqlOrderCommand;

public interface OrderDao {
	/**
	 * 基于多个id执行订单的删除操作
	 * @param ids
	 * @return
	 * 应用说明：如下方法中的参数应用在动态sql时
	 * 1)方法中使用了@Param("参数名")注解修饰，
	 *   则动态sql中#{参数名}
	 * 2)方法中没有使用@Param注解修饰时，则动态
	 *   sql中可以使用array作为参数接受数据
	 * 错误说明：
	 * 1)当如下方法中参数为null,或者数组长度为0时，
	 * 直接在动态sql中使用ids可能会有问题。
	 */
	int deleteObjects(@Param("ids") Integer[] ids);
	
	/**
	 * 基于id删除订单信息
	 * @param id 
	 * @return 删除的行数
	 */
	int deleteObject(Integer id);
	
	
	

	 List<OrderVo> findPageObjects(
	 @Param("cmd")SqlOrderCommand cmd);
	/**
	 * 将订单的详细信息写入到数据库(对象持久化)
	 * @param entity (封装了订单信息的对象)
	 * @return (写入数据的行数)
	 */
	int insertObject(Order entity);
}








