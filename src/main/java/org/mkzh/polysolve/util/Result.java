package org.mkzh.polysolve.util;

import ch.obermuhlner.math.big.BigComplex;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    public static List<String> complexResultsToStrings(List<BigComplex> results, MathContext mathContext) {
        return results.stream().map(e -> {
            BigDecimal realRounded = stripTrailingZerosAndRound(e.re, mathContext);
            return e.isReal() ? realRounded.toString() : String.format("%s + %s*i", realRounded, stripTrailingZerosAndRound(e.im, mathContext));
        }).collect(Collectors.toList());
    }

    private static BigDecimal stripTrailingZerosAndRound(BigDecimal val, MathContext mathContext) {
        return val.stripTrailingZeros().round(mathContext);
    }
}
