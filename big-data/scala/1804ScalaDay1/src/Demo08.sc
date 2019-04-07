/*
学习scala的匿名函数
知识点
1.匿名函数没有函数名。形式：(参数列表……)=>{方法体}
*/
object Demo08 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //--普通的成员函数
  def f1(a:Int,b:Int)={a+b}                       //> f1: (a: Int, b: Int)Int
  
  //--声明一个匿名函数
  (a:Int,b:Int)=>{a+b}                            //> res0: (Int, Int) => Int = <function2>
  
  
  //--声明一个高阶函数，可以把函数做为参数传递
  def f2(a:Int,b:Int,f:(Int,Int)=>Int)={
  	f(a,b)
  }                                               //> f2: (a: Int, b: Int, f: (Int, Int) => Int)Int
  
  f2(2,3,(a:Int,b:Int)=>{a+b})                    //> res1: Int = 5
  f2(2,3,(a:Int,b:Int)=>{a*b})                    //> res2: Int = 6
  
  //--方法体只有一行代码，{}方法体可以省略
  f2(2,3,(a:Int,b:Int)=>a+b)                      //> res3: Int = 5
  //--匿名函数的参数类型如果能推断出来，类型可以省略
  f2(2,3,(a,b)=>a+b)                              //> res4: Int = 5
  
  //--定义个高阶函数，接收一个a:String,和一个匿名函数 f:(String)=>String
  
  def f3(a:String,f:(String)=>String)={
  	f(a)
  }                                               //> f3: (a: String, f: String => String)String
  
  f3("hello",(a:String)=>{a.mkString(",")})       //> res5: String = h,e,l,l,o
  
  //--匿名函数如果参数列表只有一个，则()可以省略
  f3("hello",a=>a.mkString(","))                  //> res6: String = h,e,l,l,o
  
  val a1=Array(1,2,3,4)                           //> a1  : Array[Int] = Array(1, 2, 3, 4)
  a1.foreach{(num:Int)=>{println(num)}}           //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  a1.foreach{num=>println(num)}                   //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  a1.filter{(num:Int)=>{num%2==0}}                //> res7: Array[Int] = Array(2, 4)
  
  a1.filter{num=>num%2==0}                        //> res8: Array[Int] = Array(2, 4)
  
  //--①a=1 b=2 a+b=3
  //--②a=3 b=3 a+b=6
  //--③a=6 b=4 a+b=10
  a1.reduceLeft{(a:Int,b:Int)=>{a+b}}             //> res9: Int = 10
  
  a1.reduceLeft{(a,b)=>a+b}                       //> res10: Int = 10
  
  //--最终极的化简规则  scala可以用 _ 来化简
	f2(2,3,_+_)                               //> res11: Int = 5
	f2(2,3,_*_)                               //> res12: Int = 6
	a1.reduceLeft{_+_}                        //> res13: Int = 10
	a1.reduceLeft{_*_}                        //> res14: Int = 24
	a1.filter{_%2==0}                         //> res15: Array[Int] = Array(2, 4)
}