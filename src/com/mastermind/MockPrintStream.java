package com.mastermind;


import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class MockPrintStream extends PrintStream {

    public void setStringHistory(ArrayList<String> stringHistory) {
        this.stringHistory = stringHistory;
    }

    public ArrayList<String> stringHistory;

    public MockPrintStream(OutputStream out) {
        super(out);
    }

    public void println(String message) {
        stringHistory.add(message);
    }

    public void print(String message) {
        stringHistory.add(message);
    }

    public ArrayList<String> getStringHistory() {
        return stringHistory;
    }
    
    public String lastOutput() {
    	return stringHistory.get(stringHistory.size()-1);
    }

}
