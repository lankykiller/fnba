package com.example.webScarping;

public class playerBoxScore {

    playerBoxScore(){}

    playerBoxScore(String name, String points, String assists, String rebounds, String steals, String blocks, String turnovers){
        this.name = name;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.steals = steals;
        this.blocks = blocks;
        this.turnovers = turnovers;
    }

    private String name;
    private String points;
    private String assists;
    private String rebounds;
    private String steals;
    private String  blocks;
    private String  turnovers;

    public String getName(){
        return name;
    }
    public String getPoints(){
        return points;
    }
    public String getAssists(){
        return assists;
    }
    public String getRebounds(){
        return rebounds;
    }
    public String getSteals(){
        return steals;
    }
    public String getBlocks(){
        return blocks;
    }
    public String getTurnovers(){
        return turnovers;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPoints(String points){
        this.points = points;
    }
    public void setAssists(String assists){
        this.assists = assists;
    }
    public void setRebounds(String rebounds){
        this.rebounds = rebounds;
    }
    public void setSteals(String steals){
        this.steals = steals;
    }
    public void setBlocks(String blocks){
        this.blocks = blocks;
    }
    public void setTurnovers(String turnovers){
        this.turnovers = turnovers;
    }

    
}
