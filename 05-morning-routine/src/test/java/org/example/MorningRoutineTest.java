package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MorningRoutineTest {

    @Mock
    private TimeProvider timeProvider;

    @Test
    void display_Do_exercise_between_6_and_6_59() {
        MorningRoutine morningRoutine = new MorningRoutine(timeProvider);
        String activityNow = morningRoutine.whatShouldIdoNow();
        assertEquals("Do exercise", activityNow);
    }

}