package org.mkzh.polysolve;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadraticTest {
    @Test
    public void testTwoRealSolutions() {
        assertDoesNotThrow(() -> assertEquals(Arrays.asList("-0.2", "-1"), Polysolve.solve("5x^2+6x+1", "x")));

        assertDoesNotThrow(() -> assertEquals(Arrays.asList("-0.42264973", "-1.5773503"), Polysolve.solve("3x^2+6x+2", "x", 8)));
    }

    @Test
    public void testOneRealSolution() {
        assertDoesNotThrow(() -> assertEquals(Arrays.asList("-2"), Polysolve.solve("x^2+4x+4", "x")));
    }

    @Test
    public void testNoRealSolution() {
        assertDoesNotThrow(() -> assertEquals(Arrays.asList("1.25 + -3.929058411*i", "1.25 + 3.929058411*i"), Polysolve.solve("-2x^2+5x-34", "x", 10)));
    }

    @Test
    public void testNoLinearTerm() {
        assertDoesNotThrow(() -> assertEquals(Arrays.asList("2", "-2"), Polysolve.solve("x^2-4", "x")));
    }
}
