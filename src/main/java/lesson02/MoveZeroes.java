package lesson02;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int counter = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        while(counter < nums.length)
        {
            nums[counter] = 0;
            counter++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }
}
