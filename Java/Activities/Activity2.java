package Activities;
import java.util.*;
public class Activity2 {
    public static void main(String[] args) {
        int[] numArray = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(numArray));
        int searchNum = 10;
        int expectedSum = 30;
        System.out.println("Result: " + result(numArray, searchNum, expectedSum));
    }
    public static boolean result(int[] numbers, int searchNum, int fixedSum) {
        int sum = 0;
        for (int number : numbers) {
            if (number == searchNum) {
                sum += searchNum;
            }
            if (sum > fixedSum) {
                break;
            }
        }
        return sum == fixedSum;
    }
}