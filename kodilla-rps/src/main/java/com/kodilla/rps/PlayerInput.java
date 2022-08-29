package com.kodilla.rps;

import java.util.Scanner;

public class PlayerInput {
    public String getPlayerInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public int getPlayerInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
