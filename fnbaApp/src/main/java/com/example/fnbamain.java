package com.example;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.databasebuilding.buildPlayerData;
import com.example.webScarping.webScraping;


public class fnbamain {

    public static void main( String[] args ) throws SQLException{

       /*file not found make the code that you past as a parameter a file if wanter
       if not use a exsistig file*/
      
       // newplayerTest.buildPlayerData();
       // buildPlayerData newPlayerData = new buildPlayerData();
      //  newPlayerData.buildPlayerInfo("test.txt");

    //    buildPlayerData seconBuildPlayerData = new buildPlayerData();
      // seconBuildPlayerData.buildPlayerInfo("Test2", "test2", 55.5, 14);
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\danim\\Desktop\\fnba\\fnbaApp\\src\\main\\java\\com\\example\\webScarping\\webScraping.java");
      
      webScraping webScraping = new webScraping();
      webScraping.scrapeBoxScore();

    }
}
    

