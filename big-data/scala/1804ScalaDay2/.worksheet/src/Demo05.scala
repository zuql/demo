/*
学习Map
*/
object Demo05 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(71); 
  println("Welcome to the Scala worksheet");$skip(52); 
  
  //--声明定长map
  val m1=Map("tom"->23,"rose"->25);System.out.println("""m1  : scala.collection.immutable.Map[String,Int] = """ + $show(m1 ));$skip(64); 
  //--声明变长map
  val m2=scala.collection.mutable.Map("rose"->25);System.out.println("""m2  : scala.collection.mutable.Map[String,Int] = """ + $show(m2 ));$skip(21); val res$0 = 
 	
 	m2+=("jim"->30);System.out.println("""res0: Demo05.m2.type = """ + $show(res$0));$skip(33); 
 	
 	
 	m1.keys.foreach{println};$skip(29); 
 	m1.values.foreach{println};$skip(35); 
 	
 	for((k,v)<-m1){
 		println(k)
 	};$skip(40); val res$1 = 
 	//--通过key取value
 	m1.apply("tom");System.out.println("""res1: Int = """ + $show(res$1));$skip(77); val res$2 = 
 	
 	//--此方法用于操作Map类型的value，只有Map类型有
 	//--重点掌握
 	m1.mapValues { x => x+10 };System.out.println("""res2: scala.collection.immutable.Map[String,Int] = """ + $show(res$2));$skip(56); 
 	
 	val m3=Map("tom"->Array(1,23),"rose"->Array(2,35));System.out.println("""m3  : scala.collection.immutable.Map[String,Array[Int]] = """ + $show(m3 ));$skip(79); 
 	
 	//--基于m3，返回新Map("tom"->23,"rose"->35)
 	val m4=m3.mapValues { x => x(1) };System.out.println("""m4  : scala.collection.immutable.Map[String,Int] = """ + $show(m4 ));$skip(25); val res$3 = 
 	
 	m3.contains("jary");System.out.println("""res3: Boolean = """ + $show(res$3));$skip(21); val res$4 = 
  
  m1.apply("tom");System.out.println("""res4: Int = """ + $show(res$4));$skip(27); val res$5 = 
  //--等价于apply
  m1("tom");System.out.println("""res5: Int = """ + $show(res$5));$skip(39); val res$6 = 
  
  m1.get("jary").getOrElse("null");System.out.println("""res6: Any = """ + $show(res$6));$skip(59); 
  
  val m5=Map("tom"->20,"rose"->35,"jary"->30,"jim"->40);System.out.println("""m5  : scala.collection.immutable.Map[String,Int] = """ + $show(m5 ));$skip(34); val res$7 = 
  
  m5.filter{case(k,v)=>{v>30}};System.out.println("""res7: scala.collection.immutable.Map[String,Int] = """ + $show(res$7));$skip(26); val res$8 = 
  m5.filter{x=>{x._2>30}};System.out.println("""res8: scala.collection.immutable.Map[String,Int] = """ + $show(res$8));$skip(41); val res$9 = 
                            
  m5.toList;System.out.println("""res9: List[(String, Int)] = """ + $show(res$9))}
  
}
