/*
学习柯里化的概念
柯里化的作用一是允许将接受多个参数的函数转变为接受单一参数的函数
作用二允许用户自建控制结构
*/
object Demo01 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(121); 
  println("Welcome to the Scala worksheet");$skip(14); 
  
  val v1=2;System.out.println("""v1  : Int = """ + $show(v1 ));$skip(76); 
  
  //--懒值,只要当真正使用是才会赋值
  //--注意，懒值只能修饰常量(val)，不能修饰变量(var)
  lazy val v2=2;System.out.println("""v2: => Int""");$skip(35); 
  
  //lazy var v3=2
  println(v2);$skip(31); 
  
  def f1(a:Int,b:Int)={a+b};System.out.println("""f1: (a: Int, b: Int)Int""");$skip(67); 
  
  //--scala底层支持柯里化技术，允许一个函数接收单一参数
  def f11(a:Int)(b:Int)={a+b};System.out.println("""f11: (a: Int)(b: Int)Int""");$skip(13); val res$0 = 
  
  f1(2,3);System.out.println("""res0: Int = """ + $show(res$0));$skip(12); val res$1 = 
  f11(2)(3);System.out.println("""res1: Int = """ + $show(res$1));$skip(39); 
  
  def f2(a:Int,b:Int,c:Int)={a+b+c};System.out.println("""f2: (a: Int, b: Int, c: Int)Int""");$skip(42); 
  
  def f21(a:Int)(b:Int)(c:Int)={a+b+c};System.out.println("""f21: (a: Int)(b: Int)(c: Int)Int""");$skip(41); 
  
  def f22(a:Int)(b:Int,c:Int)={a+b+c};System.out.println("""f22: (a: Int)(b: Int, c: Int)Int""");$skip(41); 
  
  def f23(a:Int,b:Int)(c:Int)={a+b+c};System.out.println("""f23: (a: Int, b: Int)(c: Int)Int""");$skip(18); val res$2 = 
  
 	f21(2)(3)(4);System.out.println("""res2: Int = """ + $show(res$2));$skip(14); val res$3 = 
 	f22(2)(3,4);System.out.println("""res3: Int = """ + $show(res$3));$skip(14); val res$4 = 
 	f23(2,3)(4);System.out.println("""res4: Int = """ + $show(res$4));$skip(51); 
 	
 	def f3(a:Int,b:Int,f:(Int,Int)=>Int)={f(a,b)};System.out.println("""f3: (a: Int, b: Int, f: (Int, Int) => Int)Int""");$skip(53); 
  
  def f31(a:Int)(b:Int,f:(Int,Int)=>Int)={f(a,b)};System.out.println("""f31: (a: Int)(b: Int, f: (Int, Int) => Int)Int""");$skip(50); 
  def f32(a:Int,b:Int)(f:(Int,Int)=>Int)={f(a,b)};System.out.println("""f32: (a: Int, b: Int)(f: (Int, Int) => Int)Int""");$skip(51); 
  def f33(a:Int)(b:Int)(f:(Int,Int)=>Int)={f(a,b)};System.out.println("""f33: (a: Int)(b: Int)(f: (Int, Int) => Int)Int""");$skip(60); val res$5 = 
  
  //--下面的形式属于用户自建的控制结构。一部分都是参数，另一部分是匿名函数
  f32(2,3)(_+_);System.out.println("""res5: Int = """ + $show(res$5))}
}
