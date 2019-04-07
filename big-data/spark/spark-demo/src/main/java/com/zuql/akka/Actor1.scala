package com.zuql.akka

import akka.actor.Actor
import akka.actor.Props
import cn.tarena.ssort.SecondSort

class Actor1 extends Actor {
  
  //--此方法是actor的邮箱方法方法，用于接收消息的
  //--对于消息的处理机制，是根据case机制+具体消费类型匹配的
  def receive: Actor.Receive = {
    
    case message:String=>{
      
      println("String类型:"+message)
      
      //--通过Akka框架的上下文对象，获取向Actor2发消息的对象
      val ack2=context.actorOf(Props[Actor2])
      //--向Actor2发送消息
      ack2.!(message)
    }
    
    case message:Int=>{
      println("Int类型:"+message)
    }
    
    case message:Array[Int]=>{
      println("Array类型:"+message.mkString("*"))
      
    }
    
  }
}