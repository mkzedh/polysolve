package org.mkzh.polysolve.method.implementation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.obermuhlner.math.big.BigComplex;
import ch.obermuhlner.math.big.BigDecimalMath;
import org.mkzh.polysolve.method.Method;
import org.mkzh.polysolve.util.BigNumber;

public class Quadratic extends Method {
    @Override
    public List<BigComplex> solve(List<BigDecimal> coefficients, MathContext mathContext) {
        return findRoots(coefficients.get(2), coefficients.get(1), coefficients.get(0), mathContext);
    }

    private List<BigComplex> findRoots(BigDecimal a, BigDecimal b, BigDecimal c, MathContext mathContext) {
        BigDecimal discriminant = b.pow(2).subtract(BigDecimal.valueOf(4).multiply(a).multiply(c));

        List<BigComplex> roots = new ArrayList<>();
        roots.add(getQuadraticRoot(a, b, discriminant, true, mathContext));

        // do not attempt to find second solution when discriminant is 0
        if (!isDiscriminantZero(discriminant)) {
            roots.add(getQuadraticRoot(a, b, discriminant, false, mathContext));
        }

        return roots;
    }

    private BigComplex getQuadraticRoot(BigDecimal a, BigDecimal b, BigDecimal discriminant, boolean isFirstRoot, MathContext mathContext) {
        BigComplex sqrtDiscriminant = BigNumber.possiblyImaginarySquareRoot(discriminant, mathContext);

        return (isFirstRoot ? sqrtDiscriminant : sqrtDiscriminant.negate()).subtract(b).divide(a.multiply(BigDecimal.valueOf(2)), mathContext);
    }

    private boolean isDiscriminantZero(BigDecimal discriminant) {
        return BigNumber.isZero(discriminant);
    }
}
