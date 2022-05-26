import java.time.Instant

interface ShippingUpdate {
    var previousStatus: String
    var newStatus: String
    var timeStamp: Long
}