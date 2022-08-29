package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Round {
    private Rules rules;

    public Round(Rules rules) {
        this.rules = rules;
    }
    public String playRound(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(rules.getDescription() + "\nYour move:");
            String move = scanner.nextLine();
            if (move.equals("x")){
                System.out.println("Do you really want to exit? y/n: ");
                String reply = scanner.nextLine();
                if (reply.equals("y")){
                    return "Exit";
                }
                continue;
            }
            if (move.equals("n")){
                System.out.println("Do you really want to start a new game? y/n: ");
                String reply = scanner.nextLine();
                if (reply.equals("y")){
                    return "New";
                }
                continue;
            }
            move = rules.translateMove(move);
            Random rand = new Random();
            List<String> computerChoices = new ArrayList<>(rules.getChoice(move));
            String computerMove = computerChoices.get(rand.nextInt(computerChoices.size()));
            if (rules.winsAgainst(move).contains(computerMove)){return "Player";}
            if (rules.winsAgainst(computerMove).contains(move)){return "Computer";}
            return "Draw";
        }
    }
}
