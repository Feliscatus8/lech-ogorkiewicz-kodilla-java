package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end = false;
        String name = "";
        PlayerInput playerInput = new PlayerInput();
        while (!end) {
            if (name == ""){
                System.out.println("\nEnter your name: ");
                name = playerInput.getPlayerInput();
            }
            System.out.println("\nEnter number of rounds to win: ");
            int rounds = (int)playerInput.getPlayerInt();
            Game game = new Game(name, rounds, new StandardRules(), playerInput);
            String result = game.playGame();
            switch (result){
                case "Player":
                    System.out.println("\n" + name + " won the game!");
                    break;
                case "Computer":
                    System.out.println("\nComputer won the game!");
                    break;
                case "New":
                    System.out.println("\nStarting a new game");
                    break;
                case "Exit":
                    System.out.println("\nExiting");
                    end = true;
            }
        }
    }
}
