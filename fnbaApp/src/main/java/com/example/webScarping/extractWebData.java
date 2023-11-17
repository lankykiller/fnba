package com.example.webScarping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


import com.example.dataStructures.queue;

public class extractWebData {
   
   
    private queue<String> teamNamesQueue = new queue<>();
    private queue<String> playerStats = new queue<>();
    public ArrayList<playerBoxScore> playersBoxScoreArray = new ArrayList<>();
    private int statsCounter = 0;


    String gameFile;
    StringBuilder filePath = new StringBuilder("C:\\Users\\danim\\Desktop\\fnba\\");

    public extractWebData(String gamfile){
        this.gameFile = gamfile;
        filePath.append(gamfile);
    }

    public extractWebData(){}


    //after word match starters 1 time 
    public String getFilePath(){
        return filePath.toString();
    }

    public void readFileGetNames(){
    
    try {
        
        Scanner scanner = new Scanner(new File(getFilePath()));  
      
        while(scanner.hasNext()){

        String word = scanner.next();
        
        if(word.equals("starters")){
            String word2 = scanner.next();

            while(!word2.equals("denotes")){
                    String playerName = word2;
                    if(playerName.length() >= 3){
                        if(!playerName.equals("bench") && !playerName.equals("DNP-COACH'S") && !playerName.equals("DECISION")){
                            if(Character.isLetter(playerName.charAt(0))){
                                teamNamesQueue.enqueue(playerName);
                              //  System.out.println("\nTAMA MENI LAPI >" + playerName);
                            }
                        }
                    }
                    if(scanner.hasNext()){
                        word2 = scanner.next();
                        }else{
                            break;
                            }
                    if(word2.equals("team")){
                            break;
                    }
                }
            }   
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("File not found");
    }
    
}
    public void readFileGetStats() throws FileNotFoundException{

           Scanner scanner = new Scanner(new File(getFilePath()));  

           while(scanner.hasNext()){

            String word = scanner.next();

            if(word.equals("PTS")){

                while (scanner.hasNext()){

                    word = scanner.next();
                    if(word.equals("starters")){
                        playerStats.clear();
                        statsCounter = 0;
                    }
                    if(word.equals("DNP-COACH'S")){
                        teamNamesQueue.dequeue();
                    }
                   
                    boolean numeric = true;
                    try {
                        Double num = Double.parseDouble(word);
                    } catch (NumberFormatException e) {
                        numeric = false;
                    }
                    if(numeric){
                        playerStats.enqueue(word);
                        statsCounter++;
                    }
                    if(statsCounter == 11){
                        if(teamNamesQueue.isEmpty()){
                            System.out.println("teamNamesQueue is empty");
                            return;
                        }
                        buildPlayerBoxScore(playerStats, teamNamesQueue);
                        statsCounter = 0;
                    }
                }   
                }
            }


           }
           
    
    public boolean buildPlayerBoxScore(queue<String> playerStats, queue<String> teamNamesQueue){

        playerBoxScore playerBoxScore = new playerBoxScore();

       if(playerStats.isEmpty()){
           System.out.println("playerStats is empty");
            return false;
        }
         if(teamNamesQueue.isEmpty()){
            System.out.println("teamNamesQueue is empty");
            return false;
        }
       // System.out.println(teamNamesQueue.element());
        playerBoxScore.setName(teamNamesQueue.dequeue());

        String min = playerStats.dequeue();
        String ofboard = playerStats.dequeue();
        String defboards = playerStats.dequeue();
        playerBoxScore.setRebounds(playerStats.dequeue());
        playerBoxScore.setAssists(playerStats.dequeue());
        playerBoxScore.setSteals(playerStats.dequeue());
        playerBoxScore.setBlocks(playerStats.dequeue());
        playerBoxScore.setTurnovers(playerStats.dequeue());
        String pf = playerStats.dequeue();
        String plusminus = playerStats.dequeue();
       // System.out.println("the points of the player" + playerStats.element() + "\n");
        playerBoxScore.setPoints(playerStats.dequeue());

        playersBoxScoreArray.add(playerBoxScore);
       // System.out.println(playersBoxScoreArray.get(0).getName());
        return true;
    }

    public ArrayList<playerBoxScore> getPlayersBoxScore(){
        return playersBoxScoreArray;
    }

}
