/*
学习for循环的使用，重点掌握
*/

import util.control.Breaks._
import scala.util.control.Exception.Finally
object Demo05 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val l1=List(1,2,3,4)                            //> l1  : List[Int] = List(1, 2, 3, 4)
  
  for(i <- l1){
  	println(i)                                //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  }
  
  for(i<-l1)println(i)                            //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
 	for(i<- 1 to 10 by 2)println(i)           //> 1
                                                  //| 3
                                                  //| 5
                                                  //| 7
                                                  //| 9
 	
 	val s1="helloworld"                       //> s1  : String = helloworld
 	for(i<-s1)println(i)                      //> h
                                                  //| e
                                                  //| l
                                                  //| l
                                                  //| o
                                                  //| w
                                                  //| o
                                                  //| r
                                                  //| l
                                                  //| d
  //--scala for循环的卫语句
  for(i<- 1 to 10;if(i>5))println(i)              //> 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
  
  for(i<- 1 to 10;if(i>5);if(i%2==0))println(i)   //> 6
                                                  //| 8
                                                  //| 10
 	//--通过scala的for循环，打印9*9乘法表
 	//1*1=1
 	//1*2=2 2*2=4
 	//1*3=3 2*3=6 3*3=9
 	
 	
 	for(a<-1 to 9){
 		for(b<- 1 to a){
 			print(b+"*"+a+"="+b*a+"\t")
 		}
 		println()
 	}                                         //> 1*1=1	
                                                  //| 1*2=2	2*2=4	
                                                  //| 1*3=3	2*3=6	3*3=9	
                                                  //| 1*4=4	2*4=8	3*4=12	4*4=16	
                                                  //| 1*5=5	2*5=10	3*5=15	4*5=20	5*5=25	
                                                  //| 1*6=6	2*6=12	3*6=18	4*6=24	5*6=30	6*6=36	
                                                  //| 1*7=7	2*7=14	3*7=21	4*7=28	5*7=35	6*7=42	7*7=49	
                                                  //| 1*8=8	2*8=16	3*8=24	4*8=32	5*8=40	6*8=48	7*8=56	8*8=64	
                                                  //| 1*9=9	2*9=18	3*9=27	4*9=36	5*9=45	6*9=54	7*9=63	8*9=72	9*9=81	
                                                  //| 
   
  //--s函数，可以通过${}来取值
 for(a<-1 to 9){
  	for(b<- 1 to a){
 			print(s"$b*$a=${b*a}\t")
 		}
 		println()
 	}                                         //> 1*1=1	
                                                  //| 1*2=2	2*2=4	
                                                  //| 1*3=3	2*3=6	3*3=9	
                                                  //| 1*4=4	2*4=8	3*4=12	4*4=16	
                                                  //| 1*5=5	2*5=10	3*5=15	4*5=20	5*5=25	
                                                  //| 1*6=6	2*6=12	3*6=18	4*6=24	5*6=30	6*6=36	
                                                  //| 1*7=7	2*7=14	3*7=21	4*7=28	5*7=35	6*7=42	7*7=49	
                                                  //| 1*8=8	2*8=16	3*8=24	4*8=32	5*8=40	6*8=48	7*8=56	8*8=64	
                                                  //| 1*9=9	2*9=18	3*9=27	4*9=36	5*9=45	6*9=54	7*9=63	8*9=72	9*9=81	
                                                  //| 
  for(a<-1 to 9;b<-1 to a;val sep=if(a==b)"\r\n"else"\t" ){
  	 print(s"$b*$a=${a*b}$sep")               //> 1*1=1
                                                  //| 1*2=2	2*2=4
                                                  //| 1*3=3	2*3=6	3*3=9
                                                  //| 1*4=4	2*4=8	3*4=12	4*4=16
                                                  //| 1*5=5	2*5=10	3*5=15	4*5=20	5*5=25
                                                  //| 1*6=6	2*6=12	3*6=18	4*6=24	5*6=30	6*6=36
                                                  //| 1*7=7	2*7=14	3*7=21	4*7=28	5*7=35	6*7=42	7*7=49
                                                  //| 1*8=8	2*8=16	3*8=24	4*8=32	5*8=40	6*8=48	7*8=56	8*8=64
                                                  //| 1*9=9	2*9=18	3*9=27	4*9=36	5*9=45	6*9=54	7*9=63	8*9=72	9*9=81
  }
  
  val a1=Array(1,2,3,4)                           //> a1  : Array[Int] = Array(1, 2, 3, 4)
  for(i<-a1)println(i)                            //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  
  val l2=List(1,2,3,4)                            //> l2  : List[Int] = List(1, 2, 3, 4)
  for(i<-l2)println(i)                            //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  
  val m1=Map("tom"->23,"rose"->25,"jim"->30)      //> m1  : scala.collection.immutable.Map[String,Int] = Map(tom -> 23, rose -> 25
                                                  //| , jim -> 30)
  
  for(i<-m1)println(i)                            //> (tom,23)
                                                  //| (rose,25)
                                                  //| (jim,30)
  
  for((k,v)<-m1)println(k)                        //> tom
                                                  //| rose
                                                  //| jim
  
  //-- for yield表达式，将for循环结果返回到一个新的集合类型中
  //-- for yield表示式，遍历的是什么集合类型，返回的就是什么类型
  //-- scala中的集合包含：Array,List,Range,Map,Set,Tuple
  val l3=for(i<-l2)yield{i*2}                     //> l3  : List[Int] = List(2, 4, 6, 8)
  val a2=for(i<-a1)yield{i*3}                     //> a2  : Array[Int] = Array(3, 6, 9, 12)
  val m2=for((k,v)<-m1)yield{(k,v+10)}            //> m2  : scala.collection.immutable.Map[String,Int] = Map(tom -> 33, rose -> 3
                                                  //| 5, jim -> 40)
  	
}