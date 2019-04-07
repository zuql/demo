package com.zuql.ssort

class SecondSort(val v1:String,val v2:Int) extends Ordered[SecondSort]
                                           with Serializable{
  
    def compare(other:SecondSort):Int={
      
      //--先按第一列作升序
      val result=this.v1.compareTo(other.v1)
      if(result==0){
        //--再按第二列作降序
        other.v2.compareTo(this.v2)
      }else{
        result
      }
    }
  
 
}