package com.example.webScarping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.dataStructures.queue;

public class extractWebData {
   
   
    queue<String> teamNamesQueue = new queue<>();
    queue<String> playerStats = new queue<>();
    Object[] array = new Object[40];
    int statsCounter = 0;


    String gameFile;
    StringBuilder filePath = new StringBuilder("C:\\Users\\danim\\Desktop\\fnba\\");

    public extractWebData(String gamfile){
        this.gameFile = gamfile;
        filePath.append(gamfile);
    }

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
                    if(playerName.length() > 3){
                        if(!playerName.equals("bench") && !playerName.equals("DNP-COACH'S") && !playerName.equals("DECISION")){
                            if(Character.isLetter(playerName.charAt(0))){
                                teamNamesQueue.enqueue(playerName);
                                //System.out.println("\nTAMA MENI LAPI >" + playerName);
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

        //pattern for player stats example 30 6-8 4-6 2-2 1 2 3 1 0 1 1 0 -14 18 
        Pattern playerStatsPattern = Pattern.compile("\\b\\d+-\\d+ \\d+-\\d+ \\d+-\\d+ \\d+-\\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ [+-]\\d+ \\d+");

        StringBuilder line = new StringBuilder();
        Scanner scanner = new Scanner(new File(getFilePath())); 
        int start = -1;
        int end = 13;
        System.out.println("the game file is " + gameFile);
        while(scanner.hasNext()){

            start++;
            end++;
            int first = start;

            while(first < end){
                if(scanner.hasNext()){
                    line.append(scanner.next());
                }
                first++;
            }
            String lineString = line.toString();
            Matcher playerStatsMatcher = playerStatsPattern.matcher(lineString);
            if(playerStatsMatcher.find()){
              /*   String playerStatsString = playerStatsMatcher.group();
                String[] playerStatsArray = playerStatsString.split(" ");
                for(int i = 0; i < playerStatsArray.length; i++){
                    playerStats.enqueue(playerStatsArray[i]);
                }*/
                System.out.println("\nFOUND!!!!!!!");
                }else{
                    System.out.println("\nNOT MATCH FOUND");
                }
             
            
            }
           
        }
    
    public playerBoxScore buildPlayerBoxScore(queue<String> playerStats, queue<String> teamNamesQueue){

        playerBoxScore playerBoxScore = new playerBoxScore();

       if(playerStats.isEmpty()){
           System.out.println("playerStats is empty");
            return null;
        }
         if(teamNamesQueue.isEmpty()){
            System.out.println("teamNamesQueue is empty");
            return null;
        }
        System.out.println(teamNamesQueue.element());
        playerBoxScore.setName(teamNamesQueue.dequeue());

        String min = playerStats.dequeue();
        String fg = playerStats.dequeue();
        String treept = playerStats.dequeue();
        String ft = playerStats.dequeue();
        String ofboard = playerStats.dequeue();
        String defboards = playerStats.dequeue();
        playerBoxScore.setRebounds(playerStats.dequeue());
        playerBoxScore.setAssists(playerStats.dequeue());
        playerBoxScore.setSteals(playerStats.dequeue());
        playerBoxScore.setBlocks(playerStats.dequeue());
        playerBoxScore.setTurnovers(playerStats.dequeue());
        String pf = playerStats.dequeue();
        String plusminus = playerStats.dequeue();
        System.out.println("the points of the player" + playerStats.element() + "\n");
        playerBoxScore.setPoints(playerStats.dequeue());

        return playerBoxScore;
    }
}
