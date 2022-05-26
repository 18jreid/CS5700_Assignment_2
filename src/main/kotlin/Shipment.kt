import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

class Shipment(status: String, id: String): Observable {
    var status: String = ""
    var id: String = ""
    var notes: MutableList<String> = mutableStateListOf()
        private set;
    var updateHistory: MutableList<String> = mutableStateListOf()
        private set;
    var expectedDeliveryDateTimeStamp: Long = 0L
    var currentLocation: String = ""

    private val observers = mutableListOf<Observer>()
    private var numSecondsPassed = 0
    private var isRunning = false
    init {
        this.status = status
        this.id = id
    }

    fun addNote(note: String) {
        this.notes.add(note)
    }

    fun addUpdate(update: String) {
        this.updateHistory.add(update)
    }

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    private fun notifyObservers() {
        observers.forEach { it.notify(numSecondsPassed)}
    }

    suspend fun start() {
        isRunning = true;
        while (isRunning) {
            delay(1000)
            numSecondsPassed += 1
            notifyObservers()
        }
    }

    fun stop() {
        isRunning = false
    }
}