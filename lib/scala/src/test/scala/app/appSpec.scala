package app

import org.scalatest.funsuite.AnyFunSuite

class appSpec extends AnyFunSuite {

  test("amount 990 after surcharge needs approval") {
    assert(Main.approval("990"))
  }

  test("amount 500 does not need approval") {
    assert(!Main.approval("500"))
  }

  test("invalid amount throws exception") {
    assertThrows[NumberFormatException] {
      Main.approval("0x500")
    }
  }
}
