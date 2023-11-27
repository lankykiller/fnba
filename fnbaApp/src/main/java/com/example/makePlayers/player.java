package com.example.makePlayers;

public class player {

    private String lastName;
    private String firstName;
    private int totalPoints;
    private int totalAssist;
    private int totalRebound;
    private int totalBlock;
    private int totalSteals;
    private int totalTurnover;

    public player(String lastName, String firstName, int totalPoints, int totalAssist, int totalRebound, int totalBlock, int totalSteals, int totalTurnover){

        this.lastName = lastName;
        this.firstName = firstName;
        this.totalPoints = totalPoints;
        this.totalAssist = totalAssist;
        this.totalRebound = totalRebound;
        this.totalBlock = totalBlock;
        this.totalSteals = totalSteals;
        this.totalTurnover = totalTurnover;
    }


    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public int getTotalPoints(){
        return totalPoints;
    }

    public int getTotalAssist(){
        return totalAssist;
    }

    public int getTotalRebound(){
        return totalRebound;
    }

    public int getTotalBlock(){
        return totalBlock;
    }

    public int getTotalSteals(){
        return totalSteals;
    }

    public int getTotalTurnover(){
        return totalTurnover;
    }
    
    
}
