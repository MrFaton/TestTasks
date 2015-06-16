package com.mr_faton.task1.simple_solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Task1_Simple {
    public static void main(String[] args) {
        //requirement number of brackets (The N in Your task)
        int openBracketsCount = 0;
        //collection for keeping brackets expressions
        Collection<String> bracketsExpressions = new ArrayList<>();
        //tool for input brackets expressions and brackets number
        Scanner scanner = new Scanner(System.in);

        //invite user to input brackets expression. User must to input "stop" for breaking collecting expressions
        System.out.println("Please input brackets expressions (to stop input enter \"stop\"):");
        //loop until user has entered stop
        while (true) {
            String expression = scanner.next();
            if (expression.equals("stop")) {
                break;
            }
            //adding user's expression to collection
            bracketsExpressions.add(expression);
        }

        //invite user to input number of open brackets
        System.out.println("Please input number of open brackets:");
        //working until user's input number less or equals zero
        while (openBracketsCount <= 0){
            String numOfBracketsStr = scanner.next();
            try {
                openBracketsCount = Integer.valueOf(numOfBracketsStr);
                if (openBracketsCount <= 0) {
                    System.out.println("You have entered negative or zero argument, please input another argument:");
                    openBracketsCount = 0;
                }
                //exception throw when user input not an integer number
            } catch (NumberFormatException exception) {
                System.out.println("You have entered bad argument, please try again:");
            }
        }

        //handle every expression
        for (String expression : bracketsExpressions) {
            if (eval(openBracketsCount, expression)) {
                System.out.println("Satisfy expression: " + expression);
            }
        }
    }

    private static boolean eval(int receivedOpenBrackets, String expression) {
        //if condition is false then it's means user input not correct expression and answer is false
        if (expression.startsWith("(") && expression.endsWith(")")) {
            int findOpenBrackets = 0;
            int findCloseBrackets = 0;
            //position of current bracket
            int charPos = 0;

            //count open brackets until user's number of open brackets or until end of expression
            while (findOpenBrackets < receivedOpenBrackets && charPos < expression.length()) {
                char bracket = expression.charAt(charPos);
                if (bracket == '(') {
                    findOpenBrackets++;
                }
                charPos++;
            }

            //count close brackets from last open bracket position until num of found open brackets or until end of expr
            while (findCloseBrackets < findOpenBrackets && charPos < expression.length()) {
                char bracket = expression.charAt(charPos);
                if (bracket == ')') {
                    findCloseBrackets++;
                } else {
                    return false;
                }
                charPos++;
            }

            //if num of found open brackets equals num of closed brackets then expr is satisfied
            if (findOpenBrackets == findCloseBrackets) {
                return true;
            }
        }
        return false;
    }
}
