package com.example.webScarping;

import java.io.File;
import java.util.Scanner;

import com.example.dataStructures.queue;

public class extractWebData {
       
    String triggerWord1 = "starters";
    int triggerWord1Count = 0;
    String ignoreWord1 = "bench";
    String teamNamesDone = "team";
    String triggerWord2 = "PTS";
    int triggerWord2Count = 0;
    String triggerWord3 = "MIN";
    int triggerword3Count = 0;
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

    public void readFile(){
    
    int addIndex = 0;

    try {
        
        Scanner scanner = new Scanner(new File(getFilePath()));  
      
        //optimoi myohemmin
        //esim triggerword switch case
        while(scanner.hasNext()){

        String word = scanner.next();
            
            if(word.equals(teamNamesDone) && triggerWord1Count == 1){
                    triggerWord1Count--;
            }

            if(triggerWord1Count == 1 && word.length() > 2 && !word.equals(ignoreWord1)){
                    teamNamesQueue.enqueue(word);
                }

             if(word.equals(triggerWord3) && triggerWord2Count > 0){
                        triggerWord2Count--;  
                }

            if(triggerWord2Count == 1){
                playerStats.enqueue(word);
                statsCounter++;
            }

            if(statsCounter == 14){
                array[addIndex] = buildPlayerBoxScore(playerStats, teamNamesQueue);
                statsCounter = 0;
                addIndex++;
            }

            if(word.equals(triggerWord1)){
                    triggerWord1Count++;
                }else if(word.equals(triggerWord2)){
                      triggerWord2Count++;;
                }
        }   

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("File not found");
    }
    
   // System.out.println(teamNamesQueue.toString());
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
        playerBoxScore.setPoints(playerStats.dequeue());

        return playerBoxScore;
    }
}
