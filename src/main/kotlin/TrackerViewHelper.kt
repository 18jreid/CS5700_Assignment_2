import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TrackerViewHelper(id: String): Observer {
    var shipmentId by mutableStateOf("")
        private set;
    var shipmentTotes = mutableStateListOf<String>()
        private set;
    var shipmentUpdateHistory = mutableStateListOf<String>()
        private set;
    var expectedShipmentDeliveryDate = mutableStateListOf<String>()
        private set;
    var shipmentStatus by mutableStateOf("")
        private set;
    var numSecondsPassed by mutableStateOf(0)

    var shipment: Shipment = Shipment("created", id)
    init {
        shipment.addObserver(this)
    }

    override fun notify(numSecondsPassed: Int) {
        this.numSecondsPassed = numSecondsPassed
    }

    suspend fun start() {
        shipment.start()
    }

    fun stop() {
        shipment.stop()
    }
}