package com.mastermind;

import java.util.List;

public class MockEncoder extends AI {
    public List<Color> secretCode;

    @Override
    public List<Color> chooseSecretCode(int size) {
        return secretCode;
    }
}
