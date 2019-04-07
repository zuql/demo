/*
学习元组 tuple
*/
object Demo06 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(34); 
  
  val t1=("tom","rose","jary");System.out.println("""t1  : (String, String, String) = """ + $show(t1 ));$skip(45); 
  
  val t2=("tom",Array(1,2,3),List(3,4,5));System.out.println("""t2  : (String, Array[Int], List[Int]) = """ + $show(t2 ));$skip(49); 
  
  val t3=(("tom",23),("rose",25),("jary",30));System.out.println("""t3  : ((String, Int), (String, Int), (String, Int)) = """ + $show(t3 ));$skip(17); val res$0 = 
  //--取值
  t1._1;System.out.println("""res0: String = """ + $show(res$0));$skip(8); val res$1 = 
  t1._2;System.out.println("""res1: String = """ + $show(res$1));$skip(14); val res$2 = 
  
  t3._2._2;System.out.println("""res2: Int = """ + $show(res$2));$skip(51); 
  
  val l1=List("hello","world","hadoop","hello");System.out.println("""l1  : List[String] = """ + $show(l1 ));$skip(93); 
  
  //--基于l1 变成：List(("hello",1),("world",1),("hadoop",1))
  
  val l2=l1.map { x =>(x,1) };System.out.println("""l2  : List[(String, Int)] = """ + $show(l2 ));$skip(67); 
  
  //--基于l2 变成：List("hello","world")
  
  val l3=l2.map{x=>x._1};System.out.println("""l3  : List[String] = """ + $show(l3 ));$skip(43); 
  
  val l4=l2.map{case(word,count)=>word};System.out.println("""l4  : List[String] = """ + $show(l4 ))}
}
