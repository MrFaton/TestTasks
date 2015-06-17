package com.mr_faton.task1;

import com.mr_faton.task1.core.BracketsResolver;
import com.mr_faton.utils.InputHelper;

import java.util.Collection;

public class BRStarter {
    //invite messages for user
    private static final String INVITE_BRACKETS_COUNT = "Please input number of open brackets:";
    private static final String INVITE_BRACKETS_EXPRESSION = "Please input brackets expressions";

    public static void main(String[] args) {
        //create entity which construct input dialog
        InputHelper inputHelper = new InputHelper();
        //get open brackets count
        int openBracketsCount = inputHelper.getIntNumber(INVITE_BRACKETS_COUNT);
        //get collection of brackets expressions
        Collection<String> bracketsExpressions = inputHelper.getStringDataCollection(INVITE_BRACKETS_EXPRESSION);

        //close input (scanner.close())
        inputHelper.closeInput();

        //construct BracketsResolver
        BracketsResolver bracketsResolver = new BracketsResolver(openBracketsCount, bracketsExpressions);
        //get right expressions
        Collection<String> satisfyExpressions = bracketsResolver.getSatisfyExpressions();
        //print right expressions
        System.out.println("Satisfy expressions:");
        for (String expression : satisfyExpressions) {
            System.out.println(expression);
        }
    }
}
