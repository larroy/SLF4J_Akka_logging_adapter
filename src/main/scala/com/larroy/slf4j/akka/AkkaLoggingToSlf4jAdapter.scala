package com.larroy.slf4j.akka

import akka.event.LoggingAdapter
import org.slf4j.helpers.MessageFormatter
import org.slf4j.{Marker, Logger}

class AkkaLoggingToSlf4jAdapter(loggingAdapter: LoggingAdapter, name: String) extends Logger {
  override def warn(msg: String): Unit = loggingAdapter.warning(msg)

  override def warn(format: String, arg: scala.Any): Unit = loggingAdapter.warning(format, arg)

  override def warn(format: String, arguments: AnyRef*): Unit = {
    loggingAdapter.warning(MessageFormatter.arrayFormat(format, arguments.toArray).getMessage)
  }

  override def warn(format: String, arg1: scala.Any, arg2: scala.Any): Unit = {
    loggingAdapter.warning(format, arg1, arg2)
  }

  override def warn(msg: String, t: Throwable): Unit = {
    loggingAdapter.warning(s"$msg: ${t.toString}")
  }

  override def warn(marker: Marker, msg: String): Unit = warn(msg)

  override def warn(marker: Marker, format: String, arg: scala.Any): Unit = warn(format,arg)

  override def warn(marker: Marker, format: String, arg1: scala.Any, arg2: scala.Any): Unit = warn(format, arg1, arg2)

  override def warn(marker: Marker, format: String, arguments: AnyRef*): Unit = warn(format, arguments: _*)

  override def warn(marker: Marker, msg: String, t: Throwable): Unit = warn(msg, t)

  override def isErrorEnabled: Boolean = loggingAdapter.isErrorEnabled

  override def isErrorEnabled(marker: Marker): Boolean = loggingAdapter.isErrorEnabled

  override def getName: String = name

  override def isInfoEnabled: Boolean = loggingAdapter.isInfoEnabled

  override def isInfoEnabled(marker: Marker): Boolean = loggingAdapter.isInfoEnabled

  override def isDebugEnabled: Boolean = loggingAdapter.isDebugEnabled

  override def isDebugEnabled(marker: Marker): Boolean = loggingAdapter.isDebugEnabled

  override def isTraceEnabled: Boolean = loggingAdapter.isDebugEnabled

  override def isTraceEnabled(marker: Marker): Boolean = loggingAdapter.isDebugEnabled

  override def error(msg: String): Unit = loggingAdapter.error(msg)

  override def error(format: String, arg: scala.Any): Unit = loggingAdapter.error(format, arg)

  override def error(format: String, arg1: scala.Any, arg2: scala.Any): Unit = loggingAdapter.error(format, arg1, arg2)

  override def error(format: String, arguments: AnyRef*): Unit = {
    loggingAdapter.error(MessageFormatter.arrayFormat(format, arguments.toArray).getMessage)
  }

  override def error(msg: String, t: Throwable): Unit = {
    loggingAdapter.error(s"$msg: ${t.toString}")
  }

  override def error(marker: Marker, msg: String): Unit = {
    loggingAdapter.error(msg)
  }

  override def error(marker: Marker, format: String, arg: scala.Any): Unit = error(format, arg)

  override def error(marker: Marker, format: String, arg1: scala.Any, arg2: scala.Any): Unit = error(format, arg1, arg2)

  override def error(marker: Marker, format: String, arguments: AnyRef*): Unit = error(format, arguments: _*)

  override def error(marker: Marker, msg: String, t: Throwable): Unit = error(msg, t)

  override def debug(msg: String): Unit = loggingAdapter.debug(msg)

  override def debug(format: String, arg: scala.Any): Unit = loggingAdapter.debug(format, arg)

  override def debug(format: String, arg1: scala.Any, arg2: scala.Any): Unit = loggingAdapter.debug(format, arg1, arg2)

  override def debug(format: String, arguments: AnyRef*): Unit = {
    loggingAdapter.debug(MessageFormatter.arrayFormat(format, arguments.toArray).getMessage)
  }

  override def debug(msg: String, t: Throwable): Unit = {
    loggingAdapter.debug(s"$msg: ${t.toString}")
  }

  override def debug(marker: Marker, msg: String): Unit = debug(msg)

  override def debug(marker: Marker, format: String, arg: scala.Any): Unit = debug(format, arg)

  override def debug(marker: Marker, format: String, arg1: scala.Any, arg2: scala.Any): Unit = debug(format, arg1, arg2)

  override def debug(marker: Marker, format: String, arguments: AnyRef*): Unit = debug(format, arguments: _*)

  override def debug(marker: Marker, msg: String, t: Throwable): Unit = debug(msg, t)

  override def isWarnEnabled: Boolean = loggingAdapter.isWarningEnabled

  override def isWarnEnabled(marker: Marker): Boolean = isWarnEnabled

  override def trace(msg: String): Unit = debug(msg)

  override def trace(format: String, arg: scala.Any): Unit = debug(format, arg)

  override def trace(format: String, arg1: scala.Any, arg2: scala.Any): Unit = debug(format, arg1, arg2)

  override def trace(format: String, arguments: AnyRef*): Unit = debug(format, arguments)

  override def trace(msg: String, t: Throwable): Unit = debug(msg, t)

  override def trace(marker: Marker, msg: String): Unit = debug(msg)

  override def trace(marker: Marker, format: String, arg: scala.Any): Unit = debug(format, arg)

  override def trace(marker: Marker, format: String, arg1: scala.Any, arg2: scala.Any): Unit = debug(format, arg1, arg2)

  override def trace(marker: Marker, format: String, argArray: AnyRef*): Unit = debug(format, argArray: _*)

  override def trace(marker: Marker, msg: String, t: Throwable): Unit = debug(msg, t)

  override def info(msg: String): Unit = loggingAdapter.info(msg)

  override def info(format: String, arg: scala.Any): Unit = loggingAdapter.info(format, arg)

  override def info(format: String, arg1: scala.Any, arg2: scala.Any): Unit = loggingAdapter.info(format, arg1, arg2)

  override def info(format: String, arguments: AnyRef*): Unit = {
    loggingAdapter.info(MessageFormatter.arrayFormat(format, arguments.toArray).getMessage)
  }

  override def info(msg: String, t: Throwable): Unit = loggingAdapter.info(s"$msg: ${t.toString}")

  override def info(marker: Marker, msg: String): Unit = info(msg)

  override def info(marker: Marker, format: String, arg: scala.Any): Unit = info(format, arg)

  override def info(marker: Marker, format: String, arg1: scala.Any, arg2: scala.Any): Unit = info(format, arg1, arg2)

  override def info(marker: Marker, format: String, arguments: AnyRef*): Unit = info(format, arguments: _*)

  override def info(marker: Marker, msg: String, t: Throwable): Unit = info(msg, t)
}

object AkkaLoggingToSlf4jAdapter {
  def apply(loggingAdapter: LoggingAdapter, name: String = "Akka2Slf4j"): AkkaLoggingToSlf4jAdapter = {
    new AkkaLoggingToSlf4jAdapter(loggingAdapter, name)
  }
}
