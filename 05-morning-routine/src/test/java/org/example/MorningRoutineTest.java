package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class MorningRoutineTest {

    @Mock
    private TimeProvider timeProvider;

    @Test
    void test_fail() {
        assertTrue(false);
    }

}