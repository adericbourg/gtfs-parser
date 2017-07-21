package net.dericbourg.gtfs.api

object Location {

  /** Identifies whether a stop represents a stop or station. */
  sealed trait LocationType

  /** A location where passengers board or disembark from a transit vehicle. */
  case object Stop extends LocationType

  /** A physical structure or area that contains one or more stop. */
  case object Station extends LocationType

}
