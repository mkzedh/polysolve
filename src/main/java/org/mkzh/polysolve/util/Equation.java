package org.mkzh.polysolve.util;

import jas.core.Compiler;
import org.mkzh.polysolve.exception.EquationSyntaxException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Equation {
    public static List<BigDecimal> getCoefficientsFromEquation(String equation, String variable) throws EquationSyntaxException {
        String rootExpression = getRootExpression(equation);
        System.out.println(rootExpression);

        return Arrays.asList(new BigDecimal("2"));
    }

    private static String getRootExpression(String equation) throws EquationSyntaxException {
        String res = removeWhitespaces(equation);
        if (res.endsWith("=0")) {
            res = equation.substring(0, equation.length() - 2);
        } else if (res.contains("=")) {
            String[] expressions = equation.split("=");

            // exception if contains more than two expressions
            if (expressions.length > 2) {
                throw new EquationSyntaxException("Cannot have more than one = in equation");
            }

            if (expressions.length == 1) {
                // case when equation ends in =
                res = expressions[0];
            } else {
                // refactor equation to lhs - rhs
                res = String.format("%s-(%s)", expressions[0], expressions[1]);
            }
        }

        return simplifyExpression(res);
    }

    private static String simplifyExpression(String expression) {
        return Compiler.compile(expression).expand().simplify().toString();
    }

    private static String removeWhitespaces(String str) {
        return str.replaceAll("\\s+", "");
    }
}
