import scala.collection.mutable.ArrayBuffer
/*
学习Array
*/
object Demo02 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(117); 
  println("Welcome to the Scala worksheet");$skip(58); 
  
  //--声明一个定长数组，一经声明，数组元素个数不能改变
  val a1=Array(1,2,3,4);System.out.println("""a1  : Array[Int] = """ + $show(a1 ));$skip(27); 
  val a2=new Array[Int](3);System.out.println("""a2  : Array[Int] = """ + $show(a2 ));$skip(92); 
  
  //--声明一个变长数组，并赋初始值
  //--mutable 可变
  //--immutable 不可变
  val a3=ArrayBuffer(1,2,3,4);System.out.println("""a3  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(a3 ));$skip(33); 
  val a4=new ArrayBuffer[Int](3);System.out.println("""a4  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(a4 ));$skip(63); 
  
  //--定长数组赋值,通过下标赋值
  for(i<-0 until a2.length){
  	a2(i)=4
  };$skip(9); val res$0 = 
  a2;System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(21); val res$1 = 
  //--通过下标取值
  a2(0);System.out.println("""res1: Int = """ + $show(res$1));$skip(72); 
  
  //--变长数组一般是通过append来赋值。用下标赋值也可以
  for(i<-1 to 10){
  	a4.append(i)
  };$skip(9); val res$2 = 
  a4;System.out.println("""res2: scala.collection.mutable.ArrayBuffer[Int] = """ + $show(res$2));$skip(25); 
  
  val a5=Array(1,2,3);System.out.println("""a5  : Array[Int] = """ + $show(a5 ));$skip(22); 
  val a6=Array(4,5,6);System.out.println("""a6  : Array[Int] = """ + $show(a6 ));$skip(45); 
  
  //--拼接定长数组
  val a7=Array.concat(a5,a6);System.out.println("""a7  : Array[Int] = """ + $show(a7 ));$skip(48); 
  //--拼接变长数组
  val a8=ArrayBuffer.concat(a3,a4);System.out.println("""a8  : scala.collection.mutable.ArrayBuffer[Int] = """ + $show(a8 ));$skip(59); 
 	//--生成区间数组，并指定步长。一般用于准备实验数据
  val a9=Array.range(0, 5,2);System.out.println("""a9  : Array[Int] = """ + $show(a9 ));$skip(92); val res$3 = 
  
  //--创建一个 将匿名函数应用于初始值的数组。
  //--iterate(start,length)(f:)
  Array.iterate(0, 5)(x=>x*2);System.out.println("""res3: Array[Int] = """ + $show(res$3));$skip(56); val res$4 = 
  
  //--创建一个 将匿名函数应用于下标的数组
  Array.tabulate(5)(x=>x*2);System.out.println("""res4: Array[Int] = """ + $show(res$4));$skip(12); val res$5 = 
  
  a5.sum;System.out.println("""res5: Int = """ + $show(res$5));$skip(9); val res$6 = 
  a5.min;System.out.println("""res6: Int = """ + $show(res$6));$skip(9); val res$7 = 
  a5.max;System.out.println("""res7: Int = """ + $show(res$7));$skip(30); 
  
  val a10=Array(2,1,5,4,3);System.out.println("""a10  : Array[Int] = """ + $show(a10 ));$skip(36); 
  scala.util.Sorting.quickSort(a10);$skip(9); val res$8 = 
  
  a10;System.out.println("""res8: Array[Int] = """ + $show(res$8));$skip(14); val res$9 = 
  a10 reverse;System.out.println("""res9: Array[Int] = """ + $show(res$9));$skip(26); 
  
  a10.foreach{println};$skip(24); val res$10 = 
  
  a10.filter{_%2==0};System.out.println("""res10: Array[Int] = """ + $show(res$10));$skip(17); val res$11 = 
  
  a10.drop(1);System.out.println("""res11: Array[Int] = """ + $show(res$11));$skip(19); val res$12 = 
  a10.dropRight(1);System.out.println("""res12: Array[Int] = """ + $show(res$12));$skip(17); val res$13 = 
  
  a10.take(2);System.out.println("""res13: Array[Int] = """ + $show(res$13));$skip(14); val res$14 = 
  a10.take(1);System.out.println("""res14: Array[Int] = """ + $show(res$14));$skip(11); val res$15 = 
  a10.head;System.out.println("""res15: Int = """ + $show(res$15))}
}
