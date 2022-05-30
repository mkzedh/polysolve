package org.mkzh.polysolve.util;

import ch.obermuhlner.math.big.BigComplex;
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

    public static BigDecimal cubeRoot(BigDecimal val, MathContext mathContext) {
        boolean neg = BigNumber.isNegative(val);
        BigDecimal res = BigDecimalMath.root(neg ? val.negate() : val, BigDecimal.valueOf(3), mathContext);
        return neg ? res.negate() : res;
    }

    private static int compareToZero(BigDecimal val) {
        return val.compareTo(BigDecimal.ZERO);
    }
}
