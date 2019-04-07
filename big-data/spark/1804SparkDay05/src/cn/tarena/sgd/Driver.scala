package cn.tarena.sgd

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LinearRegressionWithSGD

object Driver {
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf().setMaster("local").setAppName("sgd")
    val sc=new SparkContext(conf)
    
    val data=sc.textFile("d://ml/testSGD.txt")
    //--为了满足后续建模的需要，要将RDD中每行数据转成LabeledPointed格式
    
    val parseData=data.map { line =>
      val Y=line.split(",")(0).toDouble
      val X1=line.split(",")(1).split(" ")(0).toDouble
      val X2=line.split(",")(1).split(" ")(1).toDouble
      
      LabeledPoint(Y,Vectors.dense(X1,X2))
    }
    
    //--通过随机梯度下降法来训练模型
    //--①参：数据  ②参：最大迭代次数  ③参：步长
    //--梯度下降法是通过数据解 去解解析解，所以梯度下降法应用更广泛
    val model=LinearRegressionWithSGD
              .train(parseData,20,0.1)
    
    val result=model.predict(parseData.map { x => x.features })          
    
    result.foreach{println}
  }
}