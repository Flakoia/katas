package org.example;

public class FizzBuzz {
    public static final int FIZZ_DIVISOR = 3;
    public static final int BUZZ_DIVISOR = 5;
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public String convert(int input) {
        if(isAMultipleOf(input, FIZZ_DIVISOR) && isAMultipleOf(input, BUZZ_DIVISOR)) {
            return FIZZ + BUZZ;
        }
        if(isAMultipleOf(input, FIZZ_DIVISOR)) {
            return FIZZ;
        }
        if(isAMultipleOf(input, BUZZ_DIVISOR)) {
            return BUZZ;
        }
        return String.valueOf(input);
    }

    private static boolean isAMultipleOf(int input, int multiplier) {
        return input % multiplier == 0;
    }
}
