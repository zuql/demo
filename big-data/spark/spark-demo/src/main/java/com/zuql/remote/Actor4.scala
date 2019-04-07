package com.zuql.remote

import akka.actor.Actor
import java.util.ArrayList
import java.util.HashMap
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

class Actor4 extends Actor {
  
  def receive: Actor.Receive = {
    
    case message:String=>{
      
    }
  }
}
object Actor4{
  
  def main(args: Array[String]): Unit = {
    
    println("ak4启动")
    val list=new ArrayList[String]()
    list.add("akka.remote.netty.tcp")
    
    val conf=new HashMap[String,Object]()
    
    conf.put("akka.remote.enabled-transports", list)
    conf.put("akka.actor.provider", "akka.remote.RemoteActorRefProvider")
    conf.put("akka.remote.netty.tcp.hostname", "127.0.0.1")
    conf.put("akka.remote.netty.tcp.port", "44443")
    
    val ak4Server=ActorSystem("ak4Server",ConfigFactory.parseMap(conf))
  
    ak4Server.actorOf(Props[Actor4],"ak4")
    
    val ak3Path="akka.tcp://ak3Server@127.0.0.1:44444/user/ak3"
    
    ak4Server.actorSelection(ak3Path).!(new Book("java",50))

  }
  
}