package net.dericbourg.gtfs.api

object Wheelchair {

  /** Identifies whether wheelchair boardings are possible. */
  sealed trait WheelchairAccessibility

  /** Indicates that there is no accessibility information for the stop. */
  case object NoInformation extends WheelchairAccessibility

  /** Indicates that at least some vehicles at this stop can be boarded by a rider in a wheelchair. */
  case object Possible extends WheelchairAccessibility

  /** Wheelchair boarding is not possible at this stop. */
  case object NotPossible extends WheelchairAccessibility

}