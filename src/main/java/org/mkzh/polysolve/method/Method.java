package org.mkzh.polysolve.method;

import ch.obermuhlner.math.big.BigComplex;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public abstract class Method {
    public abstract List<BigComplex> solve(List<BigDecimal> coefficients, MathContext mathContext);
}
