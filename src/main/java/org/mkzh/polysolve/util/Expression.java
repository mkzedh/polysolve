package org.mkzh.polysolve.util;

import jas.core.Compiler;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Expression {
    public static String simplify(String expression) {
        return Compiler.compile(translateForJASCompiler(expression)).expand().simplify().toString();
    }

    public static List<String> getTermsFromSimplifiedExpression(String expression) {
        return Arrays.asList(expression.split("(?<!\\([^(])\\+(?![)])"));
    }

    private static String translateForJASCompiler(String expression) {
        return abbreviateInverseTrigFunctions(expression);
    }

    private static String abbreviateInverseTrigFunctions(String expression) {
        return StringUtils.replaceEach(expression, new String[]{"arcsin", "arccos", "arctan", "arcsec", "arccot", "arccsc"},
                new String[]{"asin", "acos", "atan", "asec", "acot", "acsc"});
    }
}

