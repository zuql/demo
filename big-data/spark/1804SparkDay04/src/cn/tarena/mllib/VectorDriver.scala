package cn.tarena.mllib

import org.apache.spark.mllib.linalg.Vectors

/**
 * 学习向量类型，Spark MLlib很多的算法模型需要用到此类型
 */
object VectorDriver {
  
  def main(args: Array[String]): Unit = {
    
    //--创建密集型向量,只处理Double,如果是Int,可以自动转Double
    val v1=Vectors.dense(1,2,3,4)
    val a1=Array[Double](1,2,3,4)
    //--通过传入Double类型数组来创建
    val v2=Vectors.dense(a1)
   
    
    //--创建稀疏向量
    //--稀疏的概念指的是：向量中有很多0
    //--第一个数组指定的向量的位置  第二个数组传入的位置对应的数据
    //--其他未指定的位置都是0
    val v3=Vectors.sparse(5,Array(1,3),Array(2.1,5.6))
    
    println(v3(3))
  }
}