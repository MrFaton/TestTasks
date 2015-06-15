package com.mr_faton.task1.simple_solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Task1_Simple {
    public static void main(String[] args) {
        int openBracketsCount = 0;
        Collection<String> bracketsExpressions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input brackets expressions (to stop input enter \"stop\"):");
        while (true) {
            String expression = scanner.next();
            if (expression.equals("stop")) {
                break;
            }
            bracketsExpressions.add(expression);
        }

        System.out.println("Please input number of open brackets:");
        while (openBracketsCount <= 0){
            String numOfBracketsStr = scanner.next();
            try {
                openBracketsCount = Integer.valueOf(numOfBracketsStr);
                if (openBracketsCount <= 0) {
                    System.out.println("You have entered negative or zero argument, please input another argument:");
                    openBracketsCount = 0;
                }
            } catch (NumberFormatException exception) {
                System.out.println("You have entered bad argument, please try again:");
            }
        }

        for (String expression : bracketsExpressions) {
            System.out.println(eval(openBracketsCount, expression));
        }
    }

    private static boolean eval(int receivedOpenBrackets, String expression) {
        if (expression.startsWith("(") && expression.endsWith(")")) {
            int findOpenBrackets = 0;
            int findCloseBrackets = 0;
            int charPos = 0;

            while (findOpenBrackets < receivedOpenBrackets && charPos < expression.length()) {
                char bracket = expression.charAt(charPos);
                if (bracket == '(') {
                    findOpenBrackets++;
                }
                charPos++;
            }

            while (findCloseBrackets < findOpenBrackets && charPos < expression.length()) {
                char bracket = expression.charAt(charPos);
                if (bracket == ')') {
                    findCloseBrackets++;
                } else {
                    return false;
                }
                charPos++;
            }

            if (findOpenBrackets == findCloseBrackets) {
                return true;
            }
        }
        return false;
    }
}
