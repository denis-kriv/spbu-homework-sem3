package homeworks.semester3.homework3.task1.models

import java.util.concurrent.atomic.AtomicInteger

class Parking(private val max: Int) {

    private var currentPlacesQuantity = AtomicInteger(0)

    fun newCar(): Boolean {
        return if (currentPlacesQuantity.get() < max) {
            currentPlacesQuantity.incrementAndGet()
            true
        } else false
    }

    fun register() {
        if (currentPlacesQuantity.get() <= 0) throw ArithmeticException("Parking is already empty.")

        currentPlacesQuantity.decrementAndGet()
    }

    fun getCurrentPlacesQuantity(): Int {
        return currentPlacesQuantity.get()
    }
}
