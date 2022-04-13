package utils;

public class NumberUtils {

    public static boolean isEven(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Only for positive numbers");
        }
        return number % 2 == 0;
    }

    public static int numberOfDigits(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Only for positive numbers");
        }
        int counter = 0;
        while(number != 0){
            counter++;
            number /= 10;
        }
        return counter;
    }

}
