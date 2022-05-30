package org.mkzh.polysolve.util;

import java.math.BigDecimal;

public class BigNumber {
    public static boolean isNegative(BigDecimal val) {
        return compareToZero(val) < 0;
    }

    public static boolean isZero(BigDecimal val) {
        return val.equals(BigDecimal.ZERO);
    }

    private static int compareToZero(BigDecimal val) {
        return val.compareTo(BigDecimal.ZERO);
    }
}
