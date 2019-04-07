package cn.tarena.kafka

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.kafka.KafkaUtils

object Driver01 {
  def main(args: Array[String]): Unit = {
    
    //--SparkSteaming从Kafka消费数据时，启动的线程数至少是2个
    //--指定方式:local[线程数] 其中一个线程用于启动和监听Streaming
    //--另外一个线程用于消费。
    //--如果，如果写成local,表示就一个线程，会导致Streaming可以启动，
    //--但是没有线程去消费数据了
    val conf=new SparkConf().setMaster("local[2]")
                            .setAppName("kafka")
    val sc=new SparkContext(conf)
    val ssc=new StreamingContext(sc,Seconds(5))
    
    val zkHosts="hadoop01:2181,hadoop02:2181,hadoop03:2181"
    val group="gp1"
    //--用Map结构来指定消费的主题名以及消费的线程数
    val topics=Map("enbook"->1,"cnbook"->1)
    
    //--通过Kafka获取数据源
    //--通过(null,数据)
    val stream=KafkaUtils.createStream(
                          ssc,zkHosts, group, topics)
                          .map(_._2)
                          
    stream.print()
    ssc.start()
    ssc.awaitTermination()
  }
}