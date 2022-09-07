package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Usability unit tests")
public class appSpec {

    @Test
    public void amount_1000_after_surcharge_needs_approval() {
        Main app = new Main();
        boolean res = app.approval("990");
        assertTrue(res,() -> "990 needs approval");
    }

    @Test
    public void amount_500_no_approval() {
        Main app = new Main();
        boolean res = app.approval("500");
        assertFalse(res,() -> "500 does not need approval");
    }

    @Test
    public void amount_invalid_throw_exception() {
        assertThrows(NumberFormatException.class, () -> {
            Main app = new Main();
            boolean res = app.approval("0x500");
        });
    }
}
