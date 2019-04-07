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
object Demo04 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(329); 
  println("Welcome to the Scala worksheet");$skip(15); 
  
  val v1=30;System.out.println("""v1  : Int = """ + $show(v1 ));$skip(104); 
  
  val v2=if(v1<20){
  	println("small")
 		"small"
 		"001"
  }else{
  	println("big")
  	"big"
  };System.out.println("""v2  : String = """ + $show(v2 ));$skip(67); 
  
  if(v1<20){
  	println("small")
  }else{
  	println("big")
  };$skip(50); 
  
  if(v1<20)println("small")else println("big");$skip(15); val res$0 = 
  
  v1.to(35);System.out.println("""res0: scala.collection.immutable.Range.Inclusive = """ + $show(res$0));$skip(14); val res$1 = 
  
  v1 to 35;System.out.println("""res1: scala.collection.immutable.Range.Inclusive = """ + $show(res$1));$skip(10); val res$2 = 
  1 to 10;System.out.println("""res2: scala.collection.immutable.Range.Inclusive = """ + $show(res$2));$skip(15); val res$3 = 
  1 to 10 by 2;System.out.println("""res3: scala.collection.immutable.Range = """ + $show(res$3));$skip(26); 
  
  val l1=List(1,2,3,4);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(14); 
  var index=0;System.out.println("""index  : Int = """ + $show(index ));$skip(62); 
  while(index<l1.size){
  	println(l1(index))
  	index+=1
  }}
  
}
