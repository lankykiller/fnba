package com.example.databasebuilding;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class getDataFromPlayer implements sqlAddingtoBase {


    private String name;
    private int MAX_SAME_NAME_COUNT = 5;
    int []playerID = new int[MAX_SAME_NAME_COUNT];

    public getDataFromPlayer(){}

    public getDataFromPlayer(String name){  
            this.name = name;
    }

    public int[] getPlayerID(){

    try {
        Connection connection = DriverManager.getConnection(JDBC_URL, username, password);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        //statement.execute(getPlayerIDQuery(name));
        ResultSet result = statement.executeQuery(getPlayerIDQuery());
        int index = 0;
        while (result.next()) {
            playerID[index] = result.getInt("playerID");
            System.out.println(playerID[index]);
            index++;
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
    getPlayerID.append("';");

    return getPlayerID.toString();
    }

    @Override
    public void addToCommandHistory() {
        
    }



    
}
