package com.zuql.akka

import scala.actors.Actor

class Actor2 extends Actor {
  
  
  def receive: Actor.Receive = {
    
    case message:String=>{
      
      println("actor2收到String类型消息:"+message)
    }
    
    case message:Int=>{
      println("actor2收到Int类型消息:"+message)
    }
  }
}