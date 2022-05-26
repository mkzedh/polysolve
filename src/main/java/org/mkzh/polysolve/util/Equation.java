package org.mkzh.polysolve.util;

import org.mkzh.polysolve.exception.EquationSyntaxException;

import java.util.List;

public class Equation {
    public static List<String> getCoefficientsFromEquation(String equation, String variable) throws EquationSyntaxException {
        String rootExpression = getSimplifiedRootExpression(equation);
        List<String> terms = Expression.getTermsFromSimplifiedExpression(rootExpression);
        List<String> coefficients = Term.getCoefficientsFromTerms(terms);

        return coefficients;
    }

    private static String getSimplifiedRootExpression(String equation) throws EquationSyntaxException {
        String res = Common.removeWhitespaces(equation);
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

        return Expression.simplify(res);
    }




}
