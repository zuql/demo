package com.zuql.remote

import akka.actor.Actor
import java.util.ArrayList
import java.util.HashMap
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

class Actor3 extends Actor {
  
  
  def receive: Actor.Receive = {
    
    case message:String=>{
      
      println("actor3收到消息:"+message)
    }
    
    case message:Book=>{
      println("actor3收到book:"+message.title+":"+message.price)
    }
  }
}
//--创建伴生对象
object Actor3{
  
  def main(args: Array[String]): Unit = {
    println("ak3启动")
    val list = new ArrayList[String]()
    
    list.add("akka.remote.netty.tcp")
    val conf = new HashMap[String,Object]()
    
    conf.put("akka.remote.enabled-transports", list)
    conf.put("akka.actor.provider", "akka.remote.RemoteActorRefProvider")
    conf.put("akka.remote.netty.tcp.hostname", "127.0.0.1")
    conf.put("akka.remote.netty.tcp.port", "44444")
    
    val ak3Server=ActorSystem("ak3Server",ConfigFactory.parseMap(conf))
    ak3Server.actorOf(Props[Actor3],"ak3")

  }
  
}