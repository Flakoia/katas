package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MorningRoutineShould {

    @Mock
    private TimeProvider timeProvider;

    private static Stream<Arguments> provideHoursAndExpectedSuggestions() {
        return Stream.of(
                Arguments.of("Do exercise", LocalTime.of(6, 0)),
                Arguments.of("Do exercise", LocalTime.of(6, 30)),
                Arguments.of("Do exercise", LocalTime.of(6, 59)),
                Arguments.of("Read and study", LocalTime.of(7, 0)),
                Arguments.of("Read and study", LocalTime.of(7, 30)),
                Arguments.of("Read and study", LocalTime.of(7, 59)),
                Arguments.of("Have breakfast", LocalTime.of(8, 0)),
                Arguments.of("Have breakfast", LocalTime.of(8, 30)),
                Arguments.of("Have breakfast", LocalTime.of(8, 59))
        );
    }

    @ParameterizedTest
    @MethodSource("provideHoursAndExpectedSuggestions")
    void displayWhatShouldIDoDependingOnHourOfDay(String expected, LocalTime hourOfTheDay) {
        when(timeProvider.getTime()).thenReturn(hourOfTheDay);
        MorningRoutine morningRoutine = new MorningRoutine(timeProvider);
        String activityNow = morningRoutine.whatShouldIdoNow();
        assertEquals(expected, activityNow);
    }

    @Test
    void displayReadAndStudyAt7h45() {
        when(timeProvider.getTime()).thenReturn(LocalTime.of(7, 45));
        MorningRoutine morningRoutine = new MorningRoutine(timeProvider);
        String activityNow = morningRoutine.whatShouldIdoNow();
        assertEquals("Read and study", activityNow);
    }

    @Test
    void displayDoExerciseAt6h45() {
        when(timeProvider.getTime()).thenReturn(LocalTime.of(6, 45));
        MorningRoutine morningRoutine = new MorningRoutine(timeProvider);
        String activityNow = morningRoutine.whatShouldIdoNow();
        assertEquals("Do exercise", activityNow);
    }


    @Test
    void displayHaveBreakfastAt7h45() {
        when(timeProvider.getTime()).thenReturn(LocalTime.of(8, 45));
        MorningRoutine morningRoutine = new MorningRoutine(timeProvider);
        String activityNow = morningRoutine.whatShouldIdoNow();
        assertEquals("Have breakfast", activityNow);
    }
}