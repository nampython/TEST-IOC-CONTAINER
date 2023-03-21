package org.ioc.config;

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
    public static void isNull(String testing, Object o, String msg) {
        Assert.that(testing, o == null, msg);
    }
}
