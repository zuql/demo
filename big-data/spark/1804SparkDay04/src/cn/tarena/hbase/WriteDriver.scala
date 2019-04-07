package cn.tarena.hbase

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.fs.shell.find.Result
import org.apache.hadoop.hbase.client.Put

object WriteDriver {
  
  def main(args: Array[String]): Unit = {
     
     val conf=new SparkConf().setMaster("local").setAppName("write")
     
     val sc=new SparkContext(conf)
     
     sc.hadoopConfiguration.set("hbase.zookeeper.quorum",
                                "hadoop01,hadoop02,hadoop03")
     sc.hadoopConfiguration.set("hbase.zookeeper.property.clientPort",
                                "2181")
     sc.hadoopConfiguration.set(TableOutputFormat.OUTPUT_TABLE,"tabx")                           
     
     //--获取操作Hbase的job对象
     val job=new Job(sc.hadoopConfiguration)
     
     job.setOutputKeyClass(classOf[ImmutableBytesWritable])
     //--shell.find.Result
     job.setOutputValueClass(classOf[Result])
     
     job.setOutputFormatClass(classOf[TableOutputFormat[ImmutableBytesWritable]])
     
     val r1=sc.makeRDD(List("rk1 tom 23","rk2 rose 35"))
     
     val r2=r1.map { line =>
       val info=line.split(" ")
       val rowKey=info(0)
       val name=info(1)
       val age=info(2)
       
       //--生成一个行对象，并指定行键
       val put=new Put(rowKey.getBytes)
       put.add("cf1".getBytes,"name".getBytes,name.getBytes)
       put.add("cf1".getBytes,"age".getBytes,age.getBytes)
       //--向HBase表插入数据时,需要转成此固定格式
       (new ImmutableBytesWritable,put)
     }
     
     //--执行插入
     r2.saveAsNewAPIHadoopDataset(job.getConfiguration)
     
  }
}