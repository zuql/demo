package com.zuql.maxmin

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver1 {
  
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local").setAppName("Max")
    val sc=new SparkContext(conf)
    val data=sc.textFile("d://data/MaxMin.txt",2)
    
    val result=data.map { line => line.split(" ") }
        .filter { arr => arr(1).equals("M") }
        .sortBy{arr=> -arr(2).toInt}
        .take(1)//.map { arr => (arr(0),arr(1),arr(2)) }
        .map { arr => arr.mkString(" ") }
        
    result.foreach{println}
  }
}