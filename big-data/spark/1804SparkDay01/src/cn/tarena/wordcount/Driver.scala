package cn.tarena.wordcount

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {
  
  def main(args: Array[String]): Unit = {
    //--创建Spark的环境参数对象，并指定 运行模式(集群模式)，以及job名称(自定义)
    val conf=new SparkConf().setMaster("spark://hadoop01:7077")
                            .setAppName("wordcount")
    
    //--获取Spark的上下文对象，通过此对象操作Spark                        
    val sc=new SparkContext(conf)
    
    val data=sc.textFile("hdfs://hadoop01:9000/word.txt",2)
    
    val result=data.flatMap {_.split(" ")}.map {(_,1)}
                   .reduceByKey(_+_)
    
    result.coalesce(1,true).saveAsTextFile("hdfs://hadoop01:9000/r5")               
  }
}