package org.mkzh.polysolve;

import org.mkzh.polysolve.exception.EquationSyntaxException;
import org.mkzh.polysolve.method.Cubic;
import org.mkzh.polysolve.method.Quadratic;
import org.mkzh.polysolve.method.Quartic;
import org.mkzh.polysolve.util.Equation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Polysolve {
    private static final int SUPPLEMENTARY_PRECISION = 10;

    public static List<String> solve(String equation, String variable) throws EquationSyntaxException {
        // default precision = 64
        return solve(equation, variable, 64 + SUPPLEMENTARY_PRECISION);
    }

    public static List<String> solve(String equation, String variable, int precision) throws EquationSyntaxException {
        List<String> coefficientsAsString = Equation.getCoefficientsFromEquation(equation, variable);
        MathContext mathContext = new MathContext(precision + SUPPLEMENTARY_PRECISION);

//        List<BigDecimal> results = coefficients.size() == 3 ? Quadratic.findRoots(coefficients.get(0), coefficients.get(1), coefficients.get(2), mathContext)
//                : coefficients.size() == 4 ? Cubic.findRoots(coefficients.get(0), coefficients.get(1), coefficients.get(2), coefficients.get(3), mathContext)
//                : coefficients.size() == 5 ? Quartic.findRoots(coefficients.get(0), coefficients.get(1), coefficients.get(2), coefficients.get(3), coefficients.get(4), mathContext)
//                : Collections.emptyList();
//
//        return results.stream().map(BigDecimal::toString).collect(Collectors.toList());

        return Arrays.asList("");
    }
}