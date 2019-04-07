package com.zuql.test

import org.apache.spark.{SparkConf, SparkContext}

object AverageTest {
  def main(args: Array[String]): Unit = {
     // val conf=new SparkConf().setMaster("spark://hadoop-p:7077").setAppName("hometest")"local"
   /*  val master="local"
     val average="E:\\workspace\\学习资料\\it\\达内-大数据（1811）\\大数据\\大数据第五阶段\\spark\\Spark第一天\\课后作业\\average.txt"
     val average_result="E:\\workspace\\学习资料\\it\\达内-大数据（1811）\\大数据\\大数据第五阶段\\spark\\Spark第一天\\课后作业\\average_result.txt"*/
    val master="spark://hadoop-p:7077"
    val average="hdfs://hadoop-p:9000/test/average.txt"
    val average_result="hdfs://hadoop-p:9000/test/average_result.txt"
    val conf=new SparkConf().setMaster(master).setAppName("hometest")
    val sc=new SparkContext(conf)

    val data =sc.textFile(average,2)
    val r1=data.map(_.split(" ")(1).toInt).map((_,1)).reduce((a,b)=>((a._1+b._1),(a._2+b._2)))
    val r2=r1._1.toInt*10000/r1._2/10000.0
    val result=sc.makeRDD(r2.toString,1);
    result.saveAsObjectFile(average_result)
    sc.stop()
  }



}
