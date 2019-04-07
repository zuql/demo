/*
学习变量和常量的声明
知识点
1.scala可以自动推断出变量或常量的类型
2.变量(var) 可以更改。而常量(val)一经声明，不能修改。一般在程序中用的常量val
*/
object Demo01 {
  ;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(150);
  println("Welcome to the Scala worksheet");$skip(34); 
  
  //--变量声明用var 关键字
  var v1=10;System.out.println("""v1  : Int = """ + $show(v1 ));$skip(34); 


  //--常量声明用val 关键字
  val v2=20;System.out.println("""v2  : Int = """ + $show(v2 ));$skip(24); 
  
  var v3="hello1804";System.out.println("""v3  : String = """ + $show(v3 ));$skip(27); 
  
  var v4=Array(1,2,3,4);System.out.println("""v4  : Array[Int] = """ + $show(v4 ));$skip(33); 
  
  //--显示的指定类型
  var v5:Int=15;System.out.println("""v5  : Int = """ + $show(v5 ));$skip(27); 
  
  val v6:String="hello";System.out.println("""v6  : String = """ + $show(v6 ));$skip(34); 
  val v7:java.lang.String="hello";System.out.println("""v7  : String = """ + $show(v7 ))}
  
 
  
}
