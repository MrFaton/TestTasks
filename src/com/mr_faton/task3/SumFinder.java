package com.mr_faton.task3;

import java.math.BigInteger;
import java.util.Scanner;

public class SumFinder {
    public static void main(String[] args) {
        //get number for calculating factorial
        int number = getNumber();
        //calculating factorial
        BigInteger factorial = getFactorial(number);
        //get factorial like array
        int[] factorialIntArray = getFactorialIntArray(factorial);
        //sum all elements in array and get the result of task
        int sumOfFactorialDigits = getFactorialDigitsSum(factorialIntArray);
        System.out.println("Sum of the digits in the number " + number + "! = " + sumOfFactorialDigits);
    }

    //invite user to input number for calculating
    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        System.out.println("Please input number:");
        //working until user's input number less or equals zero
        while (number <= 0){
            String numberStr = scanner.next();
            try {
                number = Integer.valueOf(numberStr);
                if (number <= 0) {
                    System.out.println("You have entered negative or zero argument, please input another argument:");
                    number = 0;
                }
                //exception throw when user input not an integer number
            } catch (NumberFormatException exception) {
                System.out.println("You have entered bad argument, please try again:");
            }
        }
        return number;
    }

    //calculating factorial
    private static BigInteger getFactorial(int number) {
        //BigInteger object uses because it can hold value that biggest then 64bit. (Integer up to 32bit, Long up to 64)
        BigInteger result = BigInteger.ONE;
        //starts with 2 because the result already equals 1, so the first step is 1 multiply 2
        for (int currentNumber = 2; currentNumber <= number; currentNumber++) {
            result = result.multiply(BigInteger.valueOf(currentNumber));
        }
        return result;
    }

    //convert factorial to int array where every digit in factorial is an element in array
    private static int[] getFactorialIntArray(BigInteger factorial) {
        //convert factorial to string
        String factorialStr = factorial.toString();
        //create int array
        int[] factorialArr = new int[factorialStr.length()];
        //extract every digit from the string, convert it into int and put result to the int array
        for (int currentNumber = 0; currentNumber < factorialStr.length(); currentNumber++) {
            factorialArr[currentNumber] = Integer.valueOf(factorialStr.charAt(currentNumber) + "");
        }
        return factorialArr;
    }

    private static int getFactorialDigitsSum(int[] factorialInArray) {
        int sum = 0;
        for (int digit : factorialInArray) {
            sum += digit;
        }
        return sum;
    }
}
