package cn.tarena.kryo

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.storage.StorageLevel

object Driver {
  
  def main(args: Array[String]): Unit = {
    
     val conf = new SparkConf().setMaster("local")
               .setAppName("kryoTest")
               .set("spark.serializer", 
                   "org.apache.spark.serializer.KryoSerializer")
               .set("spark.kryo.registrator", 
                   "cn.tarena.kryo.MyKryoRegister")
     
     val sc=new SparkContext(conf)
     val r1=sc.makeRDD(List(new Person("tom",21)
                            ,new Person("rose",23)))
                            
     r1.persist(StorageLevel.MEMORY_ONLY_SER)                       

  }
}