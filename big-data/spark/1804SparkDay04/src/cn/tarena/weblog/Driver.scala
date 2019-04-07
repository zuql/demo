package cn.tarena.weblog

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.netlib.util.Second
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.hadoop.hive.ql.io.orc.OrcProto.Stream
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.fs.shell.find.Result
import org.apache.hadoop.hbase.client.Put

object Driver {
  //--注意，线程数的分配至少是3个，①Streaming ②Kafka ③Hbase
  val conf=new SparkConf().setMaster("local[5]").setAppName("weblog")
  val sc=new SparkContext(conf)
  
  def saveToHBase(map:Map[String,String],rowKey:String)={
     sc.hadoopConfiguration.set("hbase.zookeeper.quorum",
                                "hadoop01,hadoop02,hadoop03")
     sc.hadoopConfiguration.set("hbase.zookeeper.property.clientPort",
                                "2181")
     sc.hadoopConfiguration.set(TableOutputFormat.OUTPUT_TABLE,"weblog")
     
     val job=new Job(sc.hadoopConfiguration)
     
     job.setOutputKeyClass(classOf[ImmutableBytesWritable])
     //--shell.find.Result
     job.setOutputValueClass(classOf[Result])
     
     job.setOutputFormatClass(classOf[TableOutputFormat[ImmutableBytesWritable]])
    
     
     val r1=sc.makeRDD(List("hello")).map{line=>
     
       val put=new Put(rowKey.getBytes)
       put.add("cf1".getBytes,"url".getBytes, map("url").getBytes)
       put.add("cf1".getBytes,"urlname".getBytes, map("urlname").getBytes)
       put.add("cf1".getBytes,"uvid".getBytes, map("uvid").getBytes)
       put.add("cf1".getBytes,"ssid".getBytes, map("ssid").getBytes)
       put.add("cf1".getBytes,"sscount".getBytes, map("sscount").getBytes)
       put.add("cf1".getBytes,"sstime".getBytes, map("sstime").getBytes)
       put.add("cf1".getBytes,"cip".getBytes, map("cip").getBytes)
       (new ImmutableBytesWritable,put)
     }
     
     r1.saveAsNewAPIHadoopDataset(job.getConfiguration)
       
     
  }
  
  def main(args: Array[String]): Unit = {
    
    
    
    val ssc=new StreamingContext(sc,Seconds(5))
    
    
    
    val zkHosts="hadoop01:2181,hadoop02:2181,hadoop03:2181"
    val gp="gp2"
    val topics=Map("weblog"->1)
    val Stream=KafkaUtils.createStream(ssc,zkHosts,gp, topics)
                         .map(_._2)
                       
    
    //(url,urlname,uvid,ssid,sscount,sstime,cip)                    
    val d1=Stream.map { line =>
      val info=line.split("\\|")
      val url=info(0)
      val urlname=info(1)
      val uvid=info(13)
      val ssid=info(14).split("_")(0)
      val sscount=info(14).split("_")(1)
      val sstime=info(14).split("_")(2)
      val cip=info(15)
      
      val map=Map("url"->url,"urlname"->urlname,"uvid"->uvid,
                  "ssid"->ssid,"sscount"->sscount,"sstime"->sstime,"cip"->cip)
      
      val rowKey=sstime+"_"+uvid+"_"+ssid+"_"+(Math.random()*100).toInt        
      //--插入到HBase
      saveToHBase(map, rowKey)
    
    }
    d1.print()
    
    
    ssc.start()
    ssc.awaitTermination()
                         
    
  }
}