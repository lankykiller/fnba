package com.example.dataStructures;



import java.util.Arrays;
import java.util.Comparator;

import com.example.makePlayers.player;

public class arraySorting {

    private int DEFAULT_SIZE = 500;
    player[] playerArray = new player[DEFAULT_SIZE];


    public void queueToArray(queue<player> playerQue){

        int counter = 0;
        while(!playerQue.isEmpty()){
            playerArray[counter] = playerQue.dequeue();
            counter++;
        }
        
    }

    public void sortByPoint(){

        Arrays.sort(playerArray, Comparator.comparingInt(player::getTotalPoints));
    }

    public void sortByAssist(){

        Arrays.sort(playerArray, Comparator.comparingInt(player::getTotalAssist));
    }

    public void sortByRebound(){

        Arrays.sort(playerArray, Comparator.comparingInt(player::getTotalRebound));
    }

    public void sortByBlock(){

        Arrays.sort(playerArray, Comparator.comparingInt(player::getTotalBlock));
    }

    public void sortBySteal(){

        Arrays.sort(playerArray, Comparator.comparingInt(player::getTotalSteals));
    }

    public void sortByTurnover(){

        Arrays.sort(playerArray, Comparator.comparingInt(player::getTotalTurnover));
    }

    public void sortByLastName(){

        Arrays.sort(playerArray, Comparator.comparing(player::getLastName));
    }

    
}
