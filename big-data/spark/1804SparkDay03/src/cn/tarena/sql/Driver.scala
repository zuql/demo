package cn.tarena.sql

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object Driver {
  
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf().setMaster("local").setAppName("sql")
    val sc=new SparkContext(conf)
    val sqc=new SQLContext(sc)
    
    val r1=sc.makeRDD(List((1,"tom"),(2,"rose"),(3,"jary")))
    
    val t1=sqc.createDataFrame(r1).toDF("id","name")
    
    t1.registerTempTable("tab2")
    val result=sqc.sql("select * from tab2 where name='tom'")
    //--将DataFrame转成RDD，在存到文件里
    result.toJavaRDD.saveAsTextFile("d://sql01")
  }
}