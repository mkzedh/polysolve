package org.mkzh.polysolve;

import org.mkzh.polysolve.exception.EquationSyntaxException;
import org.mkzh.polysolve.method.implementation.Cubic;
import org.mkzh.polysolve.method.implementation.Linear;
import org.mkzh.polysolve.method.implementation.Quadratic;
import org.mkzh.polysolve.method.implementation.Quartic;
import org.mkzh.polysolve.util.Coefficient;
import org.mkzh.polysolve.util.Equation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Polysolve {
    private static final int SUPPLEMENTARY_PRECISION = 25;

    public static List<BigDecimal> solve(String equation, String variable) throws EquationSyntaxException {
        // default precision = 64
        return solve(equation, variable, 64);
    }

    public static List<BigDecimal> solve(String equation, String variable, int precision) throws EquationSyntaxException {
        MathContext mathContext = new MathContext(precision + SUPPLEMENTARY_PRECISION);
        List<BigDecimal> coefficients = Coefficient.coefficientStringsToBigDecimal(Equation.getCoefficientsFromEquation(equation, variable), mathContext.getPrecision());


        List<BigDecimal> results = coefficients.size() == 1 ? coefficients
                : coefficients.size() == 2 ? new Linear().solve(coefficients, mathContext)
                : coefficients.size() == 3 ? new Quadratic().solve(coefficients, mathContext)
                : coefficients.size() == 4 ? new Cubic().solve(coefficients, mathContext)
                : coefficients.size() == 5 ? new Quartic().solve(coefficients, mathContext)
                : Collections.emptyList();

        return results.stream().map(e -> e.round(new MathContext(precision))).collect(Collectors.toList());
    }
}