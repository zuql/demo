/*
学习Map
*/
object Demo05 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //--声明定长map
  val m1=Map("tom"->23,"rose"->25)                //> m1  : scala.collection.immutable.Map[String,Int] = Map(tom -> 23, rose -> 25
                                                  //| )
  //--声明变长map
  val m2=scala.collection.mutable.Map("rose"->25) //> m2  : scala.collection.mutable.Map[String,Int] = Map(rose -> 25)
 	
 	m2+=("jim"->30)                           //> res0: Demo05.m2.type = Map(jim -> 30, rose -> 25)
 	
 	
 	m1.keys.foreach{println}                  //> tom
                                                  //| rose
 	m1.values.foreach{println}                //> 23
                                                  //| 25
 	
 	for((k,v)<-m1){
 		println(k)                        //> tom
                                                  //| rose
 	}
 	//--通过key取value
 	m1.apply("tom")                           //> res1: Int = 23
 	
 	//--此方法用于操作Map类型的value，只有Map类型有
 	//--重点掌握
 	m1.mapValues { x => x+10 }                //> res2: scala.collection.immutable.Map[String,Int] = Map(tom -> 33, rose -> 35
                                                  //| )
 	
 	val m3=Map("tom"->Array(1,23),"rose"->Array(2,35))
                                                  //> m3  : scala.collection.immutable.Map[String,Array[Int]] = Map(tom -> Array(1
                                                  //| , 23), rose -> Array(2, 35))
 	
 	//--基于m3，返回新Map("tom"->23,"rose"->35)
 	val m4=m3.mapValues { x => x(1) }         //> m4  : scala.collection.immutable.Map[String,Int] = Map(tom -> 23, rose -> 35
                                                  //| )
 	
 	m3.contains("jary")                       //> res3: Boolean = false
  
  m1.apply("tom")                                 //> res4: Int = 23
  //--等价于apply
  m1("tom")                                       //> res5: Int = 23
  
  m1.get("jary").getOrElse("null")                //> res6: Any = null
  
  val m5=Map("tom"->20,"rose"->35,"jary"->30,"jim"->40)
                                                  //> m5  : scala.collection.immutable.Map[String,Int] = Map(tom -> 20, rose -> 35
                                                  //| , jary -> 30, jim -> 40)
  
  m5.filter{case(k,v)=>{v>30}}                    //> res7: scala.collection.immutable.Map[String,Int] = Map(rose -> 35, jim -> 40
                                                  //| )
  m5.filter{x=>{x._2>30}}                         //> res8: scala.collection.immutable.Map[String,Int] = Map(rose -> 35, jim -> 40
                                                  //| )
                            
  m5.toList                                       //> res9: List[(String, Int)] = List((tom,20), (rose,35), (jary,30), (jim,40))
  
}