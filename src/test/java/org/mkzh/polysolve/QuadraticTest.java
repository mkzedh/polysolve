package org.mkzh.polysolve;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadraticTest {
    @Test
    public void testTwoSolutions() {
        assertDoesNotThrow(() -> assertEquals(Arrays.asList(new BigDecimal("-0.2"), new BigDecimal("-1.0")), Polysolve.solve("5x^2+6x+1", "x")));

        assertDoesNotThrow(() -> assertEquals(Arrays.asList(new BigDecimal("-0.42264973"), new BigDecimal("-1.5773503")), Polysolve.solve("3x^2+6x+2", "x", 8)));
    }

    @Test
    public void testOneSolution() {
        assertDoesNotThrow(() -> assertEquals(Collections.singletonList(new BigDecimal("-2")), Polysolve.solve("x^2+4x+4", "x")));
    }

    @Test
    public void testNoSolution() {
        assertDoesNotThrow(() -> assertEquals(Collections.emptyList(), Polysolve.solve("-2x^2+5x-34", "x")));
    }
}
