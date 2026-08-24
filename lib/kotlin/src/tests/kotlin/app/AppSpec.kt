package app

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows

@DisplayName("Usability unit tests")
class AppSpec {

    @Test
    fun test_amount_after_surcharge_needs_approval() {
        assertTrue(Main().approval("990"))
    }

    @Test
    fun test_amount_does_not_need_approval() {
        assertFalse(Main().approval("500"))
    }

    @Test
    fun test_invalid_amount_throws_exception() {
        assertThrows(NumberFormatException::class.java) {
            Main().approval("0x500")
        }
    }
}
