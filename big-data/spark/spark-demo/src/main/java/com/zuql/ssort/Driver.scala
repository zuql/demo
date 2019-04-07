package com.zuql.ssort

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {
  
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local").setAppName("ssort")
    val sc=new SparkContext(conf)
    val data=sc.textFile("d://data/ssort.txt",2)
    
    //--data->aa 12->SecondSort(aa,12)->(SecondSort(aa,12),aa 12)
    //--sortByKey()
    
    val result=data.map { line =>
     val info=line.split(" ") 
     val s=new SecondSort(info(0),info(1).toInt)
     (s,line)
    }.sortByKey(true).map{x=>x._2}
    
    result.foreach{println}
  }
}