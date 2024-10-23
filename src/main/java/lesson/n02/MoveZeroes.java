package lesson.n02;

import java.util.Arrays;

public final class MoveZeroes {

    private MoveZeroes() { }

    public static void moveZeroes(int[] numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                numbers[counter] = numbers[i];
                counter++;
            }
        }
        while (counter < numbers.length) {
            numbers[counter] = 0;
            counter++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }
}
