package net.dericbourg.gtfs.mapping

import java.net.URI
import java.util.{Locale, TimeZone}

import net.dericbourg.gtfs.api.{Agency, AgencyId}

object AgencyMapper extends MapperChecks {

  val Fields = new MapperFields {
    val AgencyId = "agency_id"
    val AgencyName = "agency_name"
    val AgencyUrl = "agency_url"
    val AgencyTimezone = "agency_timezone"
    val AgencyLang = "agency_lang"
    val AgencyPhone = "agency_phone"
    val AgencyFareUrl = "agency_fare_url"
    val AgencyEmail = "agency_email"

    val Mandatory = Seq(AgencyId, AgencyName, AgencyUrl, AgencyTimezone)
  }

  def mapAgency(fields: Map[String, String]): Agency = {
    checkMandatoryFields[Agency](Fields, fields.keySet)
    Agency(
      AgencyId(fields(Fields.AgencyId)),
      fields(Fields.AgencyName),
      fields(Fields.AgencyUrl),
      TimeZone.getTimeZone(fields(Fields.AgencyTimezone)),
      fields.get(Fields.AgencyLang).map(Locale.forLanguageTag),
      fields.get(Fields.AgencyPhone),
      fields.get(Fields.AgencyFareUrl).map(new URI(_)),
      fields.get(Fields.AgencyEmail)
    )
  }
}
