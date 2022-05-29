package org.mkzh.polysolve;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearTest {
    @Test
    public void testStandard() {
        assertDoesNotThrow(() -> assertEquals(Collections.singletonList(new BigDecimal("-0.125")), Polysolve.solve("8x+1", "x")));
    }
}
