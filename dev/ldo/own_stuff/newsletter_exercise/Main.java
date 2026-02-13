package dev.ldo.own_stuff.newsletter_exercise;

import java.io.IO;

public class Main {
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber(new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10});
        IO.println(missingNumber.missingNum());

    }
}
