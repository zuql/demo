package cn.tarena.stream

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds

object Driver {
  
  def main(args: Array[String]): Unit = {
    
     val conf=new SparkConf().setMaster("local").setAppName("stream")
     val sc=new SparkContext(conf)
     val ssc=new StreamingContext(sc,Seconds(5))
     //--设置Streaming的检查点目录，用于历史数据的累加
     ssc.checkpoint("d://chk")
     val stream=ssc.textFileStream("hdfs://hadoop01:9000/stream")
     
     val r1=stream.flatMap {_.split(" ")}.map {(_,1)}
     
     //--seq存储的是某个key的所有历史数据的数值，op是某个key当前传进来的值
     val r2=r1.updateStateByKey{(seq,op:Option[Int])=>Some( seq.sum+op.getOrElse(0))}
     
     r2.print()
     ssc.start()
     //--保持一直开启sparkStreaming
     ssc.awaitTermination()
  }
}