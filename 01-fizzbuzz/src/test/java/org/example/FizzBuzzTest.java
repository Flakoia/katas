package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FizzBuzzTest {

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void Given1_WhenFizzBuzzConvert_ThenIShouldGet1() {
        assertEquals("1", fizzBuzz.convert(1));
    }

    @Test
    void Given2_WhenFizzBuzzConvert_ThenIShouldGet2() {
        assertEquals("2", fizzBuzz.convert(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7, 8})
    void GivenAValidNumber_WhenFizzBuzzConvert_ThenIShouldGetTheSameNumber(int number) {
        assertEquals(String.valueOf(number), fizzBuzz.convert(number));
    }

    @Test
    void Given3_WhenFizzBuzzConvert_ThenIShouldGetFizz() {
        assertEquals("Fizz", fizzBuzz.convert(3));
    }

    @Test
    void Given6_WhenFizzBuzzConvert_ThenIShouldGetFizz() {
        assertEquals("Fizz", fizzBuzz.convert(6));
    }

    @Test
    void Given5_WhenFizzBuzzConvert_ThenIShouldGetBuzz() {
        assertEquals("Buzz", fizzBuzz.convert(5));
    }

    @Test
    void Given10_WhenFizzBuzzConvert_ThenIShouldGetBuzz() {
        assertEquals("Buzz", fizzBuzz.convert(10));
    }
    @Test
    void Given15_WhenFizzBuzzConvert_ThenIShouldGetFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.convert(15));
    }
    @Test
    void Given30_WhenFizzBuzzConvert_ThenIShouldGetFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.convert(30));
    }


    @Test
    void given0_whenConvert_thenReturnFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.convert(0));
    }

    @Test
    void givenNegativeNumber_whenConvert_thenReturnNumberAsString() {
        assertEquals("-1", fizzBuzz.convert(-1));
    }

    @Test
    void givenMaxInteger_whenConvert_thenReturnFizzBuzz() {
        assertEquals(String.valueOf(Integer.MAX_VALUE), fizzBuzz.convert(Integer.MAX_VALUE));
    }
}