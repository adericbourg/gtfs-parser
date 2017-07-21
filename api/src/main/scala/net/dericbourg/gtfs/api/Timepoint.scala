package net.dericbourg.gtfs.api

object Timepoint {

  /**
    * Precision of timepoints.
    */
  sealed trait TimepointPrecision

  /**
    * Times are considered exact.
    */
  case object Exact extends TimepointPrecision

  /**
    * Times are considered approximate.
    */
  case object Approximate extends TimepointPrecision

}
