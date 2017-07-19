package net.dericbourg.gtfs.api

import java.net.URI

import net.dericbourg.gtfs.api.Route.RouteType

/**
  * GTFS Routes are equivalent to "Lines" in public transportation systems. Routes are made up of one or more Trips —
  * remember that a Trip occurs at a specific time and so a Route is time-independent.
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/routes-file See GTFS format API doc]]
  * @param id          Route unique identifier.
  * @param shortName   Short name of a route. This will often be a short, abstract identifier like "32", "100X", or
  *                    "Green" that riders use to identify a route, but which doesn't give any indication of what places
  *                    the route serves.
  * @param longName    Full name of a route. This name is generally more descriptive than the [[shortName]] and
  *                    will often include the route's destination or stop.
  * @param description Description of a route with quality information.  For example, "A trains operate between
  *                    Inwood-207 St, Manhattan and Far Rockaway-Mott Avenue, Queens at all times. Also from about 6AM
  *                    until about midnight, additional A trains operate between Inwood-207 St and Lefferts Boulevard
  *                    (trains typically alternate between Lefferts Blvd and Far Rockaway)."
  * @param routeType   Type of transportation used on the route.
  * @param agencyId    Agency for this route.
  * @param url         URL of a web page about that particular route
  * @param color       In systems that have colors assigned to routes, this defines a color that corresponds to a route.
  * @param textColor   Legible color to use for text drawn against a background of [[color]].
  */
case class Route(id: RouteId,
                 shortName: String,
                 longName: String,
                 description: String,
                 routeType: RouteType,
                 agencyId: Option[AgencyId] = None,
                 url: Option[URI] = None,
                 color: Option[String],
                 textColor: Option[String])

/**
  * Route identifier.
  *
  * @param value Underlying type-unsafe value.
  */
case class RouteId(value: String) extends AnyVal

object Route {

  /** Type of transportation used on a route. */
  sealed trait RouteType

  /** Tram, Streetcar, Light rail. Any light rail or street level system within a metropolitan area.  */
  case object LightRail extends RouteType

  /** Any underground rail system within a metropolitan area. */
  case object Subway extends RouteType

  /** Intercity or long-distance travel. */
  case object Rail extends RouteType

  /** Short- and long-distance bus routes. */
  case object Bus extends RouteType

  /** Short- and long-distance boat service. */
  case object Ferry extends RouteType

  /** Street-level cable cars where the cable runs beneath the car. */
  case object Cable extends RouteType

  /** Gondola, Suspended cable car. Typically used for aerial cable cars where the car is suspended from the cable. */
  case object Gondola extends RouteType

  /** Any rail system designed for steep inclines. */
  case object Funicular extends RouteType

}