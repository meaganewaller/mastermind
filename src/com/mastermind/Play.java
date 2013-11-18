package com.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Play {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static int turns = 0;


    public static void main(String[] args) throws IOException {
        welcomeMessage();
        promptForGuess();
        Code secretCode = generateRandomSecretCode();
        String guess = null;
        while ((guess = in.readLine()) != null) {
            turns++;
            System.out.println("You're on turn number " + turns);
            System.out.println(guess);
            promptForGuess();

        }
        System.out.println("Your guess was: " + guess);

    }

    public static void welcomeMessage() {
        System.out.print("Welcome To MasterMind!\n");
        System.out.print("Guess The 4 Digit Secret Code, Colors Represented by Values 1-6\n");
    }

    public static void promptForGuess() {
        System.out.print("What's your guess?: ");
    }



    public static Code generateRandomSecretCode() {
        Code secretCode = new Code(generateRandomColor(), generateRandomColor(), generateRandomColor(), generateRandomColor());
        return secretCode;
    }

    private static Color generateRandomColor() {
        int value = new Long(Math.round(Math.random() * 6)).intValue();
        Color randomColor = getColorFromInt(value);
        return randomColor;
    }

    private static Color getColorFromInt(int value) {
        Color randomColor = null;
        switch (value) {
            case 1:
                randomColor = Color.yellow;
                break;
            case 2:
                randomColor = Color.red;
                break;
            case 3:
                randomColor = Color.blue;
                break;
            case 4:
                randomColor = Color.purple;
                break;
            case 5:
                randomColor = Color.orange;
                break;
            case 6:
                randomColor = Color.green;
                break;
        }
        return randomColor;
    }



}
