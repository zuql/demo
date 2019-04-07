/*
学习常用的字符串操作方法
知识点
1.scala可以无缝衔接java类库的方法
2.String操作，比如*(复制方法),java类库并没有，此时scala底层有一个 隐式转换机制
会转成scala自身的类。String->StringOpS
*/
object Demo02 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(187); 
  println("Welcome to the Scala worksheet");$skip(25); 
  
  val s1="helloworld";System.out.println("""s1  : String = """ + $show(s1 ));$skip(23); 
  val r1=s1.split(" ");System.out.println("""r1  : Array[String] = """ + $show(r1 ));$skip(7); val res$0 = 
  s1*2;System.out.println("""res0: String = """ + $show(res$0));$skip(31); val res$1 = 
  
  //--去掉头部2个元素
  s1.drop(2);System.out.println("""res1: String = """ + $show(res$1));$skip(33); val res$2 = 
  //--去掉尾部2个元素
  s1.dropRight(2);System.out.println("""res2: String = """ + $show(res$2));$skip(31); val res$3 = 
  
  //--取出头部2个元素
  s1.take(2);System.out.println("""res3: String = """ + $show(res$3));$skip(12); val res$4 = 
  s1 take 2;System.out.println("""res4: String = """ + $show(res$4));$skip(33); val res$5 = 
  //--取出尾部2个元素
  s1.takeRight(2);System.out.println("""res5: String = """ + $show(res$5));$skip(13); val res$6 = 
  
  s1.head;System.out.println("""res6: Char = """ + $show(res$6));$skip(10); val res$7 = 
  s1.last;System.out.println("""res7: Char = """ + $show(res$7));$skip(14); val res$8 = 
  
  s1.tail;System.out.println("""res8: String = """ + $show(res$8));$skip(22); val res$9 = 
  
  s1.contains('z');System.out.println("""res9: Boolean = """ + $show(res$9));$skip(55); val res$10 = 
  //--通过指定的匿名函数规则做计数
  s1.count { x => x.equals('o') };System.out.println("""res10: Int = """ + $show(res$10));$skip(13); val res$11 = 
 
  s1.size;System.out.println("""res11: Int = """ + $show(res$11));$skip(61); val res$12 = 
  
  //--通过匿名函数判断某个元素是否存在
  s1.exists { x => x.equals('z') };System.out.println("""res12: Boolean = """ + $show(res$12));$skip(61); val res$13 = 
  
  
  //--通过匿名函数做过滤操作
  s1.filter { x => !x.equals('o') };System.out.println("""res13: String = """ + $show(res$13));$skip(52); 
  
  //--遍历操作，一般用于打印
 	s1.foreach{ x => println(x)};$skip(39); val res$14 = 
  //-- hello world
  s1.indexOf('o',5);System.out.println("""res14: Int = """ + $show(res$14));$skip(12); val res$15 = 
  
  s1.max;System.out.println("""res15: Char = """ + $show(res$15));$skip(9); val res$16 = 
  s1.min;System.out.println("""res16: Char = """ + $show(res$16));$skip(22); val res$17 = 
  
  s1.mkString(",");System.out.println("""res17: String = """ + $show(res$17));$skip(25); val res$18 = 
  
  //--反转
  s1.reverse;System.out.println("""res18: String = """ + $show(res$18));$skip(72); val res$19 = 
  
  //--以上这些方法，既可以应用于String，也可以应用集合类型（Array,List等)
  
  
  s1.toArray;System.out.println("""res19: Array[Char] = """ + $show(res$19));$skip(18); 
  
  val s2="123";System.out.println("""s2  : String = """ + $show(s2 ));$skip(14); val res$20 = 
  
  s2.toInt;System.out.println("""res20: Int = """ + $show(res$20));$skip(14); val res$21 = 
  s2.toDouble;System.out.println("""res21: Double = """ + $show(res$21))}
}
