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
object Demo07 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(307); 
  println("Welcome to the Scala worksheet");$skip(60); 
  
  def f1():String={
  	println("hello1804")
  	"123"
  };System.out.println("""f1: ()String""");$skip(33); 
  def f2():Unit=println("hello");System.out.println("""f2: ()Unit""");$skip(53); 
 	
 	def f3()={
  	println("hello1804")
  	"123"
  };System.out.println("""f3: ()String""");$skip(52); 
  
  def f4(){
  	println("hello1804")
  	"123"
  };System.out.println("""f4: ()Unit""");$skip(29); 
  
  def f5(a:Int,b:Int)=a+b;System.out.println("""f5: (a: Int, b: Int)Int""");$skip(13); val res$0 = 
  
  f5(2,3);System.out.println("""res0: Int = """ + $show(res$0));$skip(32); 
  
  def f6(a:String,b:Int)=a*b;System.out.println("""f6: (a: String, b: Int)String""");$skip(19); val res$1 = 
  
  f6("hello",3);System.out.println("""res1: String = """ + $show(res$1));$skip(66); 
  
  def f7(a:Array[Int])={
  	for(i<-a){
  		println(i)
  	}
  };System.out.println("""f7: (a: Array[Int])Unit""");$skip(24); 
  val a1=Array(1,2,3,4);System.out.println("""a1  : Array[Int] = """ + $show(a1 ));$skip(9); 
  f7(a1);$skip(43); 
 	def f8(a:Array[Int])=for(i<-a)yield{i*2};System.out.println("""f8: (a: Array[Int])Array[Int]""");$skip(19); 
 	
 	val a2=f8(a1);System.out.println("""a2  : Array[Int] = """ + $show(a2 ));$skip(82); 
 	
 	//--scala的默认参数机制
 	def f9(a:String,b:String="[",c:String="]")={
 		b+a+c
 	};System.out.println("""f9: (a: String, b: String, c: String)String""");$skip(25); val res$2 = 
 	
 	f9("hello","(",")");System.out.println("""res2: String = """ + $show(res$2));$skip(103); 
 	
 	//--scala也支持可变参数
 	//--变长参数本质上一个集合类型
 	def f10(a:String*)={
 		for(i<-a){
 			println(i)
 		}
 	};System.out.println("""f10: (a: String*)Unit""");$skip(26); 
 	
 	f10("hello","world");$skip(94); 
 	
 	def f11(a:Int*)={
// 		var sum=0
// 		for(i<-a){
// 			sum+=i
// 		}
//		sum
		a.sum
 	};System.out.println("""f11: (a: Int*)Int""");$skip(16); val res$3 = 
 	
 	f11(2,3,4);System.out.println("""res3: Int = """ + $show(res$3));$skip(68); 
 	
 	//--注意：变长参数需位于参数列表最后，同java
 	def f12(a:String,b:Int*)={
 	
 	};System.out.println("""f12: (a: String, b: Int*)Unit""");$skip(23); 
 	
 	val p1=new Person;System.out.println("""p1  : Person = """ + $show(p1 ));$skip(11); 
 	p1.eat()}
 	
}
