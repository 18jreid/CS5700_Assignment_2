import java.time.Instant

class DelayedUpdate(var shipment: Shipment, override var timeStamp: Long, var newExpected: Long) : ShippingUpdate{
    override var newStatus = "delayed"
    override var previousStatus = shipment.status
    init{
        shipment.status = newStatus
        shipment.addUpdate("Shipment went from $previousStatus to $newStatus at ${Instant.ofEpochMilli(timeStamp)}$")
        shipment.expectedDeliveryDateTimeStamp = newExpected
    }
}