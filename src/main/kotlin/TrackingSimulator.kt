import java.io.File
import java.io.InputStream
import kotlinx.coroutines.delay


class TrackingSimulator {
    companion object TrackingSimulatorObject{
        private var shipments = mutableMapOf<String, Shipment>()

        suspend fun runSimulation() {
            val stream: InputStream = File("test.txt").inputStream()
            val lines = mutableListOf<String>()

            stream.bufferedReader().forEachLine { lines.add(it) }
            lines.forEach{
                println(it)
                val item = it.split(",")
                if (item[0] == "created") { addShipment(CreatedUpdate(item[1], item[2].toLong()).newShipment) }
                else if (item[0] == "shipped") { findShipment(item[1])?.let { it1 -> ShippedUpdate(it1, item[2].toLong(), item[3].toLong()) }}
                else if (item[0] == "location") {findShipment(item[1])?.let { it1 -> LocationUpdate(it1, item[2].toLong(), item[3]) }}
                else if (item[0] == "delivered") { findShipment(item[1])?.let { it1 -> DeliveredUpdate(it1, item[2].toLong()) } }
                else if (item[0] == "delayed") { findShipment(item[1])?.let { it1 -> DelayedUpdate(it1, item[2].toLong(), item[3].toLong()) } }
                else if (item[0] == "lost") { findShipment(item[1])?.let { it1 -> LostUpdate(it1, item[2].toLong())} }
                else if (item[0] == "canceled") { findShipment(item[1])?.let { it1 -> CanceledUpdate(it1, item[2].toLong())} }
                else if (item[0] == "notedadded") { findShipment(item[1])?.let { it1 -> NoteAddedUpdate(it1, item[2].toLong(), item[3])} }
                else { println( "Not found") }

                if(findShipment(item[1]) == null){
                    println("Shipment Added")
                } else {
                    println("Shipment Found")
                }


                delay(1000)
            }
        }

        fun findShipment(id: String): Shipment?{
            return shipments.get(id)
        }
        fun addShipment(shipment: Shipment) { shipments.put(shipment.id, shipment) }
    }
}