package com.mastermind;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MockInputStream extends InputStream {
    public ArrayList<String> inputStringHistory;


    public void setInputStringHistory(ArrayList<String> inputStringHistory) {
        this.inputStringHistory = inputStringHistory;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    public ArrayList<String> getInputStringHistory() {
        return inputStringHistory;
    }

    public void read(String userInput) {
        inputStringHistory.add(userInput);
    }

}
