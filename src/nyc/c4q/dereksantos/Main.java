package nyc.c4q.dereksantos;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] myArray = {5, 10, 15, 20, 25};

        Random random = new Random();
        int randomNum = random.nextInt(myArray.length);

        System.out.println("Randomly Selected Number:\n" + myArray[randomNum]);

        System.out.println("Target Number's Index in Array:\n" + binarySearch(myArray, myArray[randomNum], 0, myArray.length - 1));
        System.out.println("Target Number's Index in Array:\n" + binarySearchAlt(myArray, myArray[randomNum]));
    }

    private static int binarySearch(int[] myArray, int target, int min, int max) {
        if (max < min) return -1;
        int guess = (max + min) / 2;
        if (myArray[guess] == target) {
            return guess;
        } else if (myArray[guess] < target) {
            min = guess + 1;
            return binarySearch(myArray, target, min, max);
        } else {
            max = guess - 1;
            return binarySearch(myArray, target, min, max);
        }
    }

    private static int binarySearchAlt(int[] myArray, int target) {
        int min = 0;
        int max = myArray.length - 1;
        while (max >= min) {
            int guess = (max + min) / 2;
            if (myArray[guess] == target) return guess;
            if (myArray[guess] < target) {
                min = guess + 1;
            } else {
                max = guess - 1;
            }
        }
        return -1;
    }
}

