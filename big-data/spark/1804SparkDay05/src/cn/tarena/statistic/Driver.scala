package cn.tarena.statistic

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics

object Driver {
  
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf().setMaster("local").setAppName("statistic")
    val sc=new SparkContext(conf)
    
    val r1=sc.makeRDD(List(1,2,3,4,5))
    
    val r2=r1.map { x => Vectors.dense(x) }
    
    val result=Statistics.colStats(r2)
    
    println(result.max)
    println(result.min)
    println(result.count)
    println(result.variance)//数据集的方差
    println(result.normL1)//曼哈顿距离
    println(result.normL2)//欧式距离
    println(result.numNonzeros)//不为0的个数
    println(result.mean)//统计均值
  }
}