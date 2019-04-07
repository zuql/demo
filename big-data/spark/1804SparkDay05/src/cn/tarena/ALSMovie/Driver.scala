package cn.tarena.ALSMovie

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.recommendation.Rating
import org.apache.spark.mllib.recommendation.ALS
import org.jblas.DoubleMatrix
import com.facebook.fb303.FacebookBase

object Driver {
  
  //--用于计算两个向量之间夹角余弦
  def cos(vec1:DoubleMatrix,vec2:DoubleMatrix)={
    
    vec1.dot(vec2)/(vec1.norm2()*vec2.norm2())
    
  }
    
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setMaster("local").setAppName("als")
    val sc=new SparkContext(conf)
    
    val data=sc.textFile("d://ml/u.data",3)
    
    val parseData=data.map { line =>
      val info=line.split("\t")
      val userId=info(0).toInt
      val movieId=info(1).toInt
      val rating=info(2).toDouble
      
      Rating(userId,movieId,rating)
    }
    //--根据用户的偏好矩阵建模
    val model=ALS.train(parseData,50,10,0.01)
    
    //--为编号为789号的用户推荐10部分
    val user789=model.recommendProducts(789,10)
    //--下列表示预测789号用户对于123号电影的评分
    val user789For123=model.predict(789,123)
    
    //--读取电影文件数据
    val movieData=sc.textFile("d://ml/u.item",3)
    
    //--把电影数据封装成Map<id,name>
    val movieMap=movieData.map { line =>
       val movieId=line.split("\\|")(0).toInt
       val movieName=line.split("\\|")(1)
       (movieId,movieName)
    }.collectAsMap
    
    //--验证推荐模型的准确性.处理思路：
    //--①先找出789号用户看过的所有电影 ，假设一共看过30部
    //--②通过打分，找出789喜爱的前10部电影
    //--③拿推荐的结果和喜爱的结果做对比，看有没有相似题材的电影
    
    //--找出789号用户看过的所有电影
    val movieFor789=parseData.keyBy { x => x.user }.lookup(789)
    
    val movieFor789Top10=movieFor789.sortBy { x => -x.rating }
                          .take(10)
                          .map { x =>(x.product,movieMap(x.product)) }
    
    movieFor789Top10.foreach{println}                      
    
    println("--------------------------")                      
    user789.map { x => (x.product,movieMap(x.product))}
           .foreach{println}
           
    //--接下来，要做的是基于商品的推荐
    //--比如用户123号看了一部 Godfather电影，然后推荐10部
    //--实现思路：先计算所有电影和Godfather电影的相似度
    //--按相似度大小做降序排序，然后取出前10部做推荐    
    //--这种推荐，相当于是基于某个商品来推荐其他商品
    
    val movieId=567
    
    //--从总的物品因子矩阵中，获取567号的因子
    val factor567=model.productFeatures.lookup(movieId).head
    
    //--做数据的封装，便于下一步相似度计算
    val vector567=new DoubleMatrix(factor567)
    
    val cosResults=model.productFeatures.map{case(id,factors)=>
        val vectorOther=new DoubleMatrix(factors)
        val cosResult=cos(vector567,vectorOther)
        (id,cosResult)
    }.sortBy{case(id,cosResult)=> -cosResult}.take(10)
    .map{case(id,cosResult)=>(id,movieMap(id),cosResult)}
    
    cosResults.foreach{println}
  }
}