
/**
 * 1.通过case 来声明一个样例类
 * 2.样例类必须显示的构造一个主构造器
 * 3.样例类默认混入序列化特质(trait)
 * 4.样例类默认会创建空构造器
 * 5.样例类不需要new,就可以创建一个新对象
 */
case class Item(v1:Int,v2:String) {
  
  var id=v1
  var title=v2
  
}