package org.mkzh.polysolve;

import org.mkzh.polysolve.exception.EquationSyntaxException;
import org.mkzh.polysolve.method.Cubic;
import org.mkzh.polysolve.method.Quadratic;
import org.mkzh.polysolve.method.Quartic;
import org.mkzh.polysolve.util.Coefficient;
import org.mkzh.polysolve.util.Equation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
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


        List<BigDecimal> results = coefficients.size() == 3 ? Quadratic.findRoots(coefficients.get(2), coefficients.get(1), coefficients.get(0), mathContext)
                : coefficients.size() == 4 ? Cubic.findRoots(coefficients.get(3), coefficients.get(2), coefficients.get(1), coefficients.get(0), mathContext)
                : coefficients.size() == 5 ? Quartic.findRoots(coefficients.get(4), coefficients.get(3), coefficients.get(2), coefficients.get(1), coefficients.get(0), mathContext)
                : Collections.emptyList();

        return results.stream().map(e -> e.round(new MathContext(precision))).collect(Collectors.toList());
    }
}