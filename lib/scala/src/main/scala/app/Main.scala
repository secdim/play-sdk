package app

object Main {

  private val threshold: Int = 1000
  private val surcharge: Int = 10

  def main(args: Array[String]): Unit = {
    print("[?] Enter an amount (e.g. 10, 1000): ")
    val amount = scala.io.StdIn.readLine()

    if (approval(amount)) {
      println("[i] The amount requires approval")
    } else {
      println("[i] The amount does not require approval")
    }
  }

  /** Checks if a given amount requires approval.
    * Returns true if a given amount is bigger than a given threshold.
    */
  def approval(value: String): Boolean = {
    val amount = value.toInt + surcharge
    amount >= threshold
  }

}
