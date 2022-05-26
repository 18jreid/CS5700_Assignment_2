class TrackingSimulator {
    private var shipments = mutableListOf<Shipment>()
    var shipment0 = Shipment("created", "s10000", updateHistory = mutableListOf(""), expectedDeliveryDateTimeStamp = 1652712855468L)
    var shipment1 = Shipment("created", "s10001", updateHistory = mutableListOf(""), expectedDeliveryDateTimeStamp = 1652712855468L)

    init {

    }

    fun findShipment(id: String) {}

    fun addShipment(shipment: Shipment) {}

    fun runSimulation() {}
}