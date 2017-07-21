package net.dericbourg.gtfs.api

object Pickup {

  /**
    * Indicates whether passengers are picked up at a stop as part of the normal schedule or whether a pickup at the stop is not available.
    */
  sealed trait PickupType

  /**
    * Regularly scheduled pickup.
    */
  case object RegularlyScheduled extends PickupType

  /**
    * No pickup available.
    */
  case object NoPickupAvailable extends PickupType

  /**
    * Must phone agency to arrange pickup.
    */
  case object PhoneAgency extends PickupType

  /**
    * Must coordinate with driver to arrange pickup
    */
  case object CoordinateWithDriver extends PickupType

}
