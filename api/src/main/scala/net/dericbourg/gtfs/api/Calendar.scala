package net.dericbourg.gtfs.api

import java.time.{DayOfWeek, LocalDate}

/**
  * Services define a range of dates between which a Trip is available, the days of the week when it is available (such
  * as Monday through Friday). A single Service can be applied to multiple different Trips.
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/calendar-file GTFS format API doc]]
  * @param serviceId      Uniquely identifies a set of dates when service is available for one or more routes (from
  *                       trip).
  * @param availabilities Indicates whether the service is valid for all given days of week in the given date range.
  * @param startDate      Start date for the service.
  * @param endDate        End date for teh service (included).
  */
case class Calendar(serviceId: ServiceId,
                    availabilities: Map[DayOfWeek, Boolean],
                    startDate: LocalDate,
                    endDate: LocalDate)
