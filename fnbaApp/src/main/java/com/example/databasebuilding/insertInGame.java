package com.example.databasebuilding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;

public class insertInGame implements sqlAddingtoBase{

    private String lastName;
    private String points;
    private String assists;
    private String rebounds;
    private String steals;
    private String blocks;
    private String turnovers;
    private int MAX_SAME_NAME_COUNT = 5;
    int [] playerIDs = new int[MAX_SAME_NAME_COUNT];
    private  String command;

    public insertInGame(String lastName, String points, String assists, String rebounds, String steals, String blocks, String turnovers){
        this.lastName = lastName;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
        this.steals = steals;
        this.blocks = blocks;
        this.turnovers = turnovers;
    }
    
    public void addToInGame() throws SQLException{

        getDataFromSql playerID = new getDataFromSql(lastName);
        int [] playerIDs = playerID.getPlayerID();
            
            for(int index = 0; index<playerIDs.length; index++){
               int id = playerIDs[index];

                try{
                    Connection connection = DriverManager.getConnection(JDBC_URL, username, password);
                    connection.setAutoCommit(false);
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(insertInGameQuery(id));
                    addToCommandHistory();
                    connection.commit();
                    
                    } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();    
                    }
            }
    }

    public void getPlayerID(){
        getDataFromSql playerID = new getDataFromSql(lastName);
        playerIDs = playerID.getPlayerID();
    }

    private String insertInGameQuery(int id) {
                
        StringBuilder addQuery = new StringBuilder();
        String playerid = Integer.toString(id);

        addQuery.append("INSERT INTO ottelussa (playerID, points, boards, assists, blocks, steals, turnovers) VALUES ('");
        addQuery.append(playerid).append("', '").append(points).append("', '").append(rebounds).append("', '").append(assists).append("', '").append(blocks).append("', '").
        append(steals).append("', '").append(turnovers).append("');");
        command = addQuery.toString();
        return addQuery.toString();
    }


    @Override
    public void addToCommandHistory() {

        try{
            FileWriter fw = new FileWriter(path, true);
            fw.write(command);
            fw.write("\n");
            fw.close();
            } catch (Exception e){
                System.out.println("Error writing to file");
                e.printStackTrace();}
          

    }
    
}
