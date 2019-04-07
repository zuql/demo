package com.zuql.test

import org.apache.spark.{SparkConf, SparkContext}

object MaxMinTest {
  def main(args: Array[String]): Unit = {
    // val conf=new SparkConf().setMaster("spark://hadoop-p:7077").setAppName("hometest")"local"
    /*val master="local"
    val average="E:\\workspace\\学习资料\\it\\达内-大数据（1811）\\大数据\\大数据第五阶段\\spark\\Spark第一天\\课后作业\\MaxMin.txt"
    val average_result="E:\\workspace\\学习资料\\it\\达内-大数据（1811）\\大数据\\大数据第五阶段\\spark\\Spark第一天\\课后作业\\MaxMin_result.txt"*/
    val master="spark://hadoop-p:7077"
    val average="hdfs://hadoop-p:9000/test/MaxMin.txt"
    val average_result="hdfs://hadoop-p:9000/test/MaxMin_result.txt"
    val conf=new SparkConf().setMaster(master).setAppName("hometest")
    val sc=new SparkContext(conf)

    val data =sc.textFile(average,2)
    val r1=data.map(_.split(" ")).map(words=>(words(1),words(2))).filter(x=>"M".equals(x._1)).map(_._2.toInt).top(1)

    val result=sc.makeRDD(r1(0).toString,1);
    result.saveAsObjectFile(average_result)
    sc.stop()
  }
}
