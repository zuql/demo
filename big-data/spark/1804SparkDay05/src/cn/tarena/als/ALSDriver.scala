package cn.tarena.als

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.recommendation.Rating
import org.apache.spark.mllib.recommendation.ALS

object ALSDriver {
  
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf().setMaster("local").setAppName("als")
    val sc=new SparkContext(conf)
    val data=sc.textFile("d://ml/als.txt")
    
    val parseData=data.map { line =>
      val userId=line.split(" ")(0).toInt
      val itemId=line.split(" ")(1).toInt
      val rating=line.split(" ")(2).toDouble
    
      Rating(userId,itemId,rating)
    }
    
    //--①参：用户的偏好矩阵  ②参：隐藏因子数 一般的取值范围:10~200
    //--③参：最大迭代次数
    //--ALS 交替最小二乘法
    //--④参：λ的引入是为了防止模型的过拟合
    val model=ALS.train(parseData, 2, 20, 0.01)
    
    //--下例表示 为用户1推荐两个商品
    val u1Result=model.recommendProducts(1, 2)
    
    //--下例表示为12号商品推荐两个用户
    val item12Result=model.recommendUsers(12, 2)
    item12Result.foreach{println}
  }
}