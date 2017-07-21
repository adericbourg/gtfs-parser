package net.dericbourg.gtfs.api

import java.net.URI
import java.time.LocalDate
import java.util.Locale

/**
  * Information about the feed itself, rather than the services that the feed describes.
  *
  * @param publisherName Full name of the organization that publishes the feed.
  * @param publisherUrl  URL of the feed publishing organization's website.
  * @param lang          Default language used for the text in this feed.
  * @param startDate     Schedule information for service in the period (start date).
  * @param endDate       Schedule information for service in the period (end date).
  * @param version       The feed publisher can specify a string here that indicates the current version of their GTFS
  *                      feed. GTFS-consuming applications can display this value to help feed publishers determine
  *                      whether the latest version of their feed has been incorporated.
  */
case class FeedInfo(publisherName: String,
                    publisherUrl: URI,
                    lang: Locale,
                    startDate: Option[LocalDate],
                    endDate: Option[LocalDate],
                    version: Option[String])
