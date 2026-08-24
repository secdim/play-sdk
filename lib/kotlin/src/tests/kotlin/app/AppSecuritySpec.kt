package app

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows

@DisplayName("Security tests")
@Tag("security")
class AppSecuritySpec {

    @Test
    fun test_amount_bigger_than_int_max_throws_exception() {
        assertThrows(NumberFormatException::class.java) {
            Main().approval("2147483648")
        }
    }

    @Test
    fun test_amount_less_than_int_min_throws_exception() {
        assertThrows(NumberFormatException::class.java) {
            Main().approval("-2147483649")
        }
    }
}
