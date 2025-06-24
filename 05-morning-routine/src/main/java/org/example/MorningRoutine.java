package org.example;

import java.time.LocalTime;

public class MorningRoutine
{
    public static final String READ_AND_STUDY = "Read and study";
    public static final String DO_EXERCISE = "Do exercise";
    private static final String HAVE_BREAKFAST = "Have breakfast";
    public static final LocalTime READ_AND_STUDY_TIME = LocalTime.of(06, 59);
    public static final LocalTime DO_EXERCICE_TIME = LocalTime.of(5, 59);
    private static final LocalTime HAVE_BREAKFAST_TIME = LocalTime.of(7, 59);;
    private final TimeProvider timeProvider;

    public MorningRoutine(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String whatShouldIdoNow() {
        String activity = null;

        if(timeProvider.getTime().isAfter(HAVE_BREAKFAST_TIME)) {
            activity = HAVE_BREAKFAST;
        }  else if(timeProvider.getTime().isAfter(READ_AND_STUDY_TIME)) {
            activity = READ_AND_STUDY;
        } else if(timeProvider.getTime().isAfter(DO_EXERCICE_TIME)) {
            activity = DO_EXERCISE;
        }

        return activity;
    }

}
