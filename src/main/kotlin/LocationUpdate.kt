class LocationUpdate(var shipment: Shipment, override var timeStamp: Long, var newLocation: String) : ShippingUpdate{
    override var newStatus = shipment.status
    override var previousStatus = ""
    init{
        shipment.currentLocation = newLocation
    }
}