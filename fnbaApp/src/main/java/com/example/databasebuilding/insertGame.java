package com.example.databasebuilding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;


public class insertGame implements sqlAddingtoBase {

    private String winnerTeam;
    private String loserTeam;

    public insertGame(String winnerTeam, String loserTeam){
        this.winnerTeam = winnerTeam;
        this.loserTeam = loserTeam;
    }

    public void addToGame() throws SQLException{

        try{
            Connection connection = DriverManager.getConnection(JDBC_URL, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertGameQuery());
            addToCommandHistory();
            connection.commit();
            
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();    
            }
    }

    private String insertGameQuery() {

        StringBuilder addQuery = new StringBuilder();
        //teamID on auto_increment, so add name and conference
        addQuery.append("INSERT INTO ottelu(winnerID, loserID) VALUES ('");
        addQuery.append(winnerTeam).append("', '").append(loserTeam).append("');");
            
        return addQuery.toString();
    }

    @Override
    public void addToCommandHistory() {
            
        String command = insertGameQuery();

        try{
            FileWriter fw = new FileWriter(path, true);
            fw.write(command);
            fw.write("\n");
            fw.close();
            } catch (Exception e){
                System.out.println("Error writing to file");
                e.printStackTrace();
            }
    }
}
