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
    
    queue<String> teamNamesQueue = new queue<>();

    try {
        
        Scanner scanner = new Scanner(new File(getFilePath()));  
      

        while(scanner.hasNext()){

        String word = scanner.next();

            if(triggerWord1Count == 1 && word.length() > 2 && !word.equals(ignoreWord1)){
                    teamNamesQueue.enqueue(word);
                }

            if(word.equals(triggerWord1)){
                    triggerWord1Count++;
                }

        }   

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("File not found");
    }
    
    System.out.println(teamNamesQueue.toString());

    }
    
}
