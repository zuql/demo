package cn.tarena.hbase

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.client.Result
import org.apache.hadoop.hbase.util.Bytes

object ReadDriver {
  
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf().setMaster("local").setAppName("read")
    val sc=new SparkContext(conf)
    
    val hbaseConf=HBaseConfiguration.create()
    
    hbaseConf.set("hbase.zookeeper.quorum", "hadoop01,hadoop02,hadoop03")
    hbaseConf.set("hbase.zookeeper.property.clientPort","2181")
    hbaseConf.set(TableInputFormat.INPUT_TABLE,"tabx")
    
    //--获取了指定表的数据，并返回成一个RDD
    val resultRDD=sc.newAPIHadoopRDD(hbaseConf, 
        classOf[TableInputFormat],
        classOf[ImmutableBytesWritable], 
        //--hbase.client.Result
        classOf[Result])
    
    resultRDD.foreach{x=>
      val rowResult=x._2
      val rowKey=Bytes.toString(rowResult.getRow)
      val name=Bytes.toString(rowResult.getValue("cf1".getBytes,"name".getBytes))
      val age=Bytes.toString(rowResult.getValue("cf1".getBytes,"age".getBytes))
      println(rowKey+":"+name+":"+age)
    }
  }
}