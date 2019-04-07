/*
学习List
*/
import scala.collection.mutable.ListBuffer

object Demo03 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(117); 
  println("Welcome to the Scala worksheet");$skip(49); 
  
  //--声明一个定长List，并赋初始值
  val l1=List(1,2,3,4);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(28); 
  
  val l2=1::2::3::4::Nil;System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(47); 
  
  //--声明一个空的定长List
  val l3=List[Nothing]();System.out.println("""l3  : List[Nothing] = """ + $show(l3 ));$skip(49); 
  
  //--声明一个变长List
  val l4=ListBuffer(1,2,3,4);System.out.println("""l4  : scala.collection.mutable.ListBuffer[Int] = """ + $show(l4 ));$skip(13); val res$0 = 
  
  l1.head;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  l1.last;System.out.println("""res1: Int = """ + $show(res$1));$skip(18); val res$2 = 
   
  l1.take(1);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(16); val res$3 = 
  
  l1.drop(1);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(10); val res$4 = 
  l1.tail;System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(16); val res$5 = 
  
  l3.isEmpty;System.out.println("""res5: Boolean = """ + $show(res$5));$skip(13); val res$6 = 
  l2.isEmpty;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(24); 
  
  val l5=List(1,2,3);System.out.println("""l5  : List[Int] = """ + $show(l5 ));$skip(21); 
  val l6=List(4,5,6);System.out.println("""l6  : List[Int] = """ + $show(l6 ));$skip(31); 
  
  val l7=List.concat(l5,l6);System.out.println("""l7  : List[Int] = """ + $show(l7 ));$skip(31); val res$7 = 
  //--等价于concat
  l5:::l6:::l7;System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(23); val res$8 = 
  
  List.fill(5)("a");System.out.println("""res8: List[String] = """ + $show(res$8));$skip(24); val res$9 = 
  List.tabulate(5)(_*2);System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(13); val res$10 = 
  l7 reverse;System.out.println("""res10: List[Int] = """ + $show(res$10));$skip(24); 
  
  val l8=List(1,2,3);System.out.println("""l8  : List[Int] = """ + $show(l8 ));$skip(71); 
  
  //-- +:是左侧加原色   :+右侧加元素
  //-- 以上两个方法都是返回新的List
  val l9=0+:l8:+4;System.out.println("""l9  : List[Int] = """ + $show(l9 ));$skip(12); val res$11 = 
  
  l9(2);System.out.println("""res11: Int = """ + $show(res$11));$skip(30); val res$12 = 
  //--等价于通过下标取值
  l9.apply(2);System.out.println("""res12: Int = """ + $show(res$12));$skip(20); val res$13 = 
  
  l9.contains(3);System.out.println("""res13: Boolean = """ + $show(res$13));$skip(30); 
  
  val a1=new Array[Int](5);System.out.println("""a1  : Array[Int] = """ + $show(a1 ));$skip(33); 
  l9.copyToArray(a1,0,l9.length);$skip(5); val res$14 = 
  a1;System.out.println("""res14: Array[Int] = """ + $show(res$14));$skip(23); 
  
  val a2=l9.toArray;System.out.println("""a2  : Array[Int] = """ + $show(a2 ));$skip(34); 
  
  
  val l10=List(1,1,2,2,3,3);System.out.println("""l10  : List[Int] = """ + $show(l10 ));$skip(35); 
  
  //--去重
  val l11=l10.distinct;System.out.println("""l11  : List[Int] = """ + $show(l11 ));$skip(30); val res$15 = 
  
  l10.exists { x => x==4 };System.out.println("""res15: Boolean = """ + $show(res$15));$skip(25); 
  
  val l12=List(1,2,3);System.out.println("""l12  : List[Int] = """ + $show(l12 ));$skip(22); 
  val l13=List(3,4,5);System.out.println("""l13  : List[Int] = """ + $show(l13 ));$skip(55); 
  //--取交集。可以应用于文件之间的取交集数据
  val l14=l12.intersect(l13);System.out.println("""l14  : List[Int] = """ + $show(l14 ));$skip(29); 
  
  val l15=List(1,2,3,4,5);System.out.println("""l15  : List[Int] = """ + $show(l15 ));$skip(76); val res$16 = 
  
  //--映射方法，重点掌握。可以改变集合中元素的形式
  //--map方法不会改变元素的个数
  l15.map { x => x*2 };System.out.println("""res16: List[Int] = """ + $show(res$16));$skip(28); val res$17 = 
  l15.map { x => Array(x) };System.out.println("""res17: List[Array[Int]] = """ + $show(res$17));$skip(52); 
  
  val l16=List(Array("tom",23),Array("rose",25));System.out.println("""l16  : List[Array[Any]] = """ + $show(l16 ));$skip(27); val res$18 = 
  
  l16.map { x => x(0) };System.out.println("""res18: List[Any] = """ + $show(res$18));$skip(51); 
  
  val l17=List(Array(1,1,2,2,3),Array(2,2,3,3));System.out.println("""l17  : List[Array[Int]] = """ + $show(l17 ));$skip(66); val res$19 = 
  
  //--掌握以下类型转换的技巧
  l17.map { x => x.toList.distinct.toArray };System.out.println("""res19: List[Array[Int]] = """ + $show(res$19));$skip(13); val res$20 = 
  
  l15.max;System.out.println("""res20: Int = """ + $show(res$20));$skip(10); val res$21 = 
  l15.min;System.out.println("""res21: Int = """ + $show(res$21));$skip(20); 
  
  val s1="hello";System.out.println("""s1  : String = """ + $show(s1 ));$skip(19); val res$22 = 
  s1.mkString(",");System.out.println("""res22: String = """ + $show(res$22));$skip(48); val res$23 = 
  //--将集合的元素转成String，并指定分隔符
  l15.mkString(",");System.out.println("""res23: String = """ + $show(res$23));$skip(29); 
  
  val l18=List(2,3,1,5,4);System.out.println("""l18  : List[Int] = """ + $show(l18 ));$skip(44); 
  scala.util.Sorting.quickSort(l18.toArray);$skip(67); 
  
  //--重点掌握，排序。如果要降序，则用前缀操作符  -
  val l19=l18.sortBy { x => -x };System.out.println("""l19  : List[Int] = """ + $show(l19 ));$skip(68); 
  
  val l20=List(Array("tom",35),Array("rose",30),Array("jim",40));System.out.println("""l20  : List[Array[Any]] = """ + $show(l20 ));$skip(66); val res$24 = 
  
  l20.map { x =>(x(0),x(1)) }.sortBy{x=>x._2.toString().toInt};System.out.println("""res24: List[(Any, Any)] = """ + $show(res$24));$skip(42); val res$25 = 
  
  l20.sortBy{x=>x(1).toString().toInt};System.out.println("""res25: List[Array[Any]] = """ + $show(res$25));$skip(25); val res$26 = 
  
  l18.reduceLeft(_+_);System.out.println("""res26: Int = """ + $show(res$26))}
 
}
