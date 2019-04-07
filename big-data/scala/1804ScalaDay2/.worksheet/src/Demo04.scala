/*
学习Set 不包含重复元素的集合，
*/

object Demo04 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(35); 
  
  //--不可变
  val s1=Set(1,2,3,3);System.out.println("""s1  : scala.collection.immutable.Set[Int] = """ + $show(s1 ));$skip(59); 
  
  //--可变
  val s2=scala.collection.mutable.Set(1,2,3,3);System.out.println("""s2  : scala.collection.mutable.Set[Int] = """ + $show(s2 ));$skip(25); 
  
  val s3=Set(1,2,3,4);System.out.println("""s3  : scala.collection.immutable.Set[Int] = """ + $show(s3 ));$skip(22); 
  val s4=Set(3,4,5,6);System.out.println("""s4  : scala.collection.immutable.Set[Int] = """ + $show(s4 ));$skip(20); val res$0 = 
  
  //--交集
  s3&s4;System.out.println("""res0: scala.collection.immutable.Set[Int] = """ + $show(res$0));$skip(25); val res$1 = 
  
  
  //--取差集
  s3&~s4;System.out.println("""res1: scala.collection.immutable.Set[Int] = """ + $show(res$1));$skip(14); val res$2 = 
  s3.diff(s4);System.out.println("""res2: scala.collection.immutable.Set[Int] = """ + $show(res$2));$skip(12); val res$3 = 
  
  s4&~s3;System.out.println("""res3: scala.collection.immutable.Set[Int] = """ + $show(res$3));$skip(14); val res$4 = 
  s4.diff(s3);System.out.println("""res4: scala.collection.immutable.Set[Int] = """ + $show(res$4));$skip(21); val res$5 = 
  
  //--合并
  s3++s4;System.out.println("""res5: scala.collection.immutable.Set[Int] = """ + $show(res$5));$skip(30); val res$6 = 
  
  s3.count { x => x%2==0 };System.out.println("""res6: Int = """ + $show(res$6));$skip(31); 
  
  val s5=Set(1,2,3,4,5,6,7);System.out.println("""s5  : scala.collection.immutable.Set[Int] = """ + $show(s5 ));$skip(52); val res$7 = 
  
  //--返回的是两个子Set，可以通过tuple来取值
  s5.splitAt(4)._2;System.out.println("""res7: scala.collection.immutable.Set[Int] = """ + $show(res$7))}
}
