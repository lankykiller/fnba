package com.example;

import java.sql.SQLException;
import com.example.databasebuilding.buildPlayerData;

public class fnbamain {

    public static void main( String[] args ) throws SQLException{

       /*file not found make the code that you past as a parameter a file if wanter
       if not use a exsistig file*/
      
       // newplayerTest.buildPlayerData();
       // buildPlayerData newPlayerData = new buildPlayerData();
      //  newPlayerData.buildPlayerInfo("test.txt");

        buildPlayerData seconBuildPlayerData = new buildPlayerData();
       seconBuildPlayerData.buildPlayerInfo("Test2", "test2", 55.5, 14);

    }
}
    

