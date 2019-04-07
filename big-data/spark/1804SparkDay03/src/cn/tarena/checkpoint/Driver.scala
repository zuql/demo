package cn.tarena.checkpoint

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Driver {
  
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf().setMaster("local").setAppName("chk")
    val sc=new SparkContext(conf)
    
    //--指定检查点储存目录
    sc.setCheckpointDir("d://chk")
    
    //--可以在整个DAG中，选择一些比较重要的RDD，做cache和checkPoint
    //--底层的处理方式：优先去cache中恢复，如果cache丢失，则去check目录恢复
    val r1=sc.makeRDD(List(1,2,3,4,5))
    r1.cache()
    r1.checkpoint()
    
    val r2=sc.makeRDD(List(("tom",23),("rose",25),("jim",30))).collectAsMap
    
  }
}