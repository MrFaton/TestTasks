package com.mr_faton.task3.core;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SumFinder {
    private final int number;

    public SumFinder(int number) {
        this.number = number;
    }

    public final int getFactorialDigitsSum() {
        if (number == 0) {
            return 0;
        }
        BigInteger factorial = getFactorial(number);
        Collection<Integer> factorialDigits = getFactorialDigits(factorial);
        int sum = 0;
        for (int digit : factorialDigits) {
            sum += digit;
        }
        return sum;
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
    private static Collection<Integer> getFactorialDigits(BigInteger factorial) {
        Collection<Integer> factorialDigits = new ArrayList<>();
        //convert factorial to string
        String factorialStr = factorial.toString();
        //extract every digit from the string, convert it into int and put result to the int array
        for (int currentNumber = 0; currentNumber < factorialStr.length(); currentNumber++) {
            factorialDigits.add(Integer.valueOf(factorialStr.charAt(currentNumber) + ""));
        }
        return Collections.unmodifiableCollection(factorialDigits);
    }
}
