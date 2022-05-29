package org.mkzh.polysolve.method.implementation;

import org.mkzh.polysolve.method.Method;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.List;

public class Linear extends Method {
    @Override
    public List<BigDecimal> solve(List<BigDecimal> coefficients, MathContext mathContext) {
        return findRoot(coefficients.get(1), coefficients.get(0), mathContext);
    }

    private List<BigDecimal> findRoot(BigDecimal a, BigDecimal c, MathContext mathContext) {
        return Collections.singletonList(c.negate().divide(a, mathContext));
    }
}
