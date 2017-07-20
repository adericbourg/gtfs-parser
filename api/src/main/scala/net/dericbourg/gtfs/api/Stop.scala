package net.dericbourg.gtfs.api

import java.net.URI
import java.util.TimeZone

import net.dericbourg.gtfs.api.Location.LocationType
import net.dericbourg.gtfs.api.Wheelchair.WheelchairAccessibility

/**
  * A stop is a location where vehicles stop to pick up or drop off passengers.
  * <br/>
  * Stops are defined in the file stops.txt. Stops can be grouped together, such as when there are multiple
  * stops within a single station. This is done by defining one Stop for the station, and defining it as a
  * parent for all the Stops it contains. Stops may also have zone identifiers, to group them together into
  * zones. This can be used together with FareAttributes and FareRules for zone-based ticketing.
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/stops-file GTFS format API doc]]
  * @param id                 Uniquely identifies a stop or station.
  *                           Multiple routes may use the same stop. This identifier is unique in the dataset.
  * @param code               Uniquely identifies the stop for passengers.
  *                           Stop codes are often used in phone-based transit information systems or printed on stop
  *                           signage to make it easier for riders to get a stop schedule or real-time arrival
  *                           information for a particular stop. The stop code field should only be used for stop codes
  *                           that are displayed to passengers.
  *                           For internal codes, the identifier is used. This field is left blank for stops without a
  *                           code.
  * @param name               Name of a stop or station. Name is supposed to be understood by people in the local and
  *                           tourist vernacular.
  * @param coordinates        Coordinates of the stop of the station. The field values must be a valid WGS 84 latitude
  *                           or longitude.
  * @param description        Description of the stop. It should provide useful, quality information, not simply
  *                           duplicate the name of the stop.
  * @param zoneId             Fare zone for the stop.
  *                           If this stop represents a station, the zone identifier is ignored.
  * @param url                URL of a web page about a particular stop. It is expected to be different from the agency
  *                           URL or the route URL.
  * @param locationType       Identifies whether this stop represents a stop or station.
  * @param parentStation      For stops that are physically located inside stations, this field identifies the station
  *                           associated with the stop.
  * @param timezone           Timezone in which this stop or station is located.
  * @param wheelchairBoarding Identifies whether wheelchair boardings are possible from the specified stop or station.
  */
case class Stop(id: StopId,
                code: String,
                name: String,
                coordinates: Coordinates,
                description: Option[String] = None,
                zoneId: Option[ZoneId] = None,
                url: Option[URI],
                locationType: Option[LocationType] = None,
                parentStation: Option[StopId],
                timezone: Option[TimeZone],
                wheelchairBoarding: Option[WheelchairAccessibility])

/**
  * Stop identifier.
  *
  * @param value Underlying type-unsafe value.
  */
case class StopId(value: String) extends AnyVal

/**
  * Fare zone identifier.
  *
  * @param value Underlying type-unsafe value.
  */
case class ZoneId(value: String) extends AnyVal

object Location {

  /** Identifies whether a stop represents a stop or station. */
  sealed trait LocationType

  /** A location where passengers board or disembark from a transit vehicle. */
  case object Stop extends LocationType

  /** A physical structure or area that contains one or more stop. */
  case object Station extends LocationType

}
