package dev.ldo.own_stuff.newsletter_exercise;

import java.util.ArrayList;
import java.util.List;

public class WhatGivesBadMood {
    private boolean goodMood;
    private String impact;


    private List<int[]> values = new ArrayList<>();

    public String greatestImpact(List<int[]> values) {
        int moodCount = 0;
        int weatherCount = 0;
        int mealsCount = 0;
        int sleepCount = 0;
        int totalCount = values.size();

        for (int i = 0; i < values.size(); i ++) {
            int[] array = values.get(i);
            moodCount += array[0];
            weatherCount += array[1];
            mealsCount += array[2];
            sleepCount += array[3];
        }

        double tmp = (double) moodCount / totalCount;
        if (tmp > 7.5){
            goodMood = true;
        } else
            goodMood = false;
        double weatherRatio = (double) weatherCount / (10 * totalCount);
        double mealRatio = (double) mealsCount / (3 * totalCount);
        double sleepRatio = (double) sleepCount / (10 * totalCount);
        double biggestImpact = Math.max(Math.max(weatherRatio, sleepRatio), mealRatio);
        double weakestImpact = Math.min(Math.min(weatherRatio,sleepRatio), mealRatio);

        if (goodMood) {
            if (biggestImpact == weatherRatio)
                impact = "Weather";
            else if (biggestImpact == mealRatio) {
                impact = "Meal";
            } else if (biggestImpact == sleepRatio) {
                impact = "Sleep";
            }
        } else {
            if (weakestImpact == weatherRatio)
                impact = "Weather";
            else if (weakestImpact == mealRatio) {
                impact = "Meal";
            } else if (weakestImpact == sleepRatio) {
                impact = "Sleep";
            }

        }

        System.out.printf("%d, %d, %d, %d -> Mood: %s, because of %s".formatted(moodCount, weatherCount, mealsCount, sleepCount,
                goodMood ? "good" : "bad", impact == null ? "Nothing" : impact));

        return null;
    }

}
