package com.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandLineInterface {

    public List<Color> promptCode() {
        System.out.println("Enter Guess: ");
        String userInput = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            userInput = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convertInput(userInput);
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Mastermind!");
        System.out.println("The code is made up from 4 colors, the initials of the colors are r, g, y, b, p, o (red, green, yellow, blue, purple, orange)");
        System.out.println("Good luck!\n");
    }

    public void showBoard(List<Turn> turns) {
        for (Turn turn : turns) {
            System.out.println(convertOutput(turn));
        }
    }

    List<Color> convertInput(String input) {
        char[] chars = input.replaceAll("\\W", "").toLowerCase().toCharArray();
        List<Color> color = new ArrayList<Color>();
        for (char c : chars) {
            color.add(Color.charToColor.get(c));
        }

        return color;
    }

    String convertOutput(Turn turn) {
        List<Color> guess = turn.getGuess();
        String guessString = guessToString(guess);
        Feedback feedback = turn.getFeedback();
        int size = guess.size();
        String feedbackString = feedbackToString(feedback, size);
        String divider = repeatString("-", 6 + 2 * size);
        return String.format("%s%n|%s|  |%s|", divider, guessString, feedbackString);
    }

    String repeatString(String input, int times) {
        String string = "";
        for (int index = 0; index < times; index++) {
            string += input;
        }
        return string;
    }

    String feedbackToString(Feedback feedback, int size) {
        String feedString = "";
        int numOfX = feedback.getNumberOfX();
        int numOfO = feedback.getNumberOfO();
        int numSpaces = size - (numOfX + numOfO);
        feedString += repeatString("X", numOfX);
        feedString += repeatString("O", numOfO);
        feedString += repeatString(" ", numSpaces);
        return feedString;
    }

    String guessToString(List<Color> guess) {
       int size = guess.size();
       char[] chars = new char[size];
       for (int index = 0; index < size; index++) {
           chars[index] = guess.get(index).c;
       }
       return new String(chars);
    }
}
