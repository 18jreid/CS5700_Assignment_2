class CreatedUpdate(var id: String, override var timeStamp: Long) : ShippingUpdate{
    override var newStatus = "created"
    override var previousStatus = ""
    var newShipment = Shipment(newStatus, id)
        private set;

}