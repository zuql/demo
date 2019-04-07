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
object Demo07 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val l1=List("hello world","hello hadoop","hello 1804")
                                                  //> l1  : List[String] = List(hello world, hello hadoop, hello 1804)
   
  l1.map { x => x.split(" ") }                    //> res0: List[Array[String]] = List(Array(hello, world), Array(hello, hadoop), 
                                                  //| Array(hello, 1804))
  l1.flatMap { x => x.split(" ") }                //> res1: List[String] = List(hello, world, hello, hadoop, hello, 1804)
  
  //--List(("hello",1),("word",1))
  l1.flatMap { line => line.split(" ") }.map { word => (word,1) }
                                                  //> res2: List[(String, Int)] = List((hello,1), (world,1), (hello,1), (hadoop,1)
                                                  //| , (hello,1), (1804,1))
 
  val l2=List(("tom",300),("rose",210),("tom",100),("rose",200))
                                                  //> l2  : List[(String, Int)] = List((tom,300), (rose,210), (tom,100), (rose,200
                                                  //| ))
  //--按指定字段做聚合，返回的类型Map[key,List[tuple]]
  val m1=l2.groupBy{x=>x._1}                      //> m1  : scala.collection.immutable.Map[String,List[(String, Int)]] = Map(rose 
                                                  //| -> List((rose,210), (rose,200)), tom -> List((tom,300), (tom,100)))
  
  //--基于m1,返回的Map("tom"->List(200,210),"rose"->List(300,310))
  
  m1.mapValues{list=>list.map{case(name,profit)=>profit}}
                                                  //> res3: scala.collection.immutable.Map[String,List[Int]] = Map(rose -> List(21
                                                  //| 0, 200), tom -> List(300, 100))
  
  //--统计l1 中每个单词出现的频次
  //--最后的结果形式:
  //--(hello,3)
  //--(world,1)
  //--List("hello world","hello hadoop","hello 1804")
 	
 	l1.flatMap { line => line.split(" ")}
 		.groupBy { x => x }.mapValues { list => list.size }
 		.foreach{println}                 //> (1804,1)
                                                  //| (hadoop,1)
                                                  //| (world,1)
                                                  //| (hello,3)
  l1.flatMap { line => line.split(" ")}
 		.groupBy { x => x }.map {case(k,list)=>(k,list.size)}
 		.foreach{println}                 //> (1804,1)
                                                  //| (hadoop,1)
                                                  //| (world,1)
                                                  //| (hello,3)
 	
 	l1.flatMap { line => line.split(" ") }
 		.map{word=>(word,1)}
 		.groupBy{case(word,one)=>word}
 		.mapValues{list=>list.map{x=>x._2}.sum}
                                                  //> res4: scala.collection.immutable.Map[String,Int] = Map(1804 -> 1, hadoop ->
                                                  //|  1, world -> 1, hello -> 3)
 		
 		
 	l1.flatMap { line => line.split(" ") }
 		.map{word=>(word,1)}
 		.groupBy{case(word,one)=>word}
 		.mapValues{list=>list.map{x=>x._2}.reduce(_+_)}
                                                  //> res5: scala.collection.immutable.Map[String,Int] = Map(1804 -> 1, hadoop ->
                                                  //|  1, world -> 1, hello -> 3)
 	
 	l1.flatMap {_.split(" ")}
 		.map{(_,1)}
 		.groupBy{_._1}
 		.mapValues{list=>list.map{x=>x._2}.reduce(_+_)}
                                                  //> res6: scala.collection.immutable.Map[String,Int] = Map(1804 -> 1, hadoop ->
                                                  //|  1, world -> 1, hello -> 3)
}