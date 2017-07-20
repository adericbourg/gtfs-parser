package net.dericbourg.gtfs.api

import net.dericbourg.gtfs.api.Bike.BikeAllowance
import net.dericbourg.gtfs.api.Direction.DirectionType
import net.dericbourg.gtfs.api.Wheelchair.WheelchairAccessibility

/**
  * A Trip represents a journey taken by a vehicle through Stops. Trips are time-specific — they are defined as a
  * sequence of StopTimes, so a single Trip represents one journey along a transit line or route. In addition to
  * StopTimes, Trips use Calendars to define the days when a Trip is available to passengers.
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/trips-file GTFS format API doc]]
  * @param id           Trip identifier.
  * @param routeId      Route identifier.
  * @param serviceId    Service identifier. It identifies a set of dates when service is available for one or more routes.
  * @param headSign     Text that appears on a sign that identifies the trip's destination to passengers. Use this field to distinguish between different patterns of service in the same route. If the headsign changes during a trip, you can override the trip_headsign by specifying values for the the stop_headsign field in StopTimes.
  * @param shortName    text that appears in schedules and sign boards to identify the trip to passengers, for example, to identify train numbers for commuter rail trips. If riders do not commonly rely on trip names, please leave this field blank.
  * @param direction    Indicates the direction of travel for a trip. Use this field to distinguish between bi-directional trips with the same [[Route]].
  * @param block        Block to which the trip belongs. A block consists of two or more sequential trips made using the same vehicle, where a passenger can transfer from one trip to the next just by staying in the vehicle.
  * @param shape        Shape for the trip. This value references a [[Shape]].
  * @param wheelchair   Identifies whether wheelchair boardings are possible on this trip.
  * @param bikesAllowed Identifies whether bikes are allowed on this trip.
  */
case class Trip(id: TripId,
                routeId: RouteId,
                serviceId: ServiceId,
                headSign: Option[String] = None,
                shortName: Option[String] = None,
                direction: Option[DirectionType] = None,
                block: Option[String] = None,
                shape: Option[ShapeId] = None,
                wheelchair: Option[WheelchairAccessibility] = None,
                bikesAllowed: Option[BikeAllowance] = None)

case class TripId(value: String) extends AnyVal

case class ServiceId(value: String) extends AnyVal

object Direction {

  /**
    * Direction of travel for a trip. It distinguished bi-directional trips with the same route.
    */
  sealed trait DirectionType

  /**
    * Travel in one direction (outbound travel).
    */
  case object Outbound extends DirectionType

  /**
    * Travel in the opposite direction (inbound travel).
    */
  case object Inbound extends DirectionType

}

object Bike {

  /**
    * Bike allowance.
    */
  sealed trait BikeAllowance

  /**
    * No bike information.
    */
  case object NoInformation extends BikeAllowance

  /**
    * The vehicle can accommodate at least one bicycle.
    */
  case object Possible extends BikeAllowance

  /**
    * No bicycles are allowed.
    */
  case object NotPossible extends BikeAllowance

}