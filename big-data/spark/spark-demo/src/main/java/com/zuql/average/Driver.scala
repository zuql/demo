package com.zuql.average

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {
  
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf().setMaster("local")
                            .setAppName("average")
    
    val sc=new SparkContext(conf)
    
    val data=sc.textFile("d://data/average.txt", 2)
    
    val result=data.map { line => line.split(" ") }
                   .map { arr => arr(1).toInt }
                   
    val sum=result.sum
    val count=result.count
    
    val average=sum/count
    
    println(average)
    
//    val r1=sc.makeRDD(List(average))
//    r1.saveAsTextFile(path)
  }
}