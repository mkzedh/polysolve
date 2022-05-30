package org.mkzh.polysolve.method.implementation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ch.obermuhlner.math.big.BigDecimalMath;
import org.mkzh.polysolve.method.Method;

public class Quadratic extends Method {
    @Override
    public List<BigDecimal> solve(List<BigDecimal> coefficients, MathContext mathContext) {
        return findRoots(coefficients.get(2), coefficients.get(1), coefficients.get(0), mathContext);
    }

    private List<BigDecimal> findRoots(BigDecimal a, BigDecimal b, BigDecimal c, MathContext mathContext) {
        BigDecimal discriminant = b.pow(2).subtract(BigDecimal.valueOf(4).multiply(a).multiply(c));

        // check for negative discriminant
        if (isDiscriminantNegative(discriminant)) {
            return Collections.emptyList();
        }

        List<BigDecimal> roots = new ArrayList<>();
        roots.add(getQuadraticRoot(a, b, discriminant, true, mathContext));

        // do not attempt to find second solution when discriminant is 0
        if (isDiscriminantZero(discriminant)) {
            roots.add(getQuadraticRoot(a, b, discriminant, false, mathContext));
        }

        return roots;
    }

    private BigDecimal getQuadraticRoot(BigDecimal a, BigDecimal b, BigDecimal discriminant, boolean isFirstRoot, MathContext mathContext) {
        BigDecimal sqrtDiscriminant = BigDecimalMath.sqrt(discriminant, mathContext);
        if (!isFirstRoot) {
            sqrtDiscriminant = sqrtDiscriminant.negate();
        }

        return b.negate(mathContext).add(sqrtDiscriminant).divide(a.multiply(BigDecimal.valueOf(2)), mathContext);
    }

    private boolean isDiscriminantNegative(BigDecimal discriminant) {
        return discriminant.compareTo(BigDecimal.valueOf(0)) < 0;
    }

    private boolean isDiscriminantZero(BigDecimal discriminant) {
        return discriminant.compareTo(BigDecimal.valueOf(0)) != 0;
    }
}
