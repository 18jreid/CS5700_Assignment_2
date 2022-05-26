class NoteAddedUpdate(var shipment: Shipment, override var timeStamp: Long, var note: String) : ShippingUpdate{
    override var newStatus = shipment.status
    override var previousStatus = ""
    init{
        shipment.addNote(note)
    }
}