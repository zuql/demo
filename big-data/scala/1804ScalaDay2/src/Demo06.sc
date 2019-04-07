/*
学习元组 tuple
*/
object Demo06 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val t1=("tom","rose","jary")                    //> t1  : (String, String, String) = (tom,rose,jary)
  
  val t2=("tom",Array(1,2,3),List(3,4,5))         //> t2  : (String, Array[Int], List[Int]) = (tom,Array(1, 2, 3),List(3, 4, 5))
  
  val t3=(("tom",23),("rose",25),("jary",30))     //> t3  : ((String, Int), (String, Int), (String, Int)) = ((tom,23),(rose,25),(j
                                                  //| ary,30))
  //--取值
  t1._1                                           //> res0: String = tom
  t1._2                                           //> res1: String = rose
  
  t3._2._2                                        //> res2: Int = 25
  
  val l1=List("hello","world","hadoop","hello")   //> l1  : List[String] = List(hello, world, hadoop, hello)
  
  //--基于l1 变成：List(("hello",1),("world",1),("hadoop",1))
  
  val l2=l1.map { x =>(x,1) }                     //> l2  : List[(String, Int)] = List((hello,1), (world,1), (hadoop,1), (hello,1)
                                                  //| )
  
  //--基于l2 变成：List("hello","world")
  
  val l3=l2.map{x=>x._1}                          //> l3  : List[String] = List(hello, world, hadoop, hello)
  
  val l4=l2.map{case(word,count)=>word}           //> l4  : List[String] = List(hello, world, hadoop, hello)
}