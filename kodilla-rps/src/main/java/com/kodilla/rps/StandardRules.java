package com.kodilla.rps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardRules implements Rules {
    private Map<String, List<String>> ruleBook = new HashMap<>();
    private Map<String, List<String>> choices = new HashMap<>();
    private Map<String, String> moves = new HashMap<>();
    private String description = "Rock blunts Scissors\nPaper covers Rock\nScissors cut Paper\n" +
            "1 - Rock\n2 - Paper\n3 - Scissors\nn - New Game\nx - Exit";

    public StandardRules(){
        List<String> computerChoices = new ArrayList<>();
        computerChoices.add("Rock");
        computerChoices.add("Paper");
        computerChoices.add("Scissors");
        choices.put("Rock", computerChoices);
        choices.put("Paper", computerChoices);
        choices.put("Scissors", computerChoices);

        List<String> rockWinsAgainst = new ArrayList<>();
        rockWinsAgainst.add("Scissors");
        ruleBook.put("Rock", rockWinsAgainst);
        List<String> paperWinsAgainst = new ArrayList<>();
        paperWinsAgainst.add("Rock");
        ruleBook.put("Paper", paperWinsAgainst);
        List<String> scissorsWinAgainst = new ArrayList<>();
        scissorsWinAgainst.add("Paper");
        ruleBook.put("Scissors", scissorsWinAgainst);

        moves.put("1", "Rock");
        moves.put("2", "Paper");
        moves.put("3", "Scissors");
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
    public String translateMove(String move){
        return moves.get(move);
    }
}
