package net.dericbourg.gtfs

package object core {
  implicit def toInt(nn: NonNegInt): Int = nn.toInt
}
