
/**
 * 知识点
 * 1.scala通过extends 关键字来实现继承
 * 2.如果重写的方法不是抽象方法，则需要加上override关键字
 */
class Student extends Person{
  
  override def eat()={
    println("student eat food") 
  }
  
}