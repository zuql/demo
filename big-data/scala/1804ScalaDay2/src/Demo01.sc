/*
学习柯里化的概念
柯里化的作用一是允许将接受多个参数的函数转变为接受单一参数的函数
作用二允许用户自建控制结构
*/
object Demo01 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val v1=2                                        //> v1  : Int = 2
  
  //--懒值,只要当真正使用是才会赋值
  //--注意，懒值只能修饰常量(val)，不能修饰变量(var)
  lazy val v2=2                                   //> v2: => Int
  
  //lazy var v3=2
  println(v2)                                     //> 2
  
  def f1(a:Int,b:Int)={a+b}                       //> f1: (a: Int, b: Int)Int
  
  //--scala底层支持柯里化技术，允许一个函数接收单一参数
  def f11(a:Int)(b:Int)={a+b}                     //> f11: (a: Int)(b: Int)Int
  
  f1(2,3)                                         //> res0: Int = 5
  f11(2)(3)                                       //> res1: Int = 5
  
  def f2(a:Int,b:Int,c:Int)={a+b+c}               //> f2: (a: Int, b: Int, c: Int)Int
  
  def f21(a:Int)(b:Int)(c:Int)={a+b+c}            //> f21: (a: Int)(b: Int)(c: Int)Int
  
  def f22(a:Int)(b:Int,c:Int)={a+b+c}             //> f22: (a: Int)(b: Int, c: Int)Int
  
  def f23(a:Int,b:Int)(c:Int)={a+b+c}             //> f23: (a: Int, b: Int)(c: Int)Int
  
 	f21(2)(3)(4)                              //> res2: Int = 9
 	f22(2)(3,4)                               //> res3: Int = 9
 	f23(2,3)(4)                               //> res4: Int = 9
 	
 	def f3(a:Int,b:Int,f:(Int,Int)=>Int)={f(a,b)}
                                                  //> f3: (a: Int, b: Int, f: (Int, Int) => Int)Int
  
  def f31(a:Int)(b:Int,f:(Int,Int)=>Int)={f(a,b)} //> f31: (a: Int)(b: Int, f: (Int, Int) => Int)Int
  def f32(a:Int,b:Int)(f:(Int,Int)=>Int)={f(a,b)} //> f32: (a: Int, b: Int)(f: (Int, Int) => Int)Int
  def f33(a:Int)(b:Int)(f:(Int,Int)=>Int)={f(a,b)}//> f33: (a: Int)(b: Int)(f: (Int, Int) => Int)Int
  
  //--下面的形式属于用户自建的控制结构。一部分都是参数，另一部分是匿名函数
  f32(2,3)(_+_)                                   //> res5: Int = 5
}