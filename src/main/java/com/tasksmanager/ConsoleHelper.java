package com.tasksmanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String lineFromConsole = null;
        while (lineFromConsole == null) {
            try {
                lineFromConsole = reader.readLine();
            } catch (IOException e) {
                writeMessage("An error occurred while trying to enter text. Try again.");
            }
        }
        return lineFromConsole;
    }

    public static int readInt() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException e) {
                writeMessage("An error occurred while trying to enter the number. Попробуйте еще раз.");
            }
        }
        return number;
    }
}