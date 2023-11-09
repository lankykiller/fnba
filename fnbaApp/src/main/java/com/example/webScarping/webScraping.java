package com.example.webScarping;

import org.checkerframework.checker.units.qual.g;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileWriter;


public class webScraping {

    public webScraping(){
       // scrapeBoxScore();
    }
    public webScraping(int gameID){
        setGameID(gameID);
    }
    //default gameID
    int gameID = 401584689;

    public int getGameID(){
        return gameID;
    }
    public void setGameID(int gameID){
        this.gameID = gameID;
    }

   // String searchUrl = baseUrl + gameID;
    public void scrapeBoxScore(){

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver(options);
    String baseUrl = "https://www.espn.com/nba/boxscore/_/gameId/";
    //nba/boxscore/_/gameId/401584689
    
    Integer.toString(getGameID());
    String searchUrl = baseUrl + getGameID();
    Document doc = null;
    StringBuilder fileName = new StringBuilder("C:\\Users\\danim\\Desktop\\fnba\\");

     try{
        doc = Jsoup.connect(searchUrl).get();
        //System.out.println(doc.text());
        fileName.append(gameID);
        fileName.append(".txt");

        File gameInfo = new File(fileName.toString());
        gameInfo.createNewFile();

    }
    catch(Exception e){
        e.printStackTrace();
    }
   
    try {
        FileWriter gameFile = new FileWriter(fileName.toString(), true);
        gameFile.write(doc.text());
        gameFile.close();

    } catch (Exception e) {
        System.out.println("Error writing to file");
                e.printStackTrace();
    }

     driver.quit();

    }

}
