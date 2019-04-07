/*
学习常用的字符串操作方法
知识点
1.scala可以无缝衔接java类库的方法
2.String操作，比如*(复制方法),java类库并没有，此时scala底层有一个 隐式转换机制
会转成scala自身的类。String->StringOpS
*/
object Demo02 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val s1="helloworld"                             //> s1  : String = helloworld
  val r1=s1.split(" ")                            //> r1  : Array[String] = Array(helloworld)
  s1*2                                            //> res0: String = helloworldhelloworld
  
  //--去掉头部2个元素
  s1.drop(2)                                      //> res1: String = lloworld
  //--去掉尾部2个元素
  s1.dropRight(2)                                 //> res2: String = hellowor
  
  //--取出头部2个元素
  s1.take(2)                                      //> res3: String = he
  s1 take 2                                       //> res4: String = he
  //--取出尾部2个元素
  s1.takeRight(2)                                 //> res5: String = ld
  
  s1.head                                         //> res6: Char = h
  s1.last                                         //> res7: Char = d
  
  s1.tail                                         //> res8: String = elloworld
  
  s1.contains('z')                                //> res9: Boolean = false
  //--通过指定的匿名函数规则做计数
  s1.count { x => x.equals('o') }                 //> res10: Int = 2
 
  s1.size                                         //> res11: Int = 10
  
  //--通过匿名函数判断某个元素是否存在
  s1.exists { x => x.equals('z') }                //> res12: Boolean = false
  
  
  //--通过匿名函数做过滤操作
  s1.filter { x => !x.equals('o') }               //> res13: String = hellwrld
  
  //--遍历操作，一般用于打印
 	s1.foreach{ x => println(x)}              //> h
                                                  //| e
                                                  //| l
                                                  //| l
                                                  //| o
                                                  //| w
                                                  //| o
                                                  //| r
                                                  //| l
                                                  //| d
  //-- hello world
  s1.indexOf('o',5)                               //> res14: Int = 6
  
  s1.max                                          //> res15: Char = w
  s1.min                                          //> res16: Char = d
  
  s1.mkString(",")                                //> res17: String = h,e,l,l,o,w,o,r,l,d
  
  //--反转
  s1.reverse                                      //> res18: String = dlrowolleh
  
  //--以上这些方法，既可以应用于String，也可以应用集合类型（Array,List等)
  
  
  s1.toArray                                      //> res19: Array[Char] = Array(h, e, l, l, o, w, o, r, l, d)
  
  val s2="123"                                    //> s2  : String = 123
  
  s2.toInt                                        //> res20: Int = 123
  s2.toDouble                                     //> res21: Double = 123.0
}