package com.example.databasebuilding;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertTeam implements sqlAddingtoBase{

    private String teamName;
    private String conference;

    insertTeam(String teamName, String conference){
        this.teamName = teamName;
        this.conference = conference;
    }
        
    public void ConnectionTeam() throws SQLException{
    
        try{
            
            Connection connection = DriverManager.getConnection(JDBC_URL, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertTeamQuery());
            addToCommandHistory();
            connection.commit();
        
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();    
                }
    }

    //adding the 30 teams in nba, two methods bulding the string and
    private String insertTeamQuery(){

        StringBuilder addQuery = new StringBuilder();
        //teamID on auto_increment, so add name and conference
        addQuery.append("INSERT INTO team (name, conference) VALUES ('");
        addQuery.append(teamName).append("', '").append(conference).append("');");
                
        return addQuery.toString();
    }

    @Override
    public void addToCommandHistory() {
            
        String command = insertTeamQuery();

        try{
            FileWriter fw = new FileWriter(path, true);
            fw.write(command);
            fw.write("\n");
            fw.close();
            } catch (IOException e){
                System.out.println("Error writing to file");
                e.printStackTrace();
            }
    }   
    
}
