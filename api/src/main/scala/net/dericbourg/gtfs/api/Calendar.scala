package net.dericbourg.gtfs.api

import java.time.{DayOfWeek, LocalDate}

/**
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
