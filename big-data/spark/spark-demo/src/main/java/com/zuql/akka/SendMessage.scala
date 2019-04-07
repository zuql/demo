package com.zuql.akka

import akka.actor.ActorSystem
import akka.actor.Props

object SendMessage {
  
  def main(args: Array[String]): Unit = {
    
    //--获取actor系统对象
    val ackSys=ActorSystem("1804")
    
    //--获取用于向Actor1发消息的对象
    val ack1=ackSys.actorOf(Props[Actor1])
    
    //--发送消息 
    ack1.!("hello1804")
    
  }
}