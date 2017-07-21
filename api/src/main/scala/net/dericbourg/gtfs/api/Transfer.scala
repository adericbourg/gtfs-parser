package net.dericbourg.gtfs.api

import java.time.Duration

import net.dericbourg.gtfs.api.Transfer.TransferType

/**
  * Trip planners normally calculate transfer points based on the relative proximity of stops in each route.
  *
  * @see [[https://developers.google.com/transit/gtfs/reference/transfers-file GTFS format API doc]]
  * @param fromStopId      Stop or station where a connection between routes begins.
  * @param toStopId        Stop or station where a connection between routes ends.
  * @param transferType    Type of connection. When appropriate, the time required to transfer is specified by
  *                        [[minTransferTime]].
  * @param minTransferTime When a connection between routes requires an amount of time between arrival and departure
  *                        ([[transferType]] is [[net.dericbourg.gtfs.api.Transfer.TimeNeeded]]), this field defines the
  *                        amount of time that must be available in an itinerary to permit a transfer between routes at
  *                        these stops. The [[minTransferTime]] must be sufficient to permit a typical rider to move
  *                        between the two stops, including buffer time to allow for schedule variance on each route.
  */
case class Transfer(fromStopId: StopId,
                    toStopId: StopId,
                    transferType: TransferType,
                    minTransferTime: Duration)

object Transfer {

  /**
    * Type of connection.
    */
  sealed trait TransferType

  /**
    * Recommended transfer point between two routes.
    */
  case object Recommended extends TransferType

  /**
    * Timed transfer point between two routes. The departing vehicle is expected to wait for the arriving one, with sufficient time for a passenger to transfer between routes.
    */
  case object TimedTransfer extends TransferType

  /**
    * This transfer requires a minimum amount of time between arrival and departure to ensure a connection.
    */
  case object TimeNeeded extends TransferType

  /**
    * Transfers are not possible between routes at this location.
    */
  case object NotPossible extends TransferType

}