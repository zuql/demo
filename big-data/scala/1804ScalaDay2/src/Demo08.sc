import scala.util.Sorting.quickSort

object Demo08 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val p1=new Person("tom",23)                     //> p1  : Person = Person@52fb2197
 	
 	p1.getName()                              //> res0: String = tom
 	p1.getAge()                               //> res1: Int = 23
  p1.eat()                                        //> eat food

	val p2=new Person("rose")                 //> p2  : Person = Person@2985158
	
	p2.getName()                              //> res2: String = rose
	p2.getAge()                               //> res3: Int = 0
	
	val p3=new Person(35)                     //> p3  : Person = Person@5e0469bc
	
	val p4=new Person                         //> p4  : Person = Person@73b9e5dc
	
	Util.write()
	
	
	
	val i1=Item(1,"apple")                    //> i1  : Item = Item(1,apple)
	val i2=Item(2,"orange")                   //> i2  : Item = Item(2,orange)
	val i3=Item                               //> i3  : Item.type = Item
	
	
	def f1(a:Int,b:Int):Option[Int]={
    if(b!=0){
      Some(a/b)
    }else{
      None
    }
  }                                               //> f1: (a: Int, b: Int)Option[Int]
  
  f1(4,2).getOrElse(0)                            //> res4: Int = 2
  
  val l5=List(1,2,3,4)                            //> l5  : List[Int] = List(1, 2, 3, 4)
  l5.reduceLeft(_+_)                              //> res5: Int = 10
  l5.reduceLeft{(a,b)=>{a+b}}                     //> res6: Int = 10
  
	
  
}