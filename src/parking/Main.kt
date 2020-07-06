package parking

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val manager = ParkingManager()

    loop@ while (true) {
        println(when (scanner.next()) {
            "create" -> manager.create(scanner.nextInt())
            "park" -> manager.park(Car(scanner.next(), scanner.next()))
            "leave" -> manager.leave(scanner.nextInt())
            "status" -> manager.status()
            "reg_by_color" -> manager.regByColor(scanner.next())
            "spot_by_color" -> manager.spotByColor(scanner.next())
            "spot_by_reg" -> manager.spotByReg(scanner.next())
            "exit" -> break@loop
            else -> "unknown command"
        })
    }
}
