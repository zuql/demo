/*
学习变量和常量的声明
知识点
1.scala可以自动推断出变量或常量的类型
2.变量(var) 可以更改。而常量(val)一经声明，不能修改。一般在程序中用的常量val
*/
object Demo01 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //--变量声明用var 关键字
  var v1=10                                       //> v1  : Int = 10
  
  //--常量声明用val 关键字
  val v2=20                                       //> v2  : Int = 20
  
  var v3="hello1804"                              //> v3  : String = hello1804
  
  var v4=Array(1,2,3,4)                           //> v4  : Array[Int] = Array(1, 2, 3, 4)
  
  //--显示的指定类型
  var v5:Int=15                                   //> v5  : Int = 15
  
  val v6:String="hello"                           //> v6  : String = hello
  val v7:java.lang.String="hello"                 //> v7  : String = hello
  
 
  
}