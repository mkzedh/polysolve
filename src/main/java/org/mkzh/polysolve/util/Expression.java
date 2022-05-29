package org.mkzh.polysolve.util;

import jas.core.Compiler;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Expression {
    public static String simplify(String expression) {
        return translateForEvalExLibrary(Compiler.compile(translateForJASCompiler(expression)).expand().simplify().toString());
    }

    public static List<String> getTermsFromSimplifiedExpression(String expression) {
        return Arrays.asList(expression.split("(?<!\\([^(])\\+(?![)])"));
    }

    private static String translateForJASCompiler(String expression) {
        return abbreviateInverseTrigFunctions(expression);
    }

    private static String translateForEvalExLibrary(String expression) {
        return makeTrigFunctionsRadian(expression);
    }

    private static String abbreviateInverseTrigFunctions(String expression) {
        return StringUtils.replaceEach(expression, new String[]{"arcsin", "arccos", "arctan", "arccot", "arcsec", "arccsc"},
                new String[]{"asin", "acos", "atan", "acot", "asec", "acsc"});
    }

    private static String makeTrigFunctionsRadian(String expression) {
        return StringUtils.replaceEach(expression, new String[]{"sin", "cos", "tan", "cot", "sec", "csc", "asin", "acos", "atan", "acot", "asec", "acsc"},
                new String[]{"sinr", "cosr", "tanr", "cotr", "secr", "cscr", "asinr", "acosr", "atanr", "acotr", "asecr", "acscr"});
    }
}

