package com.example;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dataStructures.queue;
import com.example.databasebuilding.buildPlayerData;
import com.example.databasebuilding.getPlayerStats;
import com.example.databasebuilding.updatingGames;
import com.example.makePlayers.player;
import com.example.webScarping.extractWebData;
import com.example.webScarping.playerBoxScore;
import com.example.webScarping.webScraping;



public class fnbamain {

    public static void main( String[] args ) throws SQLException, FileNotFoundException{

       /*file not found make the code that you past as a parameter a file if wanter
       if not use a exsistig file*/
      
       // newplayerTest.buildPlayerData();
        buildPlayerData newPlayerData = new buildPlayerData();
      //  newPlayerData.buildPlayerInfo("test.txt");

    //    buildPlayerData seconBuildPlayerData = new buildPlayerData();
      // seconBuildPlayerData.buildPlayerInfo("Test2", "test2", 55.5, 14);
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\danim\\Desktop\\fnba\\fnbaApp\\src\\main\\java\\com\\example\\webScarping\\webScraping.java");

      //firstgame of the season id 401584689
      webScraping webScraping = new webScraping(401584690);
      webScraping.scrapeBoxScore();

      extractWebData firstGame = new extractWebData("401584690.txt");
      firstGame.readFileGetNames();
      firstGame.readFileGetStats();

      ArrayList<playerBoxScore> firstBoxScores = firstGame.getPlayersBoxScore();

      updatingGames test2 = new updatingGames(firstBoxScores); 
      test2.addBoxScores();

      //getDataFromPlayer test3 = new getDataFromPlayer("Holiday");
      //test3.getPlayerID();

     // updatingGames test4 = new updatingGames(firstBoxScores);
      //test4.addBoxScores();
      //lisätty kaksi peliä

     // getPlayerStats test5 = new getPlayerStats();
     // test5.getPlayerBoxscores();
     // queue<player> test6 = test5.getPlayerQueue();
 
    }
}
    

