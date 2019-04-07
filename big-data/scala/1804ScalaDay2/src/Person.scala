
/**
 * 知识点
 * 1.scala 的类声明同java，通过class关键字来定义
 * 2.成员变量和成员方法默认是public。可以通过private或protected修饰
 * 3.scala类的主构造器需要在类上声明
 * 4.当显示声明主构造器后，默认的空构造器失效
 * 
 */
class Person(v1:String,v2:Int){
  
  
  
  //--成员变量
  private var name=v1
  private var age=v2
  
  //--构造辅助构造器，要求必须显示的调用同类的其他构造器（一般调用主构造器）
  def this(v1:String){
    this(v1,0)
  }
  
  def this(v2:Int){
    this("",v2)
  }
  
  def this(){
    this("",0)
  }
  
  def getName()={
    name
  }
  def setName(name:String)={
    this.name=name
  }
  
  def getAge()={
    age
  }
  
  def setAge(age:Int)={
    this.age=age
  }
  
  //--成员方法
  def eat()={
    println("eat food") 
  }
  
  
  
}
/**
 * 当把一个object单例对象和一个class写在同一文件里
 * 并且名字一致，此时单例对象和类会产生一个绑定关系。
 * 
 * 术语：
 * 称:object->class 伴生对象
 * 称:class->object 伴生类
 */
object Person{
   
  def say(){
    
  }
}