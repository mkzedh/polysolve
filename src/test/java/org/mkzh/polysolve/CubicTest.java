package org.mkzh.polysolve;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubicTest {
    @Test
    public void threeRealSolutions() {
        assertDoesNotThrow(() -> assertEquals(Arrays.asList("-1.24697960372", "0.445041867913", "1.8019377358"),
                Polysolve.solve("x^3-x^2-2x+1", "x", 12)));
    }

    @Test
    public void twoRealSolutions() {
        assertDoesNotThrow(() -> assertEquals(Arrays.asList("-3", "0"),
                Polysolve.solve("x^3+3x^2", "x", 12)));
    }

    @Test
    public void oneRealSolution() {
        assertDoesNotThrow(() -> assertEquals(
                Arrays.asList("-1.44224957031", "0.721124785154 + 1.24902476648*i", "0.721124785154 + -1.24902476648*i"),
                Polysolve.solve("x^3+3", "x", 12)));
    }

    @Test
    public void oneSolution() {
        assertDoesNotThrow(() -> assertEquals(Arrays.asList("0"),
                Polysolve.solve("x^3", "x", 12)));
    }
}
