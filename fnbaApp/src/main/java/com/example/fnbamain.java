package com.example;

import java.sql.SQLException;



import com.example.databasebuilding.buildPlayerData;
import com.example.webScarping.extractWebData;
import com.example.webScarping.webScraping;


public class fnbamain {

    public static void main( String[] args ) throws SQLException{

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
      //webScraping.scrapeBoxScore();

      extractWebData test1 = new extractWebData("test.txt");
      test1.readFile();
      

    }
}
    

