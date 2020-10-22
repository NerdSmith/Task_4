package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int selectedNumber = readNumber();
        int NNumber = getNIncreasingOrDecreasingNumber(selectedNumber);
        printResult(NNumber);
    }

    private static int getNumberOfDigits(int number) {
        int numberOfDigits = (number == 0) ? 1 : 0;
        while (number != 0) {
            number /=10;
            numberOfDigits++;
        }
        return numberOfDigits;
    }

    private static boolean areDigitsIncreasingOrDecreasing(int number) {
        int increasingCounter = 1;
        int decreasingCounter = 1;
        int numberOfDigits = getNumberOfDigits(number);

        if (numberOfDigits <= 2) {
            return true;
        }

        int lastDigit = number % 10;
        number /= 10;

        while (number != 0){
            if (lastDigit < number % 10) {
                decreasingCounter++;
            }
            else if (lastDigit > number % 10) {
                increasingCounter++;
            }

            lastDigit = number % 10;
            number /= 10;
        }

        return (increasingCounter == numberOfDigits) || (decreasingCounter == numberOfDigits);
    }

    public static int getNIncreasingOrDecreasingNumber(int selectedNumber) {
        int testNumber = 0;
        int rightNumbers = 0;

        while (rightNumbers < selectedNumber) {
            if (areDigitsIncreasingOrDecreasing(testNumber)) {
                rightNumbers++;
            }
            testNumber++;
            if (rightNumbers == selectedNumber) {
                testNumber--;
            }
        }
        return testNumber;
    }

    private static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        return scanner.nextInt();
    }

    private static void printResult(int n) {
        System.out.printf("n-th integer with increasing or decreasing digits: %d", n);
    }

}