package net.dericbourg.gtfs.mapping

import java.net.URI
import java.util.{Locale, TimeZone}

import net.dericbourg.gtfs.api.{Agency, AgencyId}
import net.dericbourg.gtfs.mapping.AgencyMapper._
import org.scalatest.Matchers

class AgencyMapperTest extends org.scalatest.WordSpec with Matchers {

  private val minimalAgency = Agency(
    AgencyId("agencyId123"),
    "Test agency",
    "https://developers.google.com/transit/gtfs/reference/agency-file",
    TimeZone.getTimeZone("GMT")
  )

  private val mandatoryFields = Map(
    Fields.AgencyId -> minimalAgency.id.value,
    Fields.AgencyName -> minimalAgency.name,
    Fields.AgencyUrl -> minimalAgency.url,
    Fields.AgencyTimezone -> "GMT"
  )

  "mapAgency" should {

    "bind a minimal agency from fields" in {
      checkMapping(mandatoryFields, minimalAgency)
    }

    "bind a full Agency from map of fields" in {
      val expectedAgency = minimalAgency.copy(
        lang = Some(Locale.FRENCH),
        phone = Some("+33 1 23 45 67 89"),
        fareUrl = Some(new URI("https://www.mozilla.org")),
        email = Some("contact@gtfs-test.net")
      )
      val fields = mandatoryFields ++
        Map(
          Fields.AgencyLang -> "fr",
          Fields.AgencyPhone -> expectedAgency.phone.get,
          Fields.AgencyFareUrl -> expectedAgency.fareUrl.get.toString,
          Fields.AgencyEmail -> expectedAgency.email.get
        )
      checkMapping(fields, expectedAgency)
    }

    "throw IllegalArgumentException" when {
      "mandatory fields are missing" in {
        Fields.Mandatory.foreach { mandatoryField =>
          intercept[IllegalArgumentException] {
            mapAgency(mandatoryFields - mandatoryField)
          }
        }
      }
    }
  }

  private def checkMapping(fields: Map[String, String], expected: Agency) = {
    val agency = AgencyMapper.mapAgency(fields)
    agency should be(expected)
  }

}
