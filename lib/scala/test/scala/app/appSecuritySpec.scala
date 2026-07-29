package app

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.Tag

object Security extends Tag("app.tags.Security")

class appSecuritySpec extends AnyFunSuite {

  test("amount bigger than Int.MaxValue throws exception", Security) {
    assertThrows[NumberFormatException] {
      Main.approval("2147483648")
    }
  }

  test("amount less than Int.MinValue throws exception", Security) {
    assertThrows[NumberFormatException] {
      Main.approval("-2147483648")
    }
  }

  test("negative amount throws exception", Security) {
    assertThrows[IllegalArgumentException] {
      Main.approval("-1")
    }
  }

  test("zero amount throws exception", Security) {
    assertThrows[IllegalArgumentException] {
      Main.approval("0")
    }
  }

  test("null amount throws exception", Security) {
    assertThrows[NullPointerException] {
      Main.approval(null)
    }
  }
}
