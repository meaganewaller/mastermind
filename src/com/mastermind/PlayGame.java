package com.mastermind;

import java.util.List;

public class PlayGame {

    private AI ai = new AI();

    public void createTheCodes(int size) {
        List<List<Color>> theCodes = ai.theCodes(size);
        for (final List<Color> code : theCodes) {
            Encoder encode = makeAIPlayer(code);
            Game game = new Game();
            game.setEncoder(encode);
            game.setDecoder(new Player());
            game.startGame(size);
        }
    }

    private Encoder makeAIPlayer(final List<Color> code) {
        Encoder ai = new Encoder() {
            @Override
            public List<Color> chooseSecretCode(int size) {
                return code;
            }
        };
        return ai;
    }

    public static void main(String[] args) {
        PlayGame play = new PlayGame();
        play.createTheCodes(4);
    }

}
