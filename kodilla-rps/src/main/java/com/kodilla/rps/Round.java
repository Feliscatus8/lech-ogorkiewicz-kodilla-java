package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Round {
    private final Rules rules;
    private final PlayerInput playerInput;

    public Round(Rules rules, PlayerInput playerInput) {
        this.rules = rules;
        this.playerInput = playerInput;
    }
    public String playRound(){
        while (true) {
            System.out.println("\n" + rules.getDescription() + "\nYour move:");
            String move = playerInput.getPlayerInput();
            if (move.equalsIgnoreCase("x")){
                System.out.println("Do you really want to exit? y/n: ");
                String reply = playerInput.getPlayerInput();
                if (reply.equalsIgnoreCase("y")){
                    return "Exit";
                }
                continue;
            }
            if (move.equalsIgnoreCase("n")){
                System.out.println("Do you really want to start a new game? y/n: ");
                String reply = playerInput.getPlayerInput();
                if (reply.equalsIgnoreCase("y")){
                    return "New";
                }
                continue;
            }
            move = rules.translateMove(move);
            Random rand = new Random();
            List<String> computerChoices = new ArrayList<>(rules.getChoice(move));
            String computerMove = computerChoices.get(rand.nextInt(computerChoices.size()));
            System.out.println("The player chose " + move + "\nThe computer chose " + computerMove);
            if (rules.winsAgainst(move).contains(computerMove)){return "Player";}
            if (rules.winsAgainst(computerMove).contains(move)){return "Computer";}
            return "Draw";
        }
    }

}
