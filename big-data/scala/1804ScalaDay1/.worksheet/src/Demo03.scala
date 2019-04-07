/*
学习Int类型常用的操作方法
知识点
1.scala中，都是对象和方法，没有基本类型。所以说scala是一门面向对象的语言
此外，也是面向函数的语言
2.scala通过隐式转换，Int->RichInt
此外还有RichDouble RichFloat
3.建议初学时，浏览：https://www.scala-lang.org/api/2.10.4/index.html
*/
object Demo03 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(252); 
  println("Welcome to the Scala worksheet");$skip(14); 
  
  val v1=1;System.out.println("""v1  : Int = """ + $show(v1 ));$skip(28); val res$0 = 
  
  //--生成一个区间数组
  1.to(5);System.out.println("""res0: scala.collection.immutable.Range.Inclusive = """ + $show(res$0));$skip(28); val res$1 = 
  //--生成区间并指定步长
  1.to(5,2);System.out.println("""res1: scala.collection.immutable.Range.Inclusive = """ + $show(res$1));$skip(34); val res$2 = 
  
  //--生成区间，但不含尾元素
  1.until(5);System.out.println("""res2: scala.collection.immutable.Range = """ + $show(res$2));$skip(15); val res$3 = 
  1.until(5,2);System.out.println("""res3: scala.collection.immutable.Range = """ + $show(res$3));$skip(46); 
  
  //--按操作符优先级来运算。优先级同java
  val v2=(1+2)*3;System.out.println("""v2  : Int = """ + $show(v2 ));$skip(39); 
  //--按方法的调用顺序来运算
  val v3=1.+(2).*(3);System.out.println("""v3  : Int = """ + $show(v3 ));$skip(17); 
  
  val v4=1234;System.out.println("""v4  : Int = """ + $show(v4 ));$skip(16); val res$4 = 
  v4.toString();System.out.println("""res4: String = """ + $show(res$4));$skip(14); val res$5 = 
  v4.toDouble;System.out.println("""res5: Double = """ + $show(res$5));$skip(22); 
  
  val v5=BigInt(2);System.out.println("""v5  : scala.math.BigInt = """ + $show(v5 ));$skip(13); val res$6 = 
  v5.pow(10);System.out.println("""res6: scala.math.BigInt = """ + $show(res$6));$skip(38); 
  
  //--4种前缀操作符,前面需要加空格
  val v6= +2;System.out.println("""v6  : Int = """ + $show(v6 ));$skip(13); 
  val v7= -2;System.out.println("""v7  : Int = """ + $show(v7 ));$skip(16); 
  val v8= !true;System.out.println("""v8  : Boolean = """ + $show(v8 ));$skip(16); 
  val v9= ~0XFF;System.out.println("""v9  : Int = """ + $show(v9 ));$skip(44); 
  
  //--可以通过unary来避免歧义
  val v10=2.unary_+;System.out.println("""v10  : Int = """ + $show(v10 ));$skip(20); 
  val v11=2.unary_-;System.out.println("""v11  : Int = """ + $show(v11 ));$skip(23); 
  val v12=true.unary_!;System.out.println("""v12  : Boolean = """ + $show(v12 ));$skip(23); 
  val v13=0XFF.unary_~;System.out.println("""v13  : Int = """ + $show(v13 ))}
  
}
