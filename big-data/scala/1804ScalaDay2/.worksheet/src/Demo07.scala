/*
常用的集合类型操作:
1.take(n)
2.takeRight(n)
3.drop(n)
4.dropRight(n)
5.head
6.last
7.tail(drop(1))
8.mkString(sep)
9.sum
10.max
11.min
12.distinct
13.sortBy (排序)
14.filter
15.map
16.mapValues(只有Map类型有,操作map的值)
17.reduceLeft(等价于reduce)
18.flatMap(扁平化map方法，一般用于读取文件后，操作行数据)
19.groupBy
*/
object Demo07 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(340); 
  println("Welcome to the Scala worksheet");$skip(60); 
  
  val l1=List("hello world","hello hadoop","hello 1804");System.out.println("""l1  : List[String] = """ + $show(l1 ));$skip(35); val res$0 = 
   
  l1.map { x => x.split(" ") };System.out.println("""res0: List[Array[String]] = """ + $show(res$0));$skip(35); val res$1 = 
  l1.flatMap { x => x.split(" ") };System.out.println("""res1: List[String] = """ + $show(res$1));$skip(104); val res$2 = 
  
  //--List(("hello",1),("word",1))
  l1.flatMap { line => line.split(" ") }.map { word => (word,1) };System.out.println("""res2: List[(String, Int)] = """ + $show(res$2));$skip(67); 
 
  val l2=List(("tom",300),("rose",210),("tom",100),("rose",200));System.out.println("""l2  : List[(String, Int)] = """ + $show(l2 ));$skip(70); 
  //--按指定字段做聚合，返回的类型Map[key,List[tuple]]
  val m1=l2.groupBy{x=>x._1};System.out.println("""m1  : scala.collection.immutable.Map[String,List[(String, Int)]] = """ + $show(m1 ));$skip(126); val res$3 = 
  
  //--基于m1,返回的Map("tom"->List(200,210),"rose"->List(300,310))
  
  m1.mapValues{list=>list.map{case(name,profit)=>profit}};System.out.println("""res3: scala.collection.immutable.Map[String,List[Int]] = """ + $show(res$3));$skip(245); 
  
  //--统计l1 中每个单词出现的频次
  //--最后的结果形式:
  //--(hello,3)
  //--(world,1)
  //--List("hello world","hello hadoop","hello 1804")
 	
 	l1.flatMap { line => line.split(" ")}
 		.groupBy { x => x }.mapValues { list => list.size }
 		.foreach{println};$skip(118); 
  l1.flatMap { line => line.split(" ")}
 		.groupBy { x => x }.map {case(k,list)=>(k,list.size)}
 		.foreach{println};$skip(145); val res$4 = 
 	
 	l1.flatMap { line => line.split(" ") }
 		.map{word=>(word,1)}
 		.groupBy{case(word,one)=>word}
 		.mapValues{list=>list.map{x=>x._2}.sum};System.out.println("""res4: scala.collection.immutable.Map[String,Int] = """ + $show(res$4));$skip(158); val res$5 = 
 		
 		
 	l1.flatMap { line => line.split(" ") }
 		.map{word=>(word,1)}
 		.groupBy{case(word,one)=>word}
 		.mapValues{list=>list.map{x=>x._2}.reduce(_+_)};System.out.println("""res5: scala.collection.immutable.Map[String,Int] = """ + $show(res$5));$skip(115); val res$6 = 
 	
 	l1.flatMap {_.split(" ")}
 		.map{(_,1)}
 		.groupBy{_._1}
 		.mapValues{list=>list.map{x=>x._2}.reduce(_+_)};System.out.println("""res6: scala.collection.immutable.Map[String,Int] = """ + $show(res$6))}
}
