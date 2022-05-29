package org.mkzh.polysolve.method;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public abstract class Method {
    public abstract List<BigDecimal> solve(List<BigDecimal> coefficients, MathContext mathContext);
}
