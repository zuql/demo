/*
学习Int类型常用的操作方法
知识点
1.scala中，都是对象和方法，没有基本类型。所以说scala是一门面向对象的语言
此外，也是面向函数的语言
2.scala通过隐式转换，Int->RichInt
此外还有RichDouble RichFloat
3.建议初学时，浏览：https://www.scala-lang.org/api/2.10.4/index.html
*/
object Demo03 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val v1=1                                        //> v1  : Int = 1
  
  //--生成一个区间数组
  1.to(5)                                         //> res0: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
  //--生成区间并指定步长
  1.to(5,2)                                       //> res1: scala.collection.immutable.Range.Inclusive = Range(1, 3, 5)
  
  //--生成区间，但不含尾元素
  1.until(5)                                      //> res2: scala.collection.immutable.Range = Range(1, 2, 3, 4)
  1.until(5,2)                                    //> res3: scala.collection.immutable.Range = Range(1, 3)
  
  //--按操作符优先级来运算。优先级同java
  val v2=(1+2)*3                                  //> v2  : Int = 9
  //--按方法的调用顺序来运算
  val v3=1.+(2).*(3)                              //> v3  : Int = 9
  
  val v4=1234                                     //> v4  : Int = 1234
  v4.toString()                                   //> res4: String = 1234
  v4.toDouble                                     //> res5: Double = 1234.0
  
  val v5=BigInt(2)                                //> v5  : scala.math.BigInt = 2
  v5.pow(10)                                      //> res6: scala.math.BigInt = 1024
  
  //--4种前缀操作符,前面需要加空格
  val v6= +2                                      //> v6  : Int = 2
  val v7= -2                                      //> v7  : Int = -2
  val v8= !true                                   //> v8  : Boolean = false
  val v9= ~0XFF                                   //> v9  : Int = -256
  
  //--可以通过unary来避免歧义
  val v10=2.unary_+                               //> v10  : Int = 2
  val v11=2.unary_-                               //> v11  : Int = -2
  val v12=true.unary_!                            //> v12  : Boolean = false
  val v13=0XFF.unary_~                            //> v13  : Int = -256
  
}