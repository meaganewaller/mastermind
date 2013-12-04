package com.mastermind;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class MockOutputStream extends OutputStream {
    ArrayList<String> stringHistory = new ArrayList<String>();

    @Override
    public void write(int b) throws IOException {
    }

    public void write(String message) throws IOException {
        stringHistory.add(message);
    }

    public ArrayList<String> getStringHistory() {
        System.out.println("hi");
        System.out.println(PrintStream.class);
        return stringHistory;

    }
}
