/*
学习scala 函数的声明和调用
知识点
1.scala通过 def 关键字来定义一个函数。
def 函数名(参数列表):返回值类型={方法体}
2.scala可以自动推断出函数的返回值类型
3.需要注意的是：使用自动推断，必须有 = 。 否则函数的返回值都是Unit(void)类型
4.声明一个函数，默认的访问权限是public。此外也可以用private 或 protected来修饰
5.scala中泛型的声明是通过[] 比如Array[Int]。不同于java的<Int>
*/
object Demo07 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def f1():String={
  	println("hello1804")
  	"123"
  }                                               //> f1: ()String
  def f2():Unit=println("hello")                  //> f2: ()Unit
 	
 	def f3()={
  	println("hello1804")
  	"123"
  }                                               //> f3: ()String
  
  def f4(){
  	println("hello1804")
  	"123"
  }                                               //> f4: ()Unit
  
  def f5(a:Int,b:Int)=a+b                         //> f5: (a: Int, b: Int)Int
  
  f5(2,3)                                         //> res0: Int = 5
  
  def f6(a:String,b:Int)=a*b                      //> f6: (a: String, b: Int)String
  
  f6("hello",3)                                   //> res1: String = hellohellohello
  
  def f7(a:Array[Int])={
  	for(i<-a){
  		println(i)
  	}
  }                                               //> f7: (a: Array[Int])Unit
  val a1=Array(1,2,3,4)                           //> a1  : Array[Int] = Array(1, 2, 3, 4)
  f7(a1)                                          //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
 	def f8(a:Array[Int])=for(i<-a)yield{i*2}  //> f8: (a: Array[Int])Array[Int]
 	
 	val a2=f8(a1)                             //> a2  : Array[Int] = Array(2, 4, 6, 8)
 	
 	//--scala的默认参数机制
 	def f9(a:String,b:String="[",c:String="]")={
 		b+a+c
 	}                                         //> f9: (a: String, b: String, c: String)String
 	
 	f9("hello","(",")")                       //> res2: String = (hello)
 	
 	//--scala也支持可变参数
 	//--变长参数本质上一个集合类型
 	def f10(a:String*)={
 		for(i<-a){
 			println(i)
 		}
 	}                                         //> f10: (a: String*)Unit
 	
 	f10("hello","world")                      //> hello
                                                  //| world
 	
 	def f11(a:Int*)={
// 		var sum=0
// 		for(i<-a){
// 			sum+=i
// 		}
//		sum
		a.sum
 	}                                         //> f11: (a: Int*)Int
 	
 	f11(2,3,4)                                //> res3: Int = 9
 	
 	//--注意：变长参数需位于参数列表最后，同java
 	def f12(a:String,b:Int*)={
 	
 	}                                         //> f12: (a: String, b: Int*)Unit
 	
 	val p1=new Person                         //> p1  : Person = Person@3b8e2477
 	p1.eat()                                  //> eat
 	
}