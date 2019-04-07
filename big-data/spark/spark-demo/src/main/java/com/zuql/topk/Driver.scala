package com.zuql.topk

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {
  
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf().setMaster("local").setAppName("topk")
    val sc=new SparkContext(conf)
    val data=sc.textFile("d://data/topk.txt",2)
    
//    val result=data.flatMap { line => line.split(" ") }
//        .map { word => (word,1) }
//        .reduceByKey(_+_)
//        .sortBy{case(word,count)=> -count}
//        .take(3)
//    
//    result.foreach{println}
     
       val result=data.flatMap { line => line.split(" ") }
        .map { word => (word,1) }
        .reduceByKey(_+_)
        
       val top3=result.top(3)(Ordering.by{case(word,count)=>count})
       top3.foreach{println}
     
  }
}