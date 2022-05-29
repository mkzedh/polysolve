package org.mkzh.polysolve;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantTest {
    @Test
    public void testStandard() {
        assertDoesNotThrow(() -> assertEquals(Collections.singletonList(new BigDecimal("48.7681473450")), Polysolve.solve("sin(3)+25*2+3/tan(2)", "x", 12)));
    }
}
