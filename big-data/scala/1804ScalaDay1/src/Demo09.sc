/*
学习scala的递归函数的编写
*/
object Demo09 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
 	
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
 	}                                         //> f1: (n: Int)Int
 	
 	f1(6)                                     //> res0: Int = 34
 	
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
 	}                                         //> f2: (n: Int)Int
 	
 	f2(8)                                     //> res1: Int = 32
 	
 	//--2 3 4 9 16 81 256 ……
 	//--f(n)=f(n-2)*f(n-2)
 	
 	def f3(n:Int):Int={
 		if(n==0)return 2
 		if(n==1)return 3
 		else f3(n-2)*f3(n-2)
 	}                                         //> f3: (n: Int)Int
 	
 	f3(7)                                     //> res2: Int = 6561
 	
}