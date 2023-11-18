package com.example.databasebuilding;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getDataFromSql {

    private String JDBC_URL = "jdbc:mysql://localhost:3306/fnba";
    private String username = "root";
    private String password = "EkaSql3#!";
    private String name;
    private String teamID;
    int playerID;

    public getDataFromSql(){}

    public getDataFromSql(String name, String teamID){
            this.teamID = teamID;
            this.name = name;
    }


    public int getPlayerID(){

    try {
        Connection connection = DriverManager.getConnection(JDBC_URL, username, password);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        //statement.execute(getPlayerIDQuery(name));
        ResultSet result = statement.executeQuery(getPlayerIDQuery());
        
        while (result.next()) {
            playerID = result.getInt("playerID");
         //   System.out.println(playerID);
        }

        } catch (Exception e) {
        e.getMessage();
        }
    return playerID;
    }

    private String getPlayerIDQuery(){
    
    StringBuilder editedName = new StringBuilder();
    for(int i = 0; i < name.length(); i++){
        char currentChar = name.charAt(i);
        if (currentChar != '-' && currentChar != '\'') {
            editedName.append(currentChar);
        }
    }

    StringBuilder getPlayerID = new StringBuilder();

    getPlayerID.append("SELECT player.playerID FROM player WHERE player.LastName = '");
    getPlayerID.append(editedName);
    getPlayerID.append("' AND player.teamID =");
    getPlayerID.append(teamID);
    getPlayerID.append(";");

    return getPlayerID.toString();
    }



    
}
