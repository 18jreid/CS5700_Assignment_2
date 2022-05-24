import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TrackerViewHelper {
    var shipmentId by mutableStateOf("")
    var shipmentTotes = mutableStateListOf<String>()
        private set;
    var shipmentUpdateHistory = mutableStateListOf<String>()
        private set;
    var expectedShipmentDeliveryDate = mutableStateListOf<String>()
        private set;
    var shipmentStatus by mutableStateOf("")
        private set;

    fun trackShipment() {

    }

    fun stopTracking() {

    }
}