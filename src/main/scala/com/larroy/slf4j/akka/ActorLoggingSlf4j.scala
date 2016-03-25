package com.larroy.slf4j.akka

import akka.actor.Actor
import akka.event.LoggingAdapter
import org.slf4j.Logger

trait ActorLoggingSlf4j {
  this: Actor ⇒
  private var _loggingAdapter: LoggingAdapter = _
  private var _logger: Logger = _

  def log: Logger = {
    if (_loggingAdapter == null || _logger == null) {
      _loggingAdapter = akka.event.Logging(context.system, this)
      _logger = AkkaLoggingToSlf4jAdapter(_loggingAdapter)
    }
    _logger
  }
}
