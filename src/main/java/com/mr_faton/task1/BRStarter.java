package com.mr_faton.task1;

import com.mr_faton.task1.core.BracketsResolver;
import com.mr_faton.utils.InputHelper;

import java.util.Collection;

public class BRStarter {
    private static final String INVITE_BRACKETS_COUNT = "Please input number of open brackets:";
    private static final String INVITE_BRACKETS_EXPRESSION = "Please input brackets expressions";

    public static void main(String[] args) {
        InputHelper inputHelper = new InputHelper();
        int openBracketsCount = inputHelper.getIntNumber(INVITE_BRACKETS_COUNT);
        Collection<String> bracketsExpressions = inputHelper.getDataStringCollection(INVITE_BRACKETS_EXPRESSION);
        BracketsResolver bracketsResolver = new BracketsResolver(openBracketsCount, bracketsExpressions);
        Collection<String> satisfyExpressions = bracketsResolver.getSatisfyExpressions();
        System.out.println("Satisfy expressions:");
        for (String expression : satisfyExpressions) {
            System.out.println(expression);
        }
    }
}
