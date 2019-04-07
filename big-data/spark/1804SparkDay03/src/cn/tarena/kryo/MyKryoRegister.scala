package cn.tarena.kryo

import org.apache.spark.serializer.KryoRegistrator
import com.esotericsoftware.kryo.Kryo

class MyKryoRegister extends KryoRegistrator {
  
  def registerClasses(kryo: Kryo): Unit = {
    //--将Person类做注册，在序列化Peron对象，用的kryo
    kryo.register(classOf[Person])
    
  }
}