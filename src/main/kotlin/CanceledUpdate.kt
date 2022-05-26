import java.time.Instant

class CanceledUpdate(var shipment: Shipment, override var timeStamp: Long) : ShippingUpdate{
    override var newStatus = "canceled"
    override var previousStatus = shipment.status
    init{
        shipment.status = newStatus
        shipment.addUpdate("Shipment went from $previousStatus to $newStatus at ${Instant.ofEpochMilli(timeStamp)}$"  )
    }
}