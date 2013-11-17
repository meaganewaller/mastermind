package com.mastermind;

public class Code {
    private final Color code1;
    private final Color code2;
    private final Color code3;
    private final Color code4;

    public Code(Color code1, Color code2, Color code3, Color code4) {
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.code4 = code4;
    }

    public Color getCode1() {
        return code1;
    }

    public Color getCode2() {
        return code2;
    }

    public Color getCode3() {
        return code3;
    }

    public Color getCode4() {
        return code4;
    }

}
