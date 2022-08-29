package com.kodilla.rps;

import java.util.List;

public interface Rules {
    public List<String> getChoice(String playerMove);
    public List<String> winsAgainst(String move);
    public String getDescription();
    public String translateMove(String move);
}
