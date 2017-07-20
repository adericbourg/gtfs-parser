package net.dericbourg.gtfs.api

import java.time.Duration

import net.dericbourg.gtfs.api.DropOff.DropOffType
import net.dericbourg.gtfs.api.Pickup.PickupType
import net.dericbourg.gtfs.api.Timepoint.TimepointPrecision
import net.dericbourg.gtfs.core.NonNegInt

/**
  * A StopTime defines when a vehicle arrives at a location, how long it stays there, and when it departs. StopTimes define the path and schedule of Trips.
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/stop_times-file GTFS format API doc]]
  * @param stopId            Stop identifier. Multiple routes may use the same stop.
  * @param tripId            Identifies the trip.
  * @param arrivalTime       Arrival time at a specific stop for a specific trip on a route. The time is measured from
  *                          "noon minus 12h" (effectively midnight, except for days on which daylight savings time
  *                          changes occur) at the beginning of the service date. For times occurring after midnight on
  *                          the service date, enter the time as a value greater than 24:00:00 in HH:MM:SS local time
  *                          for the day on which the trip schedule begins. When there is no separate times for arrival
  *                          and departure at a stop, [[arrivalTime]] and [[departureTime]] have the same value.
  *                          <table>
  *                          <tr>
  *                          <th>Time</th>
  *                          <th>[[arrivalTime]] value</th>
  *                          </tr>
  *                          <tr>
  *                          <td>08:10:00 A.M.</td>
  *                          <td>08:10:00</td>
  *                          </tr>
  *                          <tr>
  *                          <td>01:05:00 P.M.</td>
  *                          <td>13:05:00</td>
  *                          </tr>
  *                          <tr>
  *                          <td>01:55:00 A.M. (after the next midnight)</td>
  *                          <td>25:55:00</td>
  *                          </tr>
  *                          </table>
  * @param departureTime     Departure time from a specific stop for a specific trip on a route. The time is measured
  *                          from "noon minus 12h" (effectively midnight, except for days on which daylight savings time
  *                          changes occur) at the beginning of the service date. For times occurring after midnight on
  *                          the service date, enter the time as a value greater than 24:00:00 in HH:MM:SS local time
  *                          for the day on which the trip schedule begins.
  *                          <table>
  *                          <tr>
  *                          <th>Time</th>
  *                          <th>[[departureTime]] value</th>
  *                          </tr>
  *                          <tr>
  *                          <td>08:10:00 A.M.</td>
  *                          <td>08:10:00</td>
  *                          </tr>
  *                          <tr>
  *                          <td>01:05:00 P.M.</td>
  *                          <td>13:05:00</td>
  *                          </tr>
  *                          <tr>
  *                          <td>01:55:00 A.M. (after the next midnight)</td>
  *                          <td>25:55:00</td>
  *                          </tr>
  *                          </table>
  * @param sequence          Order of the stop for a particular trip. The sequence number do not have to be sequential:
  *                          for example, the first stop on the trip could have a sequence of 1, the second stop on the
  *                          trip could have a sequence of 23, the third stop could have a sequence of 40, and so on.
  * @param headSign          Text that appears on a sign that identifies the trip's destination to passengers.
  * @param pickupType        Indicates whether passengers are picked up at a stop as part of the normal schedule or
  *                          whether a pickup at the stop is not available. This field also allows the transit agency to
  *                          indicate that passengers must call the agency or notify the driver to arrange a pickup at a
  *                          particular stop.
  * @param dropOffType       Indicates whether passengers are dropped off at a stop as part of the normal schedule or
  *                          whether a drop off at the stop is not available. This field also allows the transit agency
  *                          to indicate that passengers must call the agency or notify the driver to arrange a drop off
  *                          at a particular stop.
  * @param shapeDistTraveled Positions a stop as a distance from the first shape point.
  * @param timepoint         Indicates if the specified arrival and departure times for a stop are strictly adhered to
  *                          by the transit vehicle or if they are instead approximate and/or interpolated times. The
  *                          field allows a GTFS producer to provide interpolated stop times that potentially
  *                          incorporate local knowledge, but still indicate if the times are approximate.
  */
case class StopTime(stopId: StopId,
                    tripId: TripId,
                    arrivalTime: Duration,
                    departureTime: Duration,
                    sequence: Option[NonNegInt],
                    headSign: Option[String],
                    pickupType: Option[PickupType],
                    dropOffType: Option[DropOffType],
                    shapeDistTraveled: Option[String],
                    timepoint: Option[TimepointPrecision])

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