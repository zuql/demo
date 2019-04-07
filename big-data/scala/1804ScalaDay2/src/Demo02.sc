import scala.collection.mutable.ArrayBuffer
/*
学习Array
*/
object Demo02 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //--声明一个定长数组，一经声明，数组元素个数不能改变
  val a1=Array(1,2,3,4)                           //> a1  : Array[Int] = Array(1, 2, 3, 4)
  val a2=new Array[Int](3)                        //> a2  : Array[Int] = Array(0, 0, 0)
  
  //--声明一个变长数组，并赋初始值
  //--mutable 可变
  //--immutable 不可变
  val a3=ArrayBuffer(1,2,3,4)                     //> a3  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, 4)
  val a4=new ArrayBuffer[Int](3)                  //> a4  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  
  //--定长数组赋值,通过下标赋值
  for(i<-0 until a2.length){
  	a2(i)=4
  }
  a2                                              //> res0: Array[Int] = Array(4, 4, 4)
  //--通过下标取值
  a2(0)                                           //> res1: Int = 4
  
  //--变长数组一般是通过append来赋值。用下标赋值也可以
  for(i<-1 to 10){
  	a4.append(i)
  }
  a4                                              //> res2: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, 4, 5,
                                                  //|  6, 7, 8, 9, 10)
  
  val a5=Array(1,2,3)                             //> a5  : Array[Int] = Array(1, 2, 3)
  val a6=Array(4,5,6)                             //> a6  : Array[Int] = Array(4, 5, 6)
  
  //--拼接定长数组
  val a7=Array.concat(a5,a6)                      //> a7  : Array[Int] = Array(1, 2, 3, 4, 5, 6)
  //--拼接变长数组
  val a8=ArrayBuffer.concat(a3,a4)                //> a8  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, 4, 1,
                                                  //|  2, 3, 4, 5, 6, 7, 8, 9, 10)
 	//--生成区间数组，并指定步长。一般用于准备实验数据
  val a9=Array.range(0, 5,2)                      //> a9  : Array[Int] = Array(0, 2, 4)
  
  //--创建一个 将匿名函数应用于初始值的数组。
  //--iterate(start,length)(f:)
  Array.iterate(0, 5)(x=>x*2)                     //> res3: Array[Int] = Array(0, 0, 0, 0, 0)
  
  //--创建一个 将匿名函数应用于下标的数组
  Array.tabulate(5)(x=>x*2)                       //> res4: Array[Int] = Array(0, 2, 4, 6, 8)
  
  a5.sum                                          //> res5: Int = 6
  a5.min                                          //> res6: Int = 1
  a5.max                                          //> res7: Int = 3
  
  val a10=Array(2,1,5,4,3)                        //> a10  : Array[Int] = Array(2, 1, 5, 4, 3)
  scala.util.Sorting.quickSort(a10)
  
  a10                                             //> res8: Array[Int] = Array(1, 2, 3, 4, 5)
  a10 reverse                                     //> res9: Array[Int] = Array(5, 4, 3, 2, 1)
  
  a10.foreach{println}                            //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
  
  a10.filter{_%2==0}                              //> res10: Array[Int] = Array(2, 4)
  
  a10.drop(1)                                     //> res11: Array[Int] = Array(2, 3, 4, 5)
  a10.dropRight(1)                                //> res12: Array[Int] = Array(1, 2, 3, 4)
  
  a10.take(2)                                     //> res13: Array[Int] = Array(1, 2)
  a10.take(1)                                     //> res14: Array[Int] = Array(1)
  a10.head                                        //> res15: Int = 1
}