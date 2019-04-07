/*
学习List
*/
import scala.collection.mutable.ListBuffer

object Demo03 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //--声明一个定长List，并赋初始值
  val l1=List(1,2,3,4)                            //> l1  : List[Int] = List(1, 2, 3, 4)
  
  val l2=1::2::3::4::Nil                          //> l2  : List[Int] = List(1, 2, 3, 4)
  
  //--声明一个空的定长List
  val l3=List[Nothing]()                          //> l3  : List[Nothing] = List()
  
  //--声明一个变长List
  val l4=ListBuffer(1,2,3,4)                      //> l4  : scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3, 4)
  
  l1.head                                         //> res0: Int = 1
  l1.last                                         //> res1: Int = 4
   
  l1.take(1)                                      //> res2: List[Int] = List(1)
  
  l1.drop(1)                                      //> res3: List[Int] = List(2, 3, 4)
  l1.tail                                         //> res4: List[Int] = List(2, 3, 4)
  
  l3.isEmpty                                      //> res5: Boolean = true
  l2.isEmpty                                      //> res6: Boolean = false
  
  val l5=List(1,2,3)                              //> l5  : List[Int] = List(1, 2, 3)
  val l6=List(4,5,6)                              //> l6  : List[Int] = List(4, 5, 6)
  
  val l7=List.concat(l5,l6)                       //> l7  : List[Int] = List(1, 2, 3, 4, 5, 6)
  //--等价于concat
  l5:::l6:::l7                                    //> res7: List[Int] = List(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6)
  
  List.fill(5)("a")                               //> res8: List[String] = List(a, a, a, a, a)
  List.tabulate(5)(_*2)                           //> res9: List[Int] = List(0, 2, 4, 6, 8)
  l7 reverse                                      //> res10: List[Int] = List(6, 5, 4, 3, 2, 1)
  
  val l8=List(1,2,3)                              //> l8  : List[Int] = List(1, 2, 3)
  
  //-- +:是左侧加原色   :+右侧加元素
  //-- 以上两个方法都是返回新的List
  val l9=0+:l8:+4                                 //> l9  : List[Int] = List(0, 1, 2, 3, 4)
  
  l9(2)                                           //> res11: Int = 2
  //--等价于通过下标取值
  l9.apply(2)                                     //> res12: Int = 2
  
  l9.contains(3)                                  //> res13: Boolean = true
  
  val a1=new Array[Int](5)                        //> a1  : Array[Int] = Array(0, 0, 0, 0, 0)
  l9.copyToArray(a1,0,l9.length)
  a1                                              //> res14: Array[Int] = Array(0, 1, 2, 3, 4)
  
  val a2=l9.toArray                               //> a2  : Array[Int] = Array(0, 1, 2, 3, 4)
  
  
  val l10=List(1,1,2,2,3,3)                       //> l10  : List[Int] = List(1, 1, 2, 2, 3, 3)
  
  //--去重
  val l11=l10.distinct                            //> l11  : List[Int] = List(1, 2, 3)
  
  l10.exists { x => x==4 }                        //> res15: Boolean = false
  
  val l12=List(1,2,3)                             //> l12  : List[Int] = List(1, 2, 3)
  val l13=List(3,4,5)                             //> l13  : List[Int] = List(3, 4, 5)
  //--取交集。可以应用于文件之间的取交集数据
  val l14=l12.intersect(l13)                      //> l14  : List[Int] = List(3)
  
  val l15=List(1,2,3,4,5)                         //> l15  : List[Int] = List(1, 2, 3, 4, 5)
  
  //--映射方法，重点掌握。可以改变集合中元素的形式
  //--map方法不会改变元素的个数
  l15.map { x => x*2 }                            //> res16: List[Int] = List(2, 4, 6, 8, 10)
  l15.map { x => Array(x) }                       //> res17: List[Array[Int]] = List(Array(1), Array(2), Array(3), Array(4), Arra
                                                  //| y(5))
  
  val l16=List(Array("tom",23),Array("rose",25))  //> l16  : List[Array[Any]] = List(Array(tom, 23), Array(rose, 25))
  
  l16.map { x => x(0) }                           //> res18: List[Any] = List(tom, rose)
  
  val l17=List(Array(1,1,2,2,3),Array(2,2,3,3))   //> l17  : List[Array[Int]] = List(Array(1, 1, 2, 2, 3), Array(2, 2, 3, 3))
  
  //--掌握以下类型转换的技巧
  l17.map { x => x.toList.distinct.toArray }      //> res19: List[Array[Int]] = List(Array(1, 2, 3), Array(2, 3))
  
  l15.max                                         //> res20: Int = 5
  l15.min                                         //> res21: Int = 1
  
  val s1="hello"                                  //> s1  : String = hello
  s1.mkString(",")                                //> res22: String = h,e,l,l,o
  //--将集合的元素转成String，并指定分隔符
  l15.mkString(",")                               //> res23: String = 1,2,3,4,5
  
  val l18=List(2,3,1,5,4)                         //> l18  : List[Int] = List(2, 3, 1, 5, 4)
  scala.util.Sorting.quickSort(l18.toArray)
  
  //--重点掌握，排序。如果要降序，则用前缀操作符  -
  val l19=l18.sortBy { x => -x }                  //> l19  : List[Int] = List(5, 4, 3, 2, 1)
  
  val l20=List(Array("tom",35),Array("rose",30),Array("jim",40))
                                                  //> l20  : List[Array[Any]] = List(Array(tom, 35), Array(rose, 30), Array(jim, 
                                                  //| 40))
  
  l20.map { x =>(x(0),x(1)) }.sortBy{x=>x._2.toString().toInt}
                                                  //> res24: List[(Any, Any)] = List((rose,30), (tom,35), (jim,40))
  
  l20.sortBy{x=>x(1).toString().toInt}            //> res25: List[Array[Any]] = List(Array(rose, 30), Array(tom, 35), Array(jim, 
                                                  //| 40))
  
  l18.reduceLeft(_+_)                             //> res26: Int = 15
 
}