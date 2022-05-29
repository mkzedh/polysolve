package org.mkzh.polysolve.method.implementation;

import org.mkzh.polysolve.method.Method;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.List;

public class Linear extends Method {
    @Override
    public List<BigDecimal> solve(List<BigDecimal> coefficients, MathContext mathContext) {
        return Arrays.asList(new BigDecimal("1"));
    }
}
