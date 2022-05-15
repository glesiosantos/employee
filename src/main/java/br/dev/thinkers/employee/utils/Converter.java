package br.dev.thinkers.employee.utils;

import org.springframework.util.NumberUtils;

import java.math.BigDecimal;

public class Converter {

    public static BigDecimal convertStringToBigDecimal(String value) {
        return NumberUtils
                .parseNumber(value.replace(".","").replace(",","."), BigDecimal.class);
    }
}
