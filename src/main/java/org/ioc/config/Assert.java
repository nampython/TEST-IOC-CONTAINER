package org.ioc.config;

import java.util.List;

public class Assert {
    public static void that(String input, boolean expression, String output) {
        if (!expression) {
            throw new AssertionError(String.format("Failed: %s \n %s ", input, output));
        }

        System.out.println("    Passed: " + input);
    }
    public static void equal(String input, Object o1, Object o2, String output) {
        boolean equal = o1.equals(o2);

        if (!equal) {
            output += String.format("\n Expected: '%s', got: '%s '", o1, o2);
        }

        Assert.that(input, equal, output);
    }
    public static <T> void equal(String testing, List<T> col1, List<T> col2, String msg) {
        boolean eq = col1.containsAll(col2) && col2.containsAll(col1);
        if (!eq) {
            msg += String.format("Expected collection (%s) to equal (%s).", col1, col2);
        }

        Assert.that(testing, eq, msg);
    }
    public static void isNull(String testing, Object o, String msg) {
        Assert.that(testing, o == null, msg);
    }

    public static void notEqual(String testing, Object o1, Object o2, String msg) {
        boolean notEqual = !o1.equals(o2);

        if (!notEqual) {
            msg += String.format("Expected different value than: '%s'", o1);
        }

        Assert.that(testing, notEqual, msg);
    }
    public static void notNull(String testing, Object o, String msg) {
        Assert.that(testing, o != null, msg);
    }
}
