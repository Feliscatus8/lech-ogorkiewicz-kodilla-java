package com.kodilla.rps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExoticRules implements Rules {
    private Map<String, List<String>> ruleBook = new HashMap<>();
    private Map<String, List<String>> choices = new HashMap<>();
    private Map<String, String> moves = new HashMap<>();
    private String description = "Rock blunts Scissors and crushes Lizard\nPaper covers Rock and proves Spock's mistake" +
            "\nScissors cut Paper and hurt Lizard\nLizard eats Paper and bites Spock\nSpock crushes Stone and dismantles Scissors\n" +
            "1 - Rock\n2 - Paper\n3 - Scissors\n4 - Lizard\n5 - Spock\nn - New Game\nx - Exit";

    public ExoticRules(){
        List<String> computerChoices = new ArrayList<>();
        computerChoices.add("Rock");
        computerChoices.add("Paper");
        computerChoices.add("Scissors");
        computerChoices.add("Spock");
        computerChoices.add("Lizard");
        choices.put("Rock", computerChoices);
        choices.put("Paper", computerChoices);
        choices.put("Scissors", computerChoices);
        choices.put("Lizard", computerChoices);
        choices.put("Spock", computerChoices);

        List<String> rockWinsAgainst = new ArrayList<>();
        rockWinsAgainst.add("Scissors");
        rockWinsAgainst.add("Lizard");
        ruleBook.put("Rock", rockWinsAgainst);
        List<String> paperWinsAgainst = new ArrayList<>();
        paperWinsAgainst.add("Rock");
        paperWinsAgainst.add("Spock");
        ruleBook.put("Paper", paperWinsAgainst);
        List<String> scissorsWinAgainst = new ArrayList<>();
        scissorsWinAgainst.add("Paper");
        scissorsWinAgainst.add("Lizard");
        ruleBook.put("Scissors", scissorsWinAgainst);
        List<String> lizardWinsAgainst = new ArrayList<>();
        lizardWinsAgainst.add("Spock");
        lizardWinsAgainst.add("Paper");
        ruleBook.put("Lizard", lizardWinsAgainst);
        List<String> spockWinsAgainst = new ArrayList<>();
        spockWinsAgainst.add("Stone");
        spockWinsAgainst.add("Scissors");
        ruleBook.put("Rock", spockWinsAgainst);

        moves.put("1", "Rock");
        moves.put("2", "Paper");
        moves.put("3", "Scissors");
        moves.put("4", "Lizard");
        moves.put("5", "Spock");
    }
    public List<String> getChoice(String playerMove){
        return choices.get(playerMove);
    }
    public List<String> winsAgainst(String move){
        return ruleBook.get(move);
    }

    public String getDescription() {
        return description;
    }
}
