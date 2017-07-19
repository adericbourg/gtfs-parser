package net.dericbourg.gtfs.api

import java.net.URI
import java.util.{Locale, TimeZone}

/**
  * An Agency is an operator of a public transit network, often a public authority.
  * <br/>
  * Agencies are defined in the file agency.txt, and can have URLs, phone numbers, and language indicators.
  * If you are providing a feed that includes vehicles operated by different agencies, you can define multiple
  * agencies in this file and associate them with each Trip.
  * <br/>
  * @see [[https://developers.google.com/transit/gtfs/reference/agency-file GTFS format API doc]]
  *
  * @param id       Uniquely identifies a transit agency. A transit feed may represent data from more than one agency.
  * @param name     Full name of the transit agency.
  *                 For instance, Google Maps will display this name.
  * @param url      URL of the transit agency.
  * @param timezone Timezone where the transit agency is located.
  * @param lang     Primary language used by this transit agency.
  * @param phone    Single voice telephone number.
  * @param fareUrl  URL of a web page that allows a rider to purchase tickets or other fare instruments for that agency
  *                 online.
  * @param email    Email address actively monitored by the agency’s customer service department.
  */
case class Agency(id: AgencyId,
                  name: String,
                  url: String,
                  timezone: TimeZone,
                  lang: Option[Locale] = None,
                  phone: Option[String] = None,
                  fareUrl: Option[URI] = None,
                  email: Option[String] = None)


/**
  * Agency identifier.
  *
  * @param value Underlying type-unsafe value.
  */
case class AgencyId(value: String) extends AnyVal
