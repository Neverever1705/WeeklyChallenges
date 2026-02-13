package dev.ldo.own_stuff.newsletter_exercise;

public class MissingNumber {

    private int[] numbers;

    public MissingNumber(int[] numbers) {
        this.numbers = numbers;
    }

    public int missingNum() {
        int sum = 0;
        int checkValue = 55;
        if (numbers == null || numbers.length != 9) {
            return -1;
        }

        for (int number : numbers) {
            sum += number;
        }
        return checkValue - sum;
    }
}
