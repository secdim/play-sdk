package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Security unit tests")
@Tag("security")
public class appSecuritySpec {

    @Test
    public void amount_bigger_than_IntMax_throw_exception() {
        assertThrows(ArithmeticException.class, () -> {
            Main app = new Main();
            boolean res = app.approval("2147483648");
        });
    }

    @Test
    public void amount_less_than_IntMin_throw_exception() {
        assertThrows(ArithmeticException.class, () -> {
            Main app = new Main();
            boolean res = app.approval("-2147483648");
        });
    }

    //@Test
    //public void amount_bigger_than_IntMax_after_surcharge_throw_exception() {
    //    assertThrows(ArithmeticException.class, () -> {
    //        Main app = new Main();
    //        //FIX ME
    //    });
    //}

    @Test
    public void amount_negative_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            Main app = new Main();
            boolean res = app.approval("-1");
        });
    }

    @Test
    public void amount_zero_throw_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            Main app = new Main();
            boolean res = app.approval("0");
        });
    }

    @Test
    public void amount_null_throw_exception() {
        assertThrows(NullPointerException.class, () -> {
            Main app = new Main();
            boolean res = app.approval(null);
        });
    }
}
