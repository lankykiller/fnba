package com.example.webScarping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.example.dataStructures.queue;

public class extractWebData {


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
    
       
    String triggerWord1 = "starters";
    int triggerWord1Count = 0;
    String ignoreWord1 = "bench";
    String teamNamesDone = "team";
    String triggerWord2 = "PTS";
    int triggerWord2Count = 0;

    int statsCounter = 0;
    
    queue<String> teamNamesQueue = new queue<>();
    queue<String> playerStats = new queue<>();
    Object[] array = new Object[20];
    int addIndex = 0;

    try {
        
        Scanner scanner = new Scanner(new File(getFilePath()));  
      
        //optimoi myohemmin
        //esim triggerword switch case
        while(scanner.hasNext()){

        String word = scanner.next();

            if(triggerWord1Count == 1 && word.length() > 2 && !word.equals(ignoreWord1)){
                    teamNamesQueue.enqueue(word);
                }

            if(triggerWord2Count == 1 && word.length() <= 2){
                playerStats.enqueue(word);
                statsCounter++;
            }

            if(statsCounter == 11){
                array[addIndex] = teamNamesQueue.dequeue() + playerStats.dequeue();
                //pitäis deque koko playerstats lista ja tyhjentää molemmat
            }

            if(word.equals(triggerWord1)){
                    triggerWord1Count++;
                }
            if(word.equals(teamNamesDone) && triggerWord1Count == 1){
                    triggerWord1Count--;
            }
            if(word.equals(triggerWord2)){
                      triggerWord2Count++;;
            }


        }   

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("File not found");
    }
    
    //System.out.println(teamNamesQueue.toString());

    }
    
}
