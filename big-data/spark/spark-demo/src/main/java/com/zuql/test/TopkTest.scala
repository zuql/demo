package com.zuql.test

import org.apache.spark.{SparkConf, SparkContext}

object TopkTest {
  def main(args: Array[String]): Unit = {
    /*  val master="local"
      val average="E:\\workspace\\学习资料\\it\\达内-大数据（1811）\\大数据\\大数据第五阶段\\spark\\Spark第一天\\课后作业\\topk.txt"
      val average_result="E:\\workspace\\学习资料\\it\\达内-大数据（1811）\\大数据\\大数据第五阶段\\spark\\Spark第一天\\课后作业\\topk_result.txt"*/
    val master="spark://hadoop-p:7077"
    val average="hdfs://hadoop-p:9000/test/topk.txt"
    val average_result="hdfs://hadoop-p:9000/test/topk_result.txt"
    val conf=new SparkConf().setMaster(master).setAppName("hometest")
    val sc=new SparkContext(conf)

    val data =sc.textFile(average,2)
    val r1=data.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).map(x=>(x._2,x._1)).sortByKey(false).map(x=>(x._2,x._1)).take(3);

    val result=sc.makeRDD(r1,1);
    result.saveAsObjectFile(average_result)
    sc.stop()
  }
}
