import scala.util.Sorting.quickSort

object Demo08 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(96); 
  println("Welcome to the Scala worksheet");$skip(33); 
  
  val p1=new Person("tom",23);System.out.println("""p1  : Person = """ + $show(p1 ));$skip(18); val res$0 = 
 	
 	p1.getName();System.out.println("""res0: String = """ + $show(res$0));$skip(14); val res$1 = 
 	p1.getAge();System.out.println("""res1: Int = """ + $show(res$1));$skip(11); 
  p1.eat();$skip(28); 

	val p2=new Person("rose");System.out.println("""p2  : Person = """ + $show(p2 ));$skip(16); val res$2 = 
	
	p2.getName();System.out.println("""res2: String = """ + $show(res$2));$skip(13); val res$3 = 
	p2.getAge();System.out.println("""res3: Int = """ + $show(res$3));$skip(25); 
	
	val p3=new Person(35);System.out.println("""p3  : Person = """ + $show(p3 ));$skip(21); 
	
	val p4=new Person;System.out.println("""p4  : Person = """ + $show(p4 ));$skip(16); 
	
	Util.write();$skip(30); 
	
	
	
	val i1=Item(1,"apple");System.out.println("""i1  : Item = """ + $show(i1 ));$skip(25); 
	val i2=Item(2,"orange");System.out.println("""i2  : Item = """ + $show(i2 ));$skip(13); 
	val i3=Item;System.out.println("""i3  : Item.type = """ + $show(i3 ));$skip(101); 
	
	
	def f1(a:Int,b:Int):Option[Int]={
    if(b!=0){
      Some(a/b)
    }else{
      None
    }
  };System.out.println("""f1: (a: Int, b: Int)Option[Int]""");$skip(26); val res$4 = 
  
  f1(4,2).getOrElse(0);System.out.println("""res4: Int = """ + $show(res$4));$skip(26); 
  
  val l5=List(1,2,3,4);System.out.println("""l5  : List[Int] = """ + $show(l5 ));$skip(21); val res$5 = 
  l5.reduceLeft(_+_);System.out.println("""res5: Int = """ + $show(res$5));$skip(30); val res$6 = 
  l5.reduceLeft{(a,b)=>{a+b}};System.out.println("""res6: Int = """ + $show(res$6))}
  
	
  
}
