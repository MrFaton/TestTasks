package com.mr_faton.task3;

import com.mr_faton.task3.core.SumFinder;
import com.mr_faton.utils.InputHelper;

/**
 * Created by root on 16.06.2015.
 */
public class SFStarter {
    public static final String INVITE_MESSAGE = "Please input number:";

    public static void main(String[] args) {
        InputHelper inputHelper = new InputHelper();
        int number = inputHelper.getIntNumber(INVITE_MESSAGE);
        SumFinder sumFinder = new SumFinder(number);
        int sum = sumFinder.getFactorialDigitsSum();
        System.out.println("Sum of the digits in the number " + number + "! = " + sum);
    }
}
