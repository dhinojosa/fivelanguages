package com.evolutionnext.fivejvmlanguages;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsingPredicate {

    public static <T> List<T> myFilter (List<T> items,
                       MyPredicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t:items) {
            if (predicate.apply(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> original = Arrays.asList(3,4,6,7,3,1,6,10);
        List<Integer> result = myFilter(original,
                integer -> integer % 2 == 0);
        System.out.println("result = " + result);
    }
}
