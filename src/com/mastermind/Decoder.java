package com.mastermind;

import java.util.List;

public interface Decoder {
    List<Color> promptGuess(List<Turn> turns, int size);
}
