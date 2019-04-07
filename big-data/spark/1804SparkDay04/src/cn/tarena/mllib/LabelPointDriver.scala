package cn.tarena.mllib

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object LabelPointDriver {
  
  def main(args: Array[String]): Unit = {
    
    val v1=Vectors.dense(1.1,2.5,3.4)
    val l1=LabeledPoint(1,v1)
    println(l1)
    println(l1.label)//只获取类标号
    println(l1.features)//只获取特征值(向量值)
    
    val conf=new SparkConf().setMaster("local").setAppName("lb")
    val sc=new SparkContext(conf)
    val data=sc.textFile("d://ml/labeled.txt")
    
    val result=data.map { line => line.split(" ").map { num => num.toDouble } }
                   .map { arr =>
                     //--取标签值
                     val label=arr(2)
                     //--获取所有的特征列
                     val features=arr.dropRight(1)
                     LabeledPoint(label,Vectors.dense(features))
                   }
                   
   result.foreach{x=>println(x)}                
                   
    
    
    
    
    
    
    
    
  }
}