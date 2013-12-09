package com.mastermind;

public class GameWrapper {
    public static void main(String[] args) {
        Game game = new Game();
        game.setUserInterface(new CommandLineInterface());
        game.startGame(4);
    }
}
