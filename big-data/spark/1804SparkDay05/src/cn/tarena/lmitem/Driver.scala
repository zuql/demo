package cn.tarena.lmitem

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.regression.LinearRegression

object Driver {
  
  def main(args: Array[String]): Unit = {
    
    val conf=new SparkConf().setMaster("local").setAppName("item")
    val sc=new SparkContext(conf)
    val sqc=new SQLContext(sc)
    
    val data=sc.textFile("d://ml/lritem.txt")
    
    //--接下来要调用SparkMLlib 的线性回归模型
    //--在建模里，一般用线性模型来求解，因为线性方程的形式是已知的
    //--比如直线方程：y=β1X1+β0 平面方程：y=β1X1+β2X2+β0
    //--如果是非线性问题，也会想办法转成线程问题来求解
    
    //--建模的要求需要把原始数据转成 DataFrame格式
    val parseData=data.map { line =>
      val Y=line.split("\\|")(0).toDouble
      val X1=line.split("\\|")(1).split(" ")(0).toDouble
      val X2=line.split("\\|")(1).split(" ")(1).toDouble
      //--将一行数据返回成三元tuple，满足DataFrame格式
      (X1,X2,Y)
    }
    
    val df=sqc.createDataFrame(parseData).toDF("X1","X2","Y")
    
    val features=Array("X1","X2")
    
    //--获取向量转换器，并指定 输入的特征列是哪些
    //--特征列指的是所有的自变量(X1,X2……)
    val ass=new VectorAssembler().setInputCols(features)
                                 .setOutputCol("features")
    //--把DF转成向量类型，满足建模的需要                            
    val dfvector=ass.transform(df) 
    
    //--Y(需求量) X1(价格) X2(消费者收入)
    //--Y=β1X1+β2X2+β0
    //--利用最小二乘的思想：
    //--Yi=β1X1+β2X2+β0+误差
    //--min∑误差的平方和=∑(Yi-β1X1-β2X2-β0)^2
    //--求偏导数=0，从而解出β1,β2,β0 得出最优解
    
    //--Y=-6.49X1+0.016X2+106.36
    val model=new LinearRegression().setFeaturesCol("features")
                  .setLabelCol("Y")
                  //--true表示需要计算截距项系数 β0
                  .setFitIntercept(true)
                  //--传入数据，训练模型
                  .fit(dfvector)
                  
    val coe=model.coefficients //获取每个自变量的系数值
    val intercept=model.intercept//获取截距项
    
    //--回代原来的数据集
    val result=model.transform(dfvector)
    val selectResult=result.selectExpr("features","Y","round(prediction,2)")
    
    //--预测X1=10 X2=400 Y=?
    //-- X1=20 X2=500 Y=?
    //-- X1=50 X2=1000 Y=?
    
    val testData=sc.makeRDD(List((10.0,400.0,0.0),(20.0,500.0,0.0),(50.0,1000.0,0.0)))
    val testDF=sqc.createDataFrame(testData).toDF("X1","X2","Y")
    val testDFVector=ass.transform(testDF)
    
    //--基于已训练好的模型来预测一组样本值
    val testResult=model.transform(testDFVector).selectExpr("round(prediction,2)")
    
    testResult.foreach{x=>println(x)}
    
    //--获取模型的多元R方值，此值越接近1，说明模型对于数据的拟合越好
    println(model.summary.r2)
   
                  
  }
}