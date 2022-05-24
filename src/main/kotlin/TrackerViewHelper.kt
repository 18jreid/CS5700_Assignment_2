import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class TrackerViewHelper {
    var shipmentId = remember { mutableStateOf("") }
        private set;
    var shipmentTotes = remember { mutableStateListOf<String>() }
        private set;
    var shipmentUpdateHistory = remember { mutableStateListOf<String>() }
        private set;
    var expectedShipmentDeliveryDate = remember { mutableStateListOf<String>() }
        private set;
    var shipmentStatus = remember { mutableStateOf("") }
        private set;

    fun trackShipment() {

    }

    fun stopTracking() {

    }
}