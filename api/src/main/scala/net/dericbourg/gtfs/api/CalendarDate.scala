package net.dericbourg.gtfs.api

import java.time.LocalDate

import net.dericbourg.gtfs.api.CalendarDate.ExceptionType

/**
  * If there are specific days when a trip is not available, such as holidays, they are defined using a
  * [[CalendarDate]].
  *
  * You can use this to define exceptional days when the [[Trip]] is operated, as well as when it is not operated.
  * For example, you may have special services that are only operated on a public holiday, and they would be defined as
  * unavailable (in [[Calendar]]) and as available on the holiday (in [[CalendarDate]]).
  *
  * @param serviceId     Uniquely identifies a set of dates when a service exception is available for one or more
  *                      routes.
  * @param date          Date when service availability is different than the norm.
  * @param exceptionType Indicates whether service is available on the date specified in the [[date]] field.
  */
case class CalendarDate(serviceId: ServiceId,
                        date: LocalDate,
                        exceptionType: ExceptionType)


object CalendarDate {

  /**
    * Indicates whether service is available on the date specified in the date field.
    */
  sealed trait ExceptionType

  /**
    * That service has been added for the specified date.
    */
  case object Added extends ExceptionType

  /**
    * That service has been removed for the specified date.
    */
  case object Removed extends ExceptionType

}