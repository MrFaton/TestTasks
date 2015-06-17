package com.mr_faton.task3;

import com.mr_faton.task3.core.SumFinder;
import com.mr_faton.utils.InputHelper;

/**
 * Created by root on 16.06.2015.
 */
public class SFStarter {
    public static final String INVITE_MESSAGE = "Please input number:";

    public static void main(String[] args) {
        //create entity which construct input dialog
        InputHelper inputHelper = new InputHelper();
        //get number for calculating
        int number = inputHelper.getIntNumber(INVITE_MESSAGE);

        //close input (scanner.close())
        inputHelper.closeInput();

        //construct SumFinder
        SumFinder sumFinder = new SumFinder();
        //evaluate sum
        int sum = sumFinder.getFactorialDigitsSum(number);
        System.out.println("Sum of the digits in the number " + number + "! = " + sum);
    }
}
