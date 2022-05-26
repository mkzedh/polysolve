package org.mkzh.polysolve.util;

import org.mkzh.polysolve.exception.EquationSyntaxException;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Term {
    public static List<String> getCoefficientsFromTerms(List<String> terms) throws EquationSyntaxException {
        // initialise a list to store up to 5 coefficients (for solving up to quartics)
        List<String> coefficients = Arrays.asList(new String[5]);
        Map<String, Integer> exponentVariableToIndex = new LinkedHashMap<>() {{
            put("x^4", 4);
            put("x^3", 3);
            put("x^2", 2);
            put("x^1", 1);
        }};

        for (String term : terms) {
            boolean hasCoefficient = getConstantCoefficient(coefficients, term)
                    || getLinearVariableCoefficient(coefficients, term)
                    || getExponentVariableCoefficients(coefficients, term, exponentVariableToIndex);

            if (!hasCoefficient) {
                throwPolynomialSimplificationException();
            }
        }

        return coefficients;
    }

    private static boolean getExponentVariableCoefficients(List<String> coefficients, String term, Map<String, Integer> indexMap) throws EquationSyntaxException {
        for (Map.Entry<String, Integer> entry : indexMap.entrySet()) {
            if (term.contains(entry.getKey())) {
                updateCoefficientsList(coefficients, term, entry.getKey(), entry.getValue());
                return true;
            }
        }
        return false;
    }

    private static boolean getLinearVariableCoefficient(List<String> coefficients, String term) throws EquationSyntaxException {
        if (term.contains("x") && !term.contains("x^")) {
            updateCoefficientsList(coefficients, term, "x", 1);
            return true;
        }
        return false;
    }

    private static boolean getConstantCoefficient(List<String> coefficients, String term) throws EquationSyntaxException {
        if (!term.contains("x")) {
            updateCoefficientsList(coefficients, term, "", 0);
            return true;
        }

        return false;
    }

    private static void updateCoefficientsList(List<String> coefficients, String term, String variable, int index) throws EquationSyntaxException {
        if (coefficients.get(index) != null) {
            throwPolynomialSimplificationException();
        }
        coefficients.set(index, getCoefficientFromTerm(term, variable));
    }

    private static String getCoefficientFromTerm(String term, String variable) {
        if (variable.isEmpty()) {
            // constant term
            return term;
        }

        return term.replace(variable, "1");
    }

    private static void throwPolynomialSimplificationException() throws EquationSyntaxException {
        throw new EquationSyntaxException("Equation cannot be simplified to solvable polynomial");
    }
}
