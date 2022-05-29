package org.mkzh.polysolve;

import org.junit.jupiter.api.Test;
import org.mkzh.polysolve.util.Equation;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCoefficientsTest {
    @Test
    public void testQuartic() {
        assertDoesNotThrow(() -> {
            assertEquals(Arrays.asList("(-34)", "5*1", "(-2)*1", "5*1", "29*1"), Equation.getCoefficientsFromEquation("29x^4+5x^3-2x^2+5x-34", "x"));
        });
    }

    @Test
    public void testCubic() {
        assertDoesNotThrow(() -> {
            assertEquals(Arrays.asList("(-34)", "5*1", "(-2)*1", "5*1", null), Equation.getCoefficientsFromEquation("5x^3-2x^2+5x-34", "x"));
        });
    }

    @Test
    public void testQuadratic() {
        assertDoesNotThrow(() -> {
            assertEquals(Arrays.asList("(-64)", "(-20)*1", "(-3)*1", null, null), Equation.getCoefficientsFromEquation("-3x^2-20x-64", "x"));
        });
    }

    @Test
    public void testLinear() {
        assertDoesNotThrow(() -> {
            assertEquals(Arrays.asList("(-64)", "1*(-20)", null, null, null), Equation.getCoefficientsFromEquation("-20x-64", "x"));
        });
    }

    @Test
    public void testLinearWithExponentSign() {
        assertDoesNotThrow(() -> {
            assertEquals(Arrays.asList("(-64)", "1*(-20)", null, null, null), Equation.getCoefficientsFromEquation("-20x^1-64", "x"));
        });
    }

    @Test
    public void testLinearAdvanced() {
        assertDoesNotThrow(() -> {
            assertEquals(Arrays.asList("((-18/7))", "1*(23/7)", null, null, null), Equation.getCoefficientsFromEquation("4x+2=(5x+32)/7", "x"));
        });
    }


    @Test
    public void testConstant() {
        assertDoesNotThrow(() -> {
            assertEquals(Arrays.asList("-64", null, null, null, null), Equation.getCoefficientsFromEquation("-64", "x"));
        });
    }

    @Test
    public void testNonXVariable() {
        assertDoesNotThrow(() -> {
            assertEquals(Arrays.asList("(-34)", "5*1", "(-2)*1", "5*1", "29*1"), Equation.getCoefficientsFromEquation("29u^4+5u^3-2u^2+5u-34", "u"));
        });
    }
}
