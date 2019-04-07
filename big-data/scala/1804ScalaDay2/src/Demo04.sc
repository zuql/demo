/*
学习Set 不包含重复元素的集合，
*/

object Demo04 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //--不可变
  val s1=Set(1,2,3,3)                             //> s1  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  
  //--可变
  val s2=scala.collection.mutable.Set(1,2,3,3)    //> s2  : scala.collection.mutable.Set[Int] = Set(1, 2, 3)
  
  val s3=Set(1,2,3,4)                             //> s3  : scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  val s4=Set(3,4,5,6)                             //> s4  : scala.collection.immutable.Set[Int] = Set(3, 4, 5, 6)
  
  //--交集
  s3&s4                                           //> res0: scala.collection.immutable.Set[Int] = Set(3, 4)
  
  
  //--取差集
  s3&~s4                                          //> res1: scala.collection.immutable.Set[Int] = Set(1, 2)
  s3.diff(s4)                                     //> res2: scala.collection.immutable.Set[Int] = Set(1, 2)
  
  s4&~s3                                          //> res3: scala.collection.immutable.Set[Int] = Set(5, 6)
  s4.diff(s3)                                     //> res4: scala.collection.immutable.Set[Int] = Set(5, 6)
  
  //--合并
  s3++s4                                          //> res5: scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)
  
  s3.count { x => x%2==0 }                        //> res6: Int = 2
  
  val s5=Set(1,2,3,4,5,6,7)                       //> s5  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 7, 3, 4)
  
  //--返回的是两个子Set，可以通过tuple来取值
  s5.splitAt(4)._2                                //> res7: scala.collection.immutable.Set[Int] = Set(7, 3, 4)
}