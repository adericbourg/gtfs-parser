package net.dericbourg.gtfs.api

object DropOff {

  /**
    * Indicates whether passengers are dropped off at a stop as part of the normal schedule or whether a drop off at the stop is not available.
    */
  sealed trait DropOffType

  /**
    * Regularly scheduled drop off.
    */
  case object RegularlyScheduled extends DropOffType

  /**
    * No drop off available.
    */
  case object NoDropOffAvailable extends DropOffType

  /**
    * Must phone agency to arrange drop off.
    */
  case object PhoneAgency extends DropOffType

  /**
    * Must coordinate with driver to arrange drop off.
    */
  case object CoordinateWithDriver extends DropOffType

}