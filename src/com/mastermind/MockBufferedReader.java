package com.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class MockBufferedReader extends BufferedReader {
    public ArrayList<String> stringHistory;

    public void setStringHistory(ArrayList<String> stringHistory) {
        this.stringHistory = stringHistory;
    }

    public MockBufferedReader(Reader in, int sz) {
        super(in, sz);
    }

    public MockBufferedReader(InputStreamReader inputStreamReader) {
        super(inputStreamReader);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String readLine() throws IOException {
    	return stringHistory.get(1);
    }

    public ArrayList<String> getStringHistory() {
        return stringHistory;
    }
}
