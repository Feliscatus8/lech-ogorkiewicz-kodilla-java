package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end = false;
        String name = "";
        Scanner scanner = new Scanner(System.in);
        while (!end) {
            if (name == ""){
                System.out.println("Enter your name: ");
                name = scanner.nextLine();
            }
            System.out.println("Enter number of rounds to win: ");
            int rounds = scanner.nextInt();
            Game game = new Game(name, rounds, new StandardRules());
            String result = game.playGame();
            switch (result){
                case "Player":
                    System.out.println(name + " won the game!");
                    break;
                case "Computer":
                    System.out.println("Computer won the game!");
                    break;
                case "New":
                    System.out.println("Starting a new game");
                    break;
                case "Exit":
                    System.out.println("Exiting");
                    end = true;
            }
        }
    }
}
