package com.example.webScarping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class webScraping {

    public webScraping(){
       // scrapeBoxScore();
    }

    int gameID = 401584689;
   // String searchUrl = baseUrl + gameID;
    

    public void scrapeBoxScore(){
    

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    String baseUrl = "https://www.espn.com/nba/boxscore/_/gameId/401584689";
    //nba/boxscore/_/gameId/401584689

     try{
        final Document doc = Jsoup.connect(baseUrl).get();
        System.out.println(doc.text());
    }
    catch(Exception e){
        e.printStackTrace();
    }

     /*   try{

        driver.get(baseUrl);

        Thread.sleep(5000);

        System.out.println(driver.getPageSource());

        driver.quit();

    }catch(Exception e){
        e.printStackTrace();
    }*/

}

}
