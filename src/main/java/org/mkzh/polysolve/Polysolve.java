package org.mkzh.polysolve;

import ch.obermuhlner.math.big.BigComplex;
import org.mkzh.polysolve.exception.EquationSyntaxException;
import org.mkzh.polysolve.method.implementation.*;
import org.mkzh.polysolve.util.Coefficient;
import org.mkzh.polysolve.util.Equation;
import org.mkzh.polysolve.util.Result;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.List;

public class Polysolve {
    private static final int DEFAULT_PRECISION = 64;
    private static final int SUPPLEMENTARY_PRECISION = 25;

    public static List<String> solve(String equation, String variable) throws EquationSyntaxException {
        return solve(equation, variable, DEFAULT_PRECISION);
    }

    public static List<String> solve(String equation, String variable, int precision) throws EquationSyntaxException {
        MathContext mathContext = new MathContext(precision + SUPPLEMENTARY_PRECISION);
        List<BigDecimal> coefficients = Coefficient.coefficientStringsToBigDecimal(Equation.getCoefficientsFromEquation(equation, variable), mathContext.getPrecision());


        List<BigComplex> results = coefficients.size() == 1 ? new Constant().solve(coefficients, mathContext)
                : coefficients.size() == 2 ? new Linear().solve(coefficients, mathContext)
                : coefficients.size() == 3 ? new Quadratic().solve(coefficients, mathContext)
                : coefficients.size() == 4 ? new Cubic().solve(coefficients, mathContext)
                : coefficients.size() == 5 ? new Quartic().solve(coefficients, mathContext)
                : Collections.emptyList();

        return Result.complexResultsToStrings(results, new MathContext(precision));
    }
}