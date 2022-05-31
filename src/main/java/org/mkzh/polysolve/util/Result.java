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
        }).distinct().collect(Collectors.toList());
    }

    private static BigDecimal stripTrailingZerosAndRound(BigDecimal val, MathContext mathContext) {
        return isZeroBasedOnPrecision(val, mathContext) ? BigDecimal.ZERO : val.round(mathContext).stripTrailingZeros();
    }


    private static boolean isZeroBasedOnPrecision(BigDecimal val, MathContext mathContext) {
        return val.abs().compareTo(BigDecimal.valueOf(10).pow(mathContext.getPrecision() * -1, mathContext)) < 0;
    }
}
