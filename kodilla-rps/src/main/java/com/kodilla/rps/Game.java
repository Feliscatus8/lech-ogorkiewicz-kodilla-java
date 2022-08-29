package com.kodilla.rps;

import java.util.Scanner;

public class Game {
    private String playerName;
    private int roundsToWin;
    private int playerWins;
    private int computerWins;
    private Rules rules;

    public Game(String playerName, int roundsToWin, Rules rules) {
        this.playerName = playerName;
        this.roundsToWin = roundsToWin;
        this.rules = rules;
    }

    public String playGame(){
        while (true){
            String result = new Round(rules).playRound();
            if (result.equals("Exit") || result.equals("New")){return result;}
            switch (result) {
                case "Player":
                    System.out.println(playerName + " won the round!");
                    playerWins++;
                    break;
                case "Computer":
                    System.out.println("Computer won the round!");
                    computerWins++;
                    break;
                case "Draw":
                    System.out.println("It was a draw");
                    break;
            }
            if (playerWins == roundsToWin){return "Player";}
            if (computerWins == roundsToWin){return "Computer";}
        }
    }
}
