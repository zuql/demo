

class Person {
  
  //--定义到类内部的函数称为成员函数
  def eat()={
    
    println("eat")
    
    //--定义到函数内部的函数称为本地函数
    def cook={
      println("cook food")
    }
  }
}