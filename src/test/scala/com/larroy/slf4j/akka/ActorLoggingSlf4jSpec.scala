package com.larroy.slf4j.akka

import akka.actor.{Actor, ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import com.larroy.slf4j.{HasLogger, Logging}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

trait Base extends HasLogger {
  def f(): Unit = {
    log.debug("Base.f called")
  }
}

case class D() extends Base with Logging {
  log.debug("D")
  f()
}

class Act extends Actor with Base with ActorLoggingSlf4j {
  override def receive: Receive = {
    case msg ⇒
      log.debug(msg.toString)
      f()
      sender ! msg
  }
}

class ActorLoggingSlf4jSpec extends TestKit(ActorSystem("ActorLoggingSlf4jSpec"))
  with  WordSpecLike with BeforeAndAfterAll with Matchers with ImplicitSender {

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }
  "log messages" in {
    val act = system.actorOf(Props[Act], "Act")
    val msg = "hi there"
    act ! msg
    expectMsg(msg)
    val d = D()
  }
}

