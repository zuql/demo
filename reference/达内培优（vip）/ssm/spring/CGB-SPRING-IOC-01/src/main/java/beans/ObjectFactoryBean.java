package beans;

import org.springframework.beans.factory.FactoryBean;
/**
 * Spring框架中通常有这么一种规则：
 * 假如由spring管理的对象是工厂对象
 * 系统底层通常会建议提供一个工厂对应的Bean对象
 * 这个Bean对象要实现Spring中的一个
 * 接口FactoryBean
 * @author ta
 */
public class ObjectFactoryBean 
             implements FactoryBean<ObjectFactory> {
	/***
	 * 通常会在此方法中创建工厂对应的对象
	 * Spring底层在通过配置文件构建Bean对象时，
	 * 首先会检测你这个bean对象是否实现了FactoryBean接口
	 * 假如实现了接口，spring会调用这个Bean对象的
	 * getObject方法返回一个类的实例。
	 */
	public ObjectFactory getObject() throws Exception {
		System.out.println("getObject()");
		return new ObjectFactory();//也可以通过反射
	}
	/**
	 * 获取对象的类型
	 * 思考：
	 * 1)系统底层会何时调用此方法？(第一对象单例，第二容器关闭)
	 * 2)底层通过此方法获取对象类型的目的？(销毁这个类型的对象)
	 */
	public Class<?> getObjectType() {
		System.out.println("getObjectType()");
		return ObjectFactory.class;
		//假如对象时单例对象，底层系统会在容器关闭时
		//依据此方法返回的类型，查找对象，并销毁对象
	}
	/**
	 * 通过此方法的返回值告诉底层系统此类的对象是否
	 * 单例设计(此类的实例在内存中只有一份)
	 * 思考：
	 * 1)此方法何时对象？对象创建时，单例对象销毁时
	 */
	public boolean isSingleton() {
		System.out.println("isSingleton()");
		return true;
	}

}





