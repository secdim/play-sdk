package app

class Main {

    private val threshold = 1000
    private val surcharge = 10

    /**
     * Checks if a given amount requires approval.
     * Returns true if a given amount is bigger than a given threshold.
     */
    fun approval(value: String): Boolean {
        val amount = value.toInt() + surcharge
        return amount >= threshold
    }
}

fun main() {
    val app = Main()
    print("[?] Enter an amount (e.g. 10, 1000): ")
    val amount = readlnOrNull() ?: return

    if (app.approval(amount)) {
        println("[i] The amount requires approval")
    } else {
        println("[i] The amount does not require approval")
    }
}
