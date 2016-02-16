package com.evolutionnext.fivejvmlanguages;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Lambdas {
    public static void main(String[] args) {
       out.println(Arrays.asList(1, 2, 3, 4).stream()
                .filter(i -> i % 2 != 0)
                .collect(Collectors.toList()));
    }
}
