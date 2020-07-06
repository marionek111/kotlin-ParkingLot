package parking

class ParkingManager {
    private var parking: ParkingLot? = null
    private val notCreatedMsg = "Sorry, a parking lot has not been created."

    fun create(spots: Int): String {
        parking = ParkingLot(spots)
        return "Created a parking lot with $spots spots."
    }

    fun park(car: Car): String {
        return try {
            val spot = parking!!.park(car)
            if (spot >= 1) {
                "${car.color} car parked in spot $spot."
            } else {
                "Sorry, the parking lot is full."
            }
        } catch (ex: NullPointerException) {
            notCreatedMsg
        }
    }

    fun leave(spot: Int): String {
        return try {
            if (parking!!.leave(spot)) {
                "Spot $spot is free."
            } else {
                "There is no car in spot $spot."
            }
        } catch (ex: NullPointerException) {
            notCreatedMsg
        }
    }

    fun status(): String {
        return try {
            parking!!.status()
        } catch (ex: NullPointerException) {
            notCreatedMsg
        }
    }

    fun regByColor(color: String): String {
        return try {
            val cars = parking!!.carsByColor(color)
            if (cars.isNotEmpty()) {
                cars.joinToString { it.registrationNr }
            } else {
                "No cars with color $color were found."
            }
        } catch (ex: NullPointerException) {
            notCreatedMsg
        }
    }

    fun spotByColor(color: String): String {
        return try {
            val cars = parking!!.spotsByColor(color)
            if (cars.isNotEmpty()) {
                cars.joinToString()
            } else {
                "No cars with color $color were found."
            }
        } catch (ex: NullPointerException) {
            notCreatedMsg
        }
    }

    fun spotByReg(registrationNr: String): String {
        return try {
            val spot = parking!!.spotByReg(registrationNr)
            if (spot > 0) {
                spot.toString()
            } else {
                "No cars with registration number $registrationNr were found."
            }
        } catch (ex: NullPointerException) {
            notCreatedMsg
        }
    }
}