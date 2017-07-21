package net.dericbourg.gtfs.api

import net.dericbourg.gtfs.core.NonNegInt

/**
  * Shapes describe the physical path that a vehicle takes. Shapes belong to Trips, and consist of a sequence of points.
  * Tracing the points in order provides the path of the vehicle. The points do not need to match stop locations.
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/shapes-file GTFS format API doc]]
  * @param shapeId Uniquely identifies a shape.
  * @param points  Points to draw vertices of the shape.
  *
  */
case class Shape(shapeId: ShapeId, points: Seq[ShapePoint])

sealed case class ShapeId(value: String) extends AnyVal

/**
  * Point taking port of a shape.
  *
  * @param coordinates       Coordinates of the point.
  * @param sequence          Associates the latitude and longitude of a shape point with its sequence order along the
  *                          shape. That number increases along the trip.
  * @param distanceTravelled This field positions a shape point as a distance traveled along a shape from the first
  *                          shape point. It represents a real distance traveled along the route in units such as feet
  *                          or kilometers. This information allows the trip planner to determine how much of the shape
  *                          to draw when showing part of a trip on the map.
  */
case class ShapePoint(coordinates: Coordinates,
                      sequence: NonNegInt,
                      distanceTravelled: Option[String])