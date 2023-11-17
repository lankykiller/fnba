package com.example;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.databasebuilding.buildPlayerData;
import com.example.databasebuilding.updatingGames;
import com.example.webScarping.extractWebData;
import com.example.webScarping.playerBoxScore;
import com.example.webScarping.webScraping;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;


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
      webScraping webScraping = new webScraping(401584689);
      //webScraping.scrapeBoxScore();

      extractWebData test1 = new extractWebData("401584689.txt");
      test1.readFileGetNames();
      test1.readFileGetStats();

      ArrayList<playerBoxScore> firstBoxScores = test1.getPlayersBoxScore();

      updatingGames test2 = new updatingGames(firstBoxScores); 
      test2.addBoxScores();
     
    }
}
    

