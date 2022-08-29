package com.kodilla.rps;

public class Game {
    private String playerName;
    private int roundsToWin;
    private int playerWins;
    private int computerWins;
    private Rules rules;
    private PlayerInput playerInput;

    public Game(String playerName, int roundsToWin, Rules rules, PlayerInput playerInput) {
        this.playerName = playerName;
        this.roundsToWin = roundsToWin;
        this.rules = rules;
        this.playerInput = playerInput;

    }

    public String playGame(){
        while (true){
            String result = new Round(rules, playerInput).playRound();
            if (result.equals("Exit") || result.equals("New")){return result;}
            switch (result) {
                case "Player":
                    playerWins++;
                    System.out.println("\n" +playerName + " won the round!\n" + playerName + " won " + playerWins +
                            " times\n" + "Computer won " + computerWins + " times");
                    break;
                case "Computer":
                    computerWins++;
                    System.out.println("\nComputer won the round!\n" + playerName + " won " + playerWins + " times\n" +
                            "Computer won " + computerWins + " times");
                    break;
                case "Draw":
                    System.out.println("\nIt was a draw\n" + playerName + " won " + playerWins + " times\n" +
                            "Computer won " + computerWins + " times");
                    break;
            }
            if (playerWins == roundsToWin){return "Player";}
            if (computerWins == roundsToWin){return "Computer";}
        }
    }
}
