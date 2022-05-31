package org.mkzh.polysolve;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearTest {
    @Test
    public void testStandard() {
        assertDoesNotThrow(() -> assertEquals(Arrays.asList("-0.125"), Polysolve.solve("8x+1", "x")));
    }
}
