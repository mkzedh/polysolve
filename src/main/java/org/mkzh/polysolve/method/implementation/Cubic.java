package org.mkzh.polysolve.method.implementation;

import org.mkzh.polysolve.method.Method;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.List;

public class Cubic extends Method {
    @Override
    public List<BigDecimal> solve(List<BigDecimal> coefficients, MathContext mathContext) {
        return findRoots(coefficients.get(3), coefficients.get(2), coefficients.get(1), coefficients.get(0), mathContext);
    }

    private List<BigDecimal> findRoots(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d, MathContext mathContext) {
        return Arrays.asList(new BigDecimal("1"));
    }
}
