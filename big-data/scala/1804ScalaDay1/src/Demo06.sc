import util.control.Breaks._


object Demo06 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val s1="worldfwef"                              //> s1  : String = worldfwef
  
  //--等价于java的 switch 。此外scala的match有返回值，可以接
  val r1=s1 match{
  	case "hello"=>{
  		//--方法体代码
  		println("yes")
  		"yes"
  	}
  	case "world"=>{
  		println("no")
  		"no"
  	}
  	
  	case _=>{
  		println("other")
  		"other"
  	}
  }                                               //> other
                                                  //| r1  : String = other
  
  for(i<-1 to 10){
  
  	if(i==8){
  		break
  	}
  	println(i)
  }                                               //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| scala.util.control.BreakControl
  //--实现Continue
  for(i<-1 to 10){
  	  
  	breakable(
  	if(i==8){
  		break
  	}else{
  		println(i)
  	}
  	)
   }
   
   //--scala的异常处理机制同java，不同的是catch中需要通过case来匹配
  try{
     throw new NullPointerException
   }catch{
   	 case t:NullPointerException=>{
   	 	//--处理异常代码
   	 	println("null")
   	 }
   	 case t:Exception=>{
   	 	println("other")
   	 }
   }finally{
   	  println("final")
   }
  
}