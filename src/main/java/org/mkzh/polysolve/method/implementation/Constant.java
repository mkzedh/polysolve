package org.mkzh.polysolve.method.implementation;

import ch.obermuhlner.math.big.BigComplex;
import org.mkzh.polysolve.method.Method;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

public class Constant extends Method {
    @Override
    public List<BigComplex> solve(List<BigDecimal> coefficients, MathContext mathContext) {
        return coefficients.stream().map(BigComplex::valueOf).collect(Collectors.toList());
    }
}
