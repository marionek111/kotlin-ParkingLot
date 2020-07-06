package parking

class ParkingLot(places: Int) {
    private val spots = Array<Car?>(places) { null }

    fun park(car: Car): Int {
        val spot = 1 + spots.indexOfFirst { it == null }
        return if (spot > 0) {
            spots[spot - 1] = car
            spot
        } else {
            0
        }
    }

    fun leave(spot: Int): Boolean {
        return if (spots[spot - 1] != null) {
            spots[spot - 1] = null
            true
        } else {
            false
        }
    }

    fun carsByColor(color: String): List<Car> {
        return spots.filterIsInstance<Car>().filter { it.color.equals(color, true) }
    }

    fun spotsByColor(color: String): List<Int> {
        return spots.foldIndexed(MutableList(0) { 0 }) { index, list, car ->
            if (car?.color.equals(color, true)) {
                list.add(index + 1)
            }
            list
        }.toList()
    }

    fun spotByReg(registrationNr: String): Int {
        return spots.indexOfFirst { it?.registrationNr.equals(registrationNr) } + 1
    }

    fun status(): String {
        var status = ""
        for (placeId in spots.indices) {
            val spot = placeId + 1
            val car = spots[placeId]
            if (car is Car) {
                status += "$spot ${car.registrationNr} ${car.color}\n"
            }
        }
        return if (status.isNotEmpty()) {
            status.trim()
        } else {
            "Parking lot is empty."
        }
    }
}