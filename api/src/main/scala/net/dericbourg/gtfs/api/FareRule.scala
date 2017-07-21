package net.dericbourg.gtfs.api

/**
  * A [[FareRule]] lets you specify how fares apply to an itinerary. Most fare structures use some combination of the
  * following rules:
  *
  * <ul>
  * <li>Fare depends on origin or destination stations.</li>
  * <li>Fare depends on which zones the itinerary passes through.</li>
  * <li>Fare depends on which route the itinerary uses.</li>
  * </ul>
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/fare_rules-file GTFS format API doc]]
  * @param fareId        Uniquely identifies a fare class.
  * @param routeId       Associates the fare ID with a route.
  * @param originId      Associates the fare ID with an origin zone ID.
  * @param destinationId Associates the fare ID with a destination zone ID.
  * @param containsId    Associates the fare ID with a zone ID.
  */
case class FareRule(fareId: FareId,
                    routeId: Option[RouteId],
                    originId: Option[ZoneId],
                    destinationId: Option[ZoneId],
                    containsId: Option[ZoneId])
