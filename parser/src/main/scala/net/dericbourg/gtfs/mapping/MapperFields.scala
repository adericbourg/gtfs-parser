package net.dericbourg.gtfs.mapping

import scala.reflect._

trait MapperFields {
  def Mandatory: Seq[String]
}

trait MapperChecks {
  def checkMandatoryFields[T: ClassTag](mapperFields: MapperFields, providedFields: Set[String]): Unit = {
    val missingFields = mapperFields.Mandatory.filterNot(providedFields.contains)
    if (missingFields.nonEmpty) {
      throw new IllegalArgumentException(s"Unable to build ${classTag[T].runtimeClass}: missing fields (${missingFields.mkString(", ")})")
    }
  }
}