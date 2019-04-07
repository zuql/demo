/*
学习scala的匿名函数
知识点
1.匿名函数没有函数名。形式：(参数列表……)=>{方法体}
*/
object Demo08 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(113); 
  println("Welcome to the Scala worksheet");$skip(45); 
  
  //--普通的成员函数
  def f1(a:Int,b:Int)={a+b};System.out.println("""f1: (a: Int, b: Int)Int""");$skip(41); val res$0 = 
  
  //--声明一个匿名函数
  (a:Int,b:Int)=>{a+b};System.out.println("""res0: (Int, Int) => Int = """ + $show(res$0));$skip(88); 
  
  
  //--声明一个高阶函数，可以把函数做为参数传递
  def f2(a:Int,b:Int,f:(Int,Int)=>Int)={
  	f(a,b)
  };System.out.println("""f2: (a: Int, b: Int, f: (Int, Int) => Int)Int""");$skip(34); val res$1 = 
  
  f2(2,3,(a:Int,b:Int)=>{a+b});System.out.println("""res1: Int = """ + $show(res$1));$skip(31); val res$2 = 
  f2(2,3,(a:Int,b:Int)=>{a*b});System.out.println("""res2: Int = """ + $show(res$2));$skip(58); val res$3 = 
  
  //--方法体只有一行代码，{}方法体可以省略
  f2(2,3,(a:Int,b:Int)=>a+b);System.out.println("""res3: Int = """ + $show(res$3));$skip(51); val res$4 = 
  //--匿名函数的参数类型如果能推断出来，类型可以省略
  f2(2,3,(a,b)=>a+b);System.out.println("""res4: Int = """ + $show(res$4));$skip(112); 
  
  //--定义个高阶函数，接收一个a:String,和一个匿名函数 f:(String)=>String
  
  def f3(a:String,f:(String)=>String)={
  	f(a)
  };System.out.println("""f3: (a: String, f: String => String)String""");$skip(47); val res$5 = 
  
  f3("hello",(a:String)=>{a.mkString(",")});System.out.println("""res5: String = """ + $show(res$5));$skip(65); val res$6 = 
  
  //--匿名函数如果参数列表只有一个，则()可以省略
  f3("hello",a=>a.mkString(","));System.out.println("""res6: String = """ + $show(res$6));$skip(27); 
  
  val a1=Array(1,2,3,4);System.out.println("""a1  : Array[Int] = """ + $show(a1 ));$skip(40); 
  a1.foreach{(num:Int)=>{println(num)}};$skip(32); 
  a1.foreach{num=>println(num)};$skip(35); val res$7 = 
  a1.filter{(num:Int)=>{num%2==0}};System.out.println("""res7: Array[Int] = """ + $show(res$7));$skip(30); val res$8 = 
  
  a1.filter{num=>num%2==0};System.out.println("""res8: Array[Int] = """ + $show(res$8));$skip(105); val res$9 = 
  
  //--①a=1 b=2 a+b=3
  //--②a=3 b=3 a+b=6
  //--③a=6 b=4 a+b=10
  a1.reduceLeft{(a:Int,b:Int)=>{a+b}};System.out.println("""res9: Int = """ + $show(res$9));$skip(31); val res$10 = 
  
  a1.reduceLeft{(a,b)=>a+b};System.out.println("""res10: Int = """ + $show(res$10));$skip(47); val res$11 = 
  
  //--最终极的化简规则  scala可以用 _ 来化简
	f2(2,3,_+_);System.out.println("""res11: Int = """ + $show(res$11));$skip(13); val res$12 = 
	f2(2,3,_*_);System.out.println("""res12: Int = """ + $show(res$12));$skip(20); val res$13 = 
	a1.reduceLeft{_+_};System.out.println("""res13: Int = """ + $show(res$13));$skip(20); val res$14 = 
	a1.reduceLeft{_*_};System.out.println("""res14: Int = """ + $show(res$14));$skip(19); val res$15 = 
	a1.filter{_%2==0};System.out.println("""res15: Array[Int] = """ + $show(res$15))}
}
