package com.zuql.springbootdemo.enums;

/**
 * 使用枚举的单例模式
 *
 * @author yzl
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EnumSingleton{
    private EnumSingleton(){}
    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton{
        INSTANCE;

        private EnumSingleton singleton;
        //JVM会保证此方法绝对只调用一次
        private Singleton(){
            singleton = new EnumSingleton();
        }
        public EnumSingleton getInstance(){
            return singleton;
        }
    }


    public static void main(String[] args) {
        EnumSingleton obj1 = EnumSingleton.getInstance();
        EnumSingleton obj2 = EnumSingleton.getInstance();
        //输出结果：obj1==obj2?true
        System.out.println("obj1==obj2?" + (obj1==obj2));

    }


}
