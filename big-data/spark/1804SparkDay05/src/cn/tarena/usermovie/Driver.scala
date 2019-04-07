package cn.tarena.usermovie

object Driver {
  
  def main(args: Array[String]): Unit = {
    val user1FilmSource=Map("m1"->2,"m2"->3,"m3"->1,"m4"->0,"m5"->1)
    
    val user2FilmSource=Map("m1"->1,"m2"->2,"m3"->2,"m4"->1,"m5"->4)
    
    val user3FilmSource=Map("m1"->2,"m2"->1,"m3"->0,"m4"->1,"m5"->4)
    
    val user4FilmSource=Map("m1"->3,"m2"->2,"m3"->0,"m4"->5,"m5"->3)
  
    val user5FilmSource=Map("m1"->5,"m2"->3,"m3"->1,"m4"->1,"m5"->2)
    
    val u1u2=user1FilmSource.zip(user2FilmSource)
    
    val u1u2Fenzi=u1u2.map{x=>x._1._2*x._2._2}.reduce(_+_)
    
    val u1Fenmu=Math.sqrt(user1FilmSource.map{case(k,v)=>v*v}.reduce(_+_))
    val u2Fenmu=Math.sqrt(user2FilmSource.map{case(k,v)=>v*v}.reduce(_+_))
    
    val u1u2Cos=u1u2Fenzi/(u1Fenmu*u2Fenmu)
    
    println(u1u2Cos)
  }
}