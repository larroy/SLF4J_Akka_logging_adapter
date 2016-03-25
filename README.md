# SLF4J_Akka_logging_adapter
SLF4J to [Akka logging adapter](http://doc.akka.io/docs/akka/2.4.2/scala/logging.html), compose classes and traits using Slf4j logging into Akka actors with Akka native logging

Not to be confused with the Slf4j back-end which is already provided by Akka, this package solves a different problem.

## Problem
When you use [ActorLogging](http://doc.akka.io/api/akka/2.4.2/#akka.actor.ActorLogging) from Akka, the `log` variable is of type LoggingAdapter which is not
compatible with Slf4j's [Logger](http://www.slf4j.org/api/org/slf4j/Logger.html). Futhermore, vanilla Slf4j's logging is locking and thus [not recommended 
to be used inside Actors](http://doc.akka.io/docs/akka/2.4.2/scala/logging.html#slf4j-directly-scala).

That means it's not possible to compose traits that use an Slf4j `log` with an Actor that uses an Akka's `log` via `ActorLogging`.

This package solves this problem by providing an `ActorLoggingSlf4j` trait which when mixed into an Actor provides a Slf4j `log` which logs to Akka in a non-blocking way.

```scala
import org.slf4j.Logger

trait HasLogger {
  def log: Logger
}

// Base can be used both from Akka and outside akka without modifying
// the log statements
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
      f()  // logging inside f() will go to Akka's logging subsystem
      sender ! msg
  }
}
```
