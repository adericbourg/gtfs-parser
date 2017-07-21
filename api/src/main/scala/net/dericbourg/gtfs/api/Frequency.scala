package net.dericbourg.gtfs.api

import java.time.Duration

import net.dericbourg.gtfs.api.Frequency.TimePrecision

/**
  * Frequencies are used when a line does not have set arrival and departure times, but instead services run with a set
  * interval. Frequencies are defined in the file frequencies.txt, and are associated with a Trip definition. It is
  * intended to represent schedules that don't have a fixed list of stop times.
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/frequencies-file GTFS format API doc]]
  * @param tripId        Identifies a trip on which the specified frequency of service applies.
  * @param startTime     Specifies the time at which service begins with the specified frequency. The time is measured
  *                      from "noon minus 12h" (effectively midnight, except for days on which daylight savings time
  *                      changes occur) at the beginning of the service date. For times occurring after midnight, enter
  *                      the time as a value greater than 24:00:00 in HH:MM:SS local time for the day on which the trip
  *                      schedule begins. For example, 25:35:00.
  * @param endTime       Indicates the time at which service changes to a different frequency (or ceases) at the first
  *                      stop in the trip. The time is measured from "noon minus 12h" (effectively midnight, except for
  *                      days on which daylight savings time changes occur) at the beginning of the service date. For
  *                      times occurring after midnight, enter the time as a value greater than 24:00:00 in HH:MM:SS
  *                      local time for the day on which the trip schedule begins. For example, 25:35:00.
  * @param headway       Indicates the time between departures from the same stop (headway) for this trip type, during
  *                      the time interval specified by [[startTime]] and [[endTime]]. Periods in which headways are
  *                      defined shouldn't overlap for the same trip, because it's hard to determine what should be
  *                      inferred from two overlapping headways. However, a headway period may begin at the exact same
  *                      time that another one ends.
  * @param timePrecision Determines if frequency-based trips should be exactly scheduled based on the specified headway
  *                      information.
  */
case class Frequency(tripId: TripId,
                     startTime: Duration,
                     endTime: Duration,
                     headway: Duration,
                     timePrecision: Option[TimePrecision])

object Frequency {

  /**
    * Determines if frequency-based trips should be exactly scheduled based on the specified headway information.
    */
  sealed trait TimePrecision

  /**
    * Frequency-based trips are not exactly scheduled.
    */
  case object NotExact extends TimePrecision

  /**
    * Frequency-based trips are exactly scheduled.
    */
  case object ExactlyScheduled extends TimePrecision

}
