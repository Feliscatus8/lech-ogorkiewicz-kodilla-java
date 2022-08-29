package com.kodilla.rps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerCheats implements Rules {
    private Map<String, List<String>> ruleBook = new HashMap<>();
    private Map<String, List<String>> choices = new HashMap<>();
    private Map<String, String> moves = new HashMap<>();
    private String description = "Rock blunts Scissors\nPaper covers Rock\nScissors cut Paper\n" +
            "1 - Rock\n2 - Paper\n3 - Scissors\nn - New Game\nx - Exit";

    public ComputerCheats(){
        List<String> computerChoicesAgainstRock = new ArrayList<>();
        computerChoicesAgainstRock.add("Rock");
        computerChoicesAgainstRock.add("Paper");
        computerChoicesAgainstRock.add("Paper");
        computerChoicesAgainstRock.add("Scissors");
        choices.put("Rock", computerChoicesAgainstRock);
        List<String> computerChoicesAgainstPaper = new ArrayList<>();
        computerChoicesAgainstPaper.add("Rock");
        computerChoicesAgainstPaper.add("Paper");
        computerChoicesAgainstPaper.add("Scissors");
        computerChoicesAgainstPaper.add("Scissors");
        choices.put("Paper", computerChoicesAgainstPaper);
        List<String> computerChoicesAgainstScissors = new ArrayList<>();
        computerChoicesAgainstScissors.add("Rock");
        computerChoicesAgainstScissors.add("Rock");
        computerChoicesAgainstScissors.add("Paper");
        computerChoicesAgainstScissors.add("Scissors");
        choices.put("Scissors", computerChoicesAgainstScissors);

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
