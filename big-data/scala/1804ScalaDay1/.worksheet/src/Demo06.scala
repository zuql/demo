import util.control.Breaks._


object Demo06 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(90); 
  println("Welcome to the Scala worksheet");$skip(24); 
  
  val s1="worldfwef";System.out.println("""s1  : String = """ + $show(s1 ));$skip(244); 
  
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
  };System.out.println("""r1  : String = """ + $show(r1 ));$skip(71); 
  
  for(i<-1 to 10){
  
  	if(i==8){
  		break
  	}
  	println(i)
  };$skip(114); 
  //--实现Continue
  for(i<-1 to 10){
  	  
  	breakable(
  	if(i==8){
  		break
  	}else{
  		println(i)
  	}
  	)
   };$skip(288); 
   
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
   }}
  
}
