package homeworks.semester3.homework3.task1.models

interface Automate {

    val parking: Parking

    fun addCar(): Boolean

    fun removeCar()
}
