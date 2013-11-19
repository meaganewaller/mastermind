package com.mastermind;

public class GameWrapper {
    public static void main(String[] args) {
        Game game = new Game();
        game.setEncoder(new AI());
        game.setDecoder(new Player());
        game.setUserInterface(new CommandLineInterface());
        game.startGame(4);
    }
}
