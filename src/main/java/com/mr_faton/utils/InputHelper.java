package com.mr_faton.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;
    public static final String INPUT_STOP_WORD = "stop";
    private static final String EXCEPTION_MESSAGE = "You have entered bad argument, please try again:";
    private static final String INPUT_STOP_MESSAGE = "(to stop input enter \"" + INPUT_STOP_WORD + "\")";

    public InputHelper() {
        this.scanner = new Scanner(System.in);
    }

    public final int getIntNumber(String invite) {
        int result = 0;
        System.out.println(invite);
        boolean loop = true;
        while (loop) {
            String tempValue = scanner.next();
            try {
                result = Integer.valueOf(tempValue);
                loop = false;
            } catch (NumberFormatException exception) {
                System.out.println(EXCEPTION_MESSAGE);
            }
        }
        return result;
    }

    public final Collection<String> getDataStringCollection(String invite) {
        System.out.println(invite + " " + INPUT_STOP_MESSAGE);
        Collection<String> collection = new ArrayList<>();
        while (true) {
            String text = scanner.next();
            if (text.equals(INPUT_STOP_WORD)) {
                break;
            }
            collection.add(text);
        }
        return Collections.unmodifiableCollection(collection);
    }
}
