package com.mastermind;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class MockOutputStream extends OutputStream {
    ArrayList<String> stringHistory = new ArrayList<String>();

    @Override
    public void write(int b) throws IOException {
    }

}