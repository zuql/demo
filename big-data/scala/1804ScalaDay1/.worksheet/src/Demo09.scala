/*
学习scala的递归函数的编写
*/
object Demo09 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
  println("Welcome to the Scala worksheet");$skip(294); 
 	
 	//--斐波那契数列
 	//--2 3 5 8 13 21 ……
 	//--写递归函数找两样东西：
 	//--①找函数关系
 	//--f(n)=f(n-1)+f(n-2)
 	//--②找结束条件
 	//--f(0)==2 ; f(1)==3
 	
 	//--scala的递归函数：要求必须显示的指定返回值类型。不能用自动推断
 	//--结束条件的返回值，需要加return 关键字
 	def f1(n:Int):Int={
 		if(n==0)return 2
 		if(n==1)return 3
 		else f1(n-1)+f1(n-2)
 	};System.out.println("""f1: (n: Int)Int""");$skip(11); val res$0 = 
 	
 	f1(6);System.out.println("""res0: Int = """ + $show(res$0));$skip(255); 
 	
 	//--数据：2 3 4 9 8 27 16 81 ……
 	//--项数：0 1 2 3 4 5  6  7
 	//--如果n是偶数项：f(n)=2*f(n-2)
 	//--如果n是奇数项：f(n)=3*f(n-2)
 	//--结束条件 f(0)==2 f(1)==3
 	
 	def f2(n:Int):Int={
 		if(n==0)return 2
 		if(n==1)return 3
 		if(n%2==0) 2*f2(n-2)
 		else 3*f2(n-2)
 	};System.out.println("""f2: (n: Int)Int""");$skip(11); val res$1 = 
 	
 	f2(8);System.out.println("""res1: Int = """ + $show(res$1));$skip(148); 
 	
 	//--2 3 4 9 16 81 256 ……
 	//--f(n)=f(n-2)*f(n-2)
 	
 	def f3(n:Int):Int={
 		if(n==0)return 2
 		if(n==1)return 3
 		else f3(n-2)*f3(n-2)
 	};System.out.println("""f3: (n: Int)Int""");$skip(11); val res$2 = 
 	
 	f3(7);System.out.println("""res2: Int = """ + $show(res$2))}
 	
}
