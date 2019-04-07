/*
学习for循环的使用，重点掌握
*/

import util.control.Breaks._
import scala.util.control.Exception.Finally
object Demo05 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(155); 
  println("Welcome to the Scala worksheet");$skip(26); 
  
  val l1=List(1,2,3,4);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(33); 
  
  for(i <- l1){
  	println(i)
  };$skip(30); 
  
  for(i<-l1)println(i);$skip(34); 
 	for(i<- 1 to 10 by 2)println(i);$skip(25); 
 	
 	val s1="helloworld";System.out.println("""s1  : String = """ + $show(s1 ));$skip(23); 
 	for(i<-s1)println(i);$skip(59); 
  //--scala for循环的卫语句
  for(i<- 1 to 10;if(i>5))println(i);$skip(51); 
  
  for(i<- 1 to 10;if(i>5);if(i%2==0))println(i);$skip(175); 
 	//--通过scala的for循环，打印9*9乘法表
 	//1*1=1
 	//1*2=2 2*2=4
 	//1*3=3 2*3=6 3*3=9
 	
 	
 	for(a<-1 to 9){
 		for(b<- 1 to a){
 			print(b+"*"+a+"="+b*a+"\t")
 		}
 		println()
 	};$skip(113); 
   
  //--s函数，可以通过${}来取值
 for(a<-1 to 9){
  	for(b<- 1 to a){
 			print(s"$b*$a=${b*a}\t")
 		}
 		println()
 	};$skip(91); 
  for(a<-1 to 9;b<-1 to a;val sep=if(a==b)"\r\n"else"\t" ){
  	 print(s"$b*$a=${a*b}$sep")
  };$skip(31); 
  
  val a1=Array(1,2,3,4);System.out.println("""a1  : Array[Int] = """ + $show(a1 ));$skip(23); 
  for(i<-a1)println(i);$skip(26); 
  
  val l2=List(1,2,3,4);System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(23); 
  for(i<-l2)println(i);$skip(48); 
  
  val m1=Map("tom"->23,"rose"->25,"jim"->30);System.out.println("""m1  : scala.collection.immutable.Map[String,Int] = """ + $show(m1 ));$skip(26); 
  
  for(i<-m1)println(i);$skip(30); 
  
  for((k,v)<-m1)println(k);$skip(165); 
  
  //-- for yield表达式，将for循环结果返回到一个新的集合类型中
  //-- for yield表示式，遍历的是什么集合类型，返回的就是什么类型
  //-- scala中的集合包含：Array,List,Range,Map,Set,Tuple
  val l3=for(i<-l2)yield{i*2};System.out.println("""l3  : List[Int] = """ + $show(l3 ));$skip(30); 
  val a2=for(i<-a1)yield{i*3};System.out.println("""a2  : Array[Int] = """ + $show(a2 ));$skip(39); 
  val m2=for((k,v)<-m1)yield{(k,v+10)};System.out.println("""m2  : scala.collection.immutable.Map[String,Int] = """ + $show(m2 ))}
  	
}
