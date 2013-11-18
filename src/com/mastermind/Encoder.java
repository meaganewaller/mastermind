package com.mastermind;

import java.util.List;

public interface Encoder {
    List<Color> chooseSecretCode(int size);
}
