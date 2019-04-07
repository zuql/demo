package cn.tarena.invert

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import breeze.linalg.split

object Driver {
  def main(args: Array[String]): Unit = {
    
    val conf =new SparkConf().setMaster("local").setAppName("invert")
    val sc=new SparkContext(conf)
    
    val data=sc.wholeTextFiles("d://data/inverted/*",2)
    
    val r1=data.map{case(filePath,fileText)=>
      val fileName=filePath.split("/").last.dropRight(4)
      (fileName,fileText)
    }
    
    val r2=r1.flatMap{case(fileName,fileText)=>
      fileText.split("\r\n").flatMap { line => line.split(" ")}.map{word=>(word,fileName)}
     }
    
    val r3=r2.groupByKey
             .map { case(word,buffer) => 
             (word,buffer.toList.distinct.mkString(",")) }
    
    r3.coalesce(1,true).saveAsTextFile("d://invert")
  }
}