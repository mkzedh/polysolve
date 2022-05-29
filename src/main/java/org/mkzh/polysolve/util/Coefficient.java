package org.mkzh.polysolve.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import com.udojava.evalex.Expression;

public class Coefficient {
    public static List<BigDecimal> coefficientStringsToBigDecimal(List<String> coefficientStrings, int precision) {
        return coefficientStrings.stream().map(e -> new Expression(e).setPrecision(precision).eval()).collect(Collectors.toList());
    }
}
