package org.mkzh.polysolve;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantTest {
    @Test
    public void testStandard() {
        assertDoesNotThrow(() -> assertEquals(Collections.singletonList("48.768147345"), Polysolve.solve("sin(3)+25*2+3/tan(2)", "x", 12)));
    }
}
