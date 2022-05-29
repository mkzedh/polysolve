package org.mkzh.polysolve.util;

import org.mkzh.polysolve.exception.EquationSyntaxException;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Term {
    public static List<String> getCoefficientsFromTerms(List<String> terms, String baseVariable) throws EquationSyntaxException {
        // initialise a list to store up to 5 coefficients (for solving up to quartics)
        List<String> coefficients = Arrays.asList(new String[5]);
        Map<String, Integer> exponentVariableToIndex = new LinkedHashMap<>() {{
            put(baseVariable.concat("^4"), 4);
            put(baseVariable.concat("^3"), 3);
            put(baseVariable.concat("^2"), 2);
            put(baseVariable.concat("^1"), 1);
        }};

        for (String term : terms) {
            boolean hasCoefficient = getConstantCoefficient(coefficients, baseVariable, term)
                    || getLinearVariableCoefficient(coefficients, baseVariable, term)
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

    private static boolean getLinearVariableCoefficient(List<String> coefficients, String variable, String term) throws EquationSyntaxException {
        if (term.contains(variable) && !term.contains(variable.concat("^"))) {
            updateCoefficientsList(coefficients, term, variable, 1);
            return true;
        }
        return false;
    }

    private static boolean getConstantCoefficient(List<String> coefficients, String baseVariable, String term) throws EquationSyntaxException {
        if (!term.contains(baseVariable)) {
            updateCoefficientsList(coefficients, term, "", 0);
            return true;
        }

        return false;
    }

    private static void updateCoefficientsList(List<String> coefficients, String term, String variable, int index) throws EquationSyntaxException {
        if (coefficients.get(index) != null) {
            throwPolynomialSimplificationException();
        }

        // if coefficient is constant, set coefficient as term
        coefficients.set(index, variable.isEmpty() ? term : getCoefficientFromTerm(term, variable));
    }

    private static String getCoefficientFromTerm(String term, String variable) {
        return term.replace(variable, "1");
    }

    private static void throwPolynomialSimplificationException() throws EquationSyntaxException {
        throw new EquationSyntaxException("Equation cannot be simplified to solvable polynomial of degree 4 or less");
    }
}
