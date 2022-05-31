package org.mkzh.polysolve.util;

import ch.obermuhlner.math.big.BigComplex;
import ch.obermuhlner.math.big.BigComplexMath;
import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigNumber {
    public static boolean isNegative(BigDecimal val) {
        return compareToZero(val) < 0;
    }

    public static boolean isZero(BigDecimal val) {
        return val.equals(BigDecimal.ZERO);
    }

    public static BigComplex possiblyImaginarySquareRoot(BigDecimal val, MathContext mathContext) {
        boolean neg = isNegative(val);
        BigDecimal res = BigDecimalMath.sqrt(neg ? val.negate() : val, mathContext);
        return neg ? BigComplex.valueOf(res).multiply(BigComplex.I) : BigComplex.valueOf(res);
    }

    public static BigComplex cubeRoot(BigComplex val, MathContext mathContext) {
        return val.equals(BigComplex.ZERO) ? BigComplex.ZERO : BigComplexMath.root(val, BigDecimal.valueOf(3), mathContext);
    }

    private static int compareToZero(BigDecimal val) {
        return val.compareTo(BigDecimal.ZERO);
    }
}
