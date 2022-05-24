class Shipment {
    var status: String = ""
        private set;
    var id: String = ""
        private set;
    var notes: List<String> = listOf()
        private set;
    var updateHistory: List<ShipmentUpdate> = listOf()
        private set;
    var expectedDeliveryDateTimeStamp: Long = 0L
        private set;
    var currentLocation: String = ""
        private set;

    fun addNote(note: String) {

    }

    fun addUpdate(update: ShipmentUpdate) {

    }
}