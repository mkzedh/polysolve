package org.mkzh.polysolve.method.implementation;

import ch.obermuhlner.math.big.BigComplex;
import org.mkzh.polysolve.method.Method;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.List;

public class Quartic extends Method {
    @Override
    public List<BigComplex> solve(List<BigDecimal> coefficients, MathContext mathContext) {
        return findRoots(coefficients.get(4), coefficients.get(3), coefficients.get(2), coefficients.get(1), coefficients.get(0), mathContext);
    }

    private List<BigComplex> findRoots(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d, BigDecimal e, MathContext mathContext) {
        return Arrays.asList(BigComplex.valueOf(1));
    }
}
