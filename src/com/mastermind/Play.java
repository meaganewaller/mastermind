package com.mastermind;

public class Play {
    public Code generateRandomSecretCode() {
        Code secretCode = new Code(generateRandomColor(), generateRandomColor(), generateRandomColor(), generateRandomColor());
        return secretCode;
    }

    private Color generateRandomColor() {
        int value = new Long(Math.round(Math.random() * 6)).intValue();
        Color randomColor = getColorFromInt(value);
        return randomColor;
    }

    private Color getColorFromInt(int value) {
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
