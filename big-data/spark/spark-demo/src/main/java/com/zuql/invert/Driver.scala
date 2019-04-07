package com.zuql.invert

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {
  
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local").setAppName("invert");
    val sc=new SparkContext(conf)
    
    val data=sc.wholeTextFiles("d://data/inverted/*")
    
    //--提示:
    //--拆行： text.split("\r\n")  
    //--行拆单词:split(" ")
    data.foreach{println}
  }
}