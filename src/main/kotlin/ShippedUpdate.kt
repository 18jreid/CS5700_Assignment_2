import java.time.Instant

class ShippedUpdate(var shipment: Shipment, override var timeStamp: Long, var expectedArrival: Long) : ShippingUpdate{
    override var newStatus = "shipped"
    override var previousStatus = shipment.status
    init{
        shipment.status = newStatus
        shipment.addUpdate("Shipment went from $previousStatus to $newStatus at ${Instant.ofEpochMilli(timeStamp)}$"  )
        shipment.expectedDeliveryDateTimeStamp = expectedArrival
    }
}