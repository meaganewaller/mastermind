package com.mastermind;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommandLineInterface {
PrintStream output = System.out;
InputStream input = System.in;
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
String userInput = null;

    public void setOutput(PrintStream output) {
        this.output = output;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void promptForGuess() {
        output.print("Enter Your Guess: ");
    }

    public String promptCode() {
       try {
           userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    public void displayWelcomeMessage() {
        output.println("Welcome to Mastermind!");
        output.println("The code is made up from 4 colors, the initials of the colors are r, g, y, b, p, o (red, green, yellow, blue, purple, orange)");
        output.println("Good luck!\n");
    }

    public void showBoard(List<Turn> turns) {
        for (Turn turn : turns) {
            output.println(convertOutput(turn));
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
