package com.zuql.maxmin

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {
  
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local").setAppName("MaxMin")
    
    val sc=new SparkContext(conf)
    
    val data=sc.textFile("d://data/MaxMin.txt",2)
    
    val result=data.map { line => line.split(" ")}
                   .filter { arr => arr(1).equals("M") }
                   .map { arr => arr(2).toInt }.max
    println(result)               
                   
            
  }
}