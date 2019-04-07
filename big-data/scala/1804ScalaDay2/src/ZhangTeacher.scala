

/**
 * 1.scala 继承用extends
 * 2.混入 用with
 * 3.单继承，多混入
 * 4.scala要求必须有且仅有一个extends关键字
 */
class ZhangTeacher  extends Drive with Dance with Serializable{
  
  def makeNote(): String = {
    ???
  }

  def run(): Unit = {
    ???
  }

  def say(word: String): Int = {
    ???
  }

  def teach(): Unit = {
    ???
  }
  
  def cook()={println("cook")}

  def balei(): Unit = {
    ???
  }

  def floor(): Unit = {
    ???
  }

  def start(): Unit = {
    ???
  }

  def stop(): Unit = {
    ???
  }
}