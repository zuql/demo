

/**
 * 1.scala的抽象类同java,通过abstract来定义
 * 2.定义抽象方法，特点是没有方法体
 */
abstract class Teacher {
  
  def teach():Unit
  
  def makeNote():String
  
  def say(word:String):Int
  
  def run()
  
  //--普通方法
  def cook()={println("cook")}
}