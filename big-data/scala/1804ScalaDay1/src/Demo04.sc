/*
知识点
1.scala是行语句语言，不需要加;
如果要在一行代码里写多行，需要用分号隔开
2.scala的 if else 是有返回值，可以接到
3.通用:scala会把方法体{}中的最后一行代码当做返回值返回
4.通用:scala中，如果方法体中只有一行代码，则方法体{}可以省略
5.通用:scala中，在调用一个方法是，如果方法的参数只有一个，则 .()可以省略
6.scala的while使用同java
7.scala集合类型，通过下标取值是用(index)来取的，不同于java的[index]
比如 1 to 10
*/
object Demo04 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val v1=30                                       //> v1  : Int = 30
  
  val v2=if(v1<20){
  	println("small")
 		"small"
 		"001"
  }else{
  	println("big")
  	"big"
  }                                               //> big
                                                  //| v2  : String = big
  
  if(v1<20){
  	println("small")
  }else{
  	println("big")
  }                                               //> big
  
  if(v1<20)println("small")else println("big")    //> big
  
  v1.to(35)                                       //> res0: scala.collection.immutable.Range.Inclusive = Range(30, 31, 32, 33, 34,
                                                  //|  35)
  
  v1 to 35                                        //> res1: scala.collection.immutable.Range.Inclusive = Range(30, 31, 32, 33, 34,
                                                  //|  35)
  1 to 10                                         //> res2: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7
                                                  //| , 8, 9, 10)
  1 to 10 by 2                                    //> res3: scala.collection.immutable.Range = Range(1, 3, 5, 7, 9)
  
  val l1=List(1,2,3,4)                            //> l1  : List[Int] = List(1, 2, 3, 4)
  var index=0                                     //> index  : Int = 0
  while(index<l1.size){
  	println(l1(index))
  	index+=1
  }                                               //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  
}