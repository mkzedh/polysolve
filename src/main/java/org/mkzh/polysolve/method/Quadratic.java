package org.mkzh.polysolve.method;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ch.obermuhlner.math.big.BigDecimalMath;

public class Quadratic {
    public static List<BigDecimal> findRoots(BigDecimal a, BigDecimal b, BigDecimal c, MathContext mathContext) {
        BigDecimal discriminant = BigDecimalMath.pow(b, 2, mathContext).subtract(BigDecimal.valueOf(4).multiply(a).multiply(c));

        // check for negative discriminant
        if (discriminant.compareTo(BigDecimal.valueOf(0)) < 0) {
            return Collections.emptyList();
        }

        List<BigDecimal> roots = new ArrayList<>();
        roots.add(getQuadraticRoot(a, b, discriminant, true, mathContext));

        // do not attempt to find second solution when discriminant is 0
        if (discriminant.compareTo(BigDecimal.valueOf(0)) != 0) {
            roots.add(getQuadraticRoot(a, b, discriminant, false, mathContext));
        }

        return roots;
    }

    private static BigDecimal getQuadraticRoot(BigDecimal a, BigDecimal b, BigDecimal discriminant, boolean isFirstRoot, MathContext mathContext) {
        BigDecimal sqrtDiscriminant = BigDecimalMath.sqrt(discriminant, mathContext);
        if (!isFirstRoot) {
            sqrtDiscriminant = sqrtDiscriminant.negate();
        }

        return b.negate(mathContext).add(sqrtDiscriminant).divide(a.multiply(BigDecimal.valueOf(2)), mathContext);
    }
}
