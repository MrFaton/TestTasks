package com.mr_faton.task1.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BracketsResolver {
    public static final String BRACKET_OPEN = "(";
    public static final String BRACKET_CLOSE = ")";

    private final int openBracketsCount;
    private final Collection<String> bracketsCollection;

    public BracketsResolver(int openBracketsCount, Collection<String> bracketsCollection) {
        this.openBracketsCount = openBracketsCount;
        this.bracketsCollection = bracketsCollection;
    }

    //method witch returns right expressions
    public final Collection<String> getSatisfyExpressions() {
        Collection<String> resultCollection = new ArrayList<>();
        //check every expression
        for (String expression : bracketsCollection) {
            /*
            if the result of checking if true (it means the expression corresponds to the condition) so
            add the expression to the result collection
             */
            if (checkExpression(expression)) {
                resultCollection.add(expression);
            }
        }
        return Collections.unmodifiableCollection(resultCollection);
    }

    //method for checking expression
    private boolean checkExpression(String expression) {
        //if condition is false then it's means user input not correct expression and answer is false
        if (expression.startsWith(BRACKET_OPEN) && expression.endsWith(BRACKET_CLOSE)) {
            int findOpenBrackets = 0;
            int findCloseBrackets = 0;
            //position of current bracket
            int charPos = 0;

            //count open brackets until user's number of open brackets or until end of expression
            while (findOpenBrackets < openBracketsCount && charPos < expression.length()) {
                char bracket = expression.charAt(charPos);
                if (bracket == BRACKET_OPEN.charAt(0)) {
                    findOpenBrackets++;
                }
                charPos++;
            }

            //count close brackets from last open bracket position until num of found open brackets or until end of expr
            while (findCloseBrackets < findOpenBrackets && charPos < expression.length()) {
                char bracket = expression.charAt(charPos);
                if (bracket == BRACKET_CLOSE.charAt(0)) {
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
