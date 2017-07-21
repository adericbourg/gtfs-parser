package net.dericbourg.gtfs.api

import java.time.Duration
import java.util.Currency

import net.dericbourg.gtfs.api.FareAttribute.{PaymentMethod, Transfer}

/**
  * A [[FareAttribute]] defines a fare class. A [[FareAttribute]] has a price, currency and whether it must be purchased
  * on board the service or before boarding. It also defines the number of transfers it can be used for, and the
  * duration it is valid.
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/fare_attributes-file GTFS format API doc]]
  * @param fareId           Uniquely identifies a fare class.
  * @param price            Fare price. The unit is specified by [[currency]].
  * @param currency         Currency used to pay the fare.
  * @param paymentMethod    Indicates when the fare must be paid.
  * @param transfers        Specifies the number of transfers permitted on this fare.
  * @param transferDuration Specifies the length of time in seconds before a transfer expires.
  */
case class FareAttribute(fareId: FareId,
                         price: Double,
                         currency: Currency,
                         paymentMethod: PaymentMethod,
                         transfers: Transfer,
                         transferDuration: Option[Duration])

case class FareId(value: String) extends AnyVal

object FareAttribute {

  /**
    * Indicates when the fare must be paid.
    */
  sealed trait PaymentMethod

  /**
    * Fare is paid on board.
    */
  case object OnBoard extends PaymentMethod

  /**
    * Fare must be paid before boarding.
    */
  case object BeforeBoarding extends PaymentMethod

  /**
    * Specifies the number of transfers permitted on this fare.
    */
  sealed trait Transfer

  /**
    * No transfers permitted on this fare.
    */
  case object NoTransfer extends Transfer

  /**
    * Passenger may transfer once.
    */
  case object Once extends Transfer

  /**
    * Passenger may transfer twice.
    */
  case object Twice extends Transfer

  /**
    * Unlimited transfers are permitted.
    */
  case object Unlimited extends Transfer

}

