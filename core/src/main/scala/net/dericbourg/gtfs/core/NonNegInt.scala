package net.dericbourg.gtfs.core

import scala.language.implicitConversions

class NonNegInt private(val value: Int) extends AnyVal {
  def toInt: Int = value
}

object NonNegInt {
  def apply(v: Int): NonNegInt = {
    require(v >= 0, "NonNegInt forbids negative integer values")
    new NonNegInt(v)
  }

  implicit def toNonNegInt(v: Int): NonNegInt = NonNegInt(v)
}


