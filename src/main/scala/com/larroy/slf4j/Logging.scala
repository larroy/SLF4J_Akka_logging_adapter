package com.larroy.slf4j

import org.slf4j.{LoggerFactory, Logger}

trait Logging {
  val log: Logger = LoggerFactory.getLogger(this.getClass)
}
