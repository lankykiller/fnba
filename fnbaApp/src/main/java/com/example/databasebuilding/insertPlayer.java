package com.example.databasebuilding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;

public class insertPlayer implements sqlAddingtoBase{

    private String firstName;
    private String lastName;
    private double fantasyPrice;
    private int teamID;

    insertPlayer(String firstName, String lastName, double fantasyPrice, int teamID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fantasyPrice = fantasyPrice;
        this.teamID = teamID;
    }

    private String insertPlayerQuery(){

        StringBuilder addQuery = new StringBuilder();
        //teamID on auto_increment, so add name and conference
        addQuery.append("INSERT INTO player (FirstName, LastName, fantasyPrice, teamID) VALUES ('");
        addQuery.append(firstName).append("', '").append(lastName).append("', '").append(fantasyPrice).append("', '").append(teamID).append("');");
            
        return addQuery.toString();
    }

    public void ConnectionPlayer() throws SQLException{
    
        try{
            
        Connection connection = DriverManager.getConnection(JDBC_URL, username, password);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.executeUpdate(insertPlayerQuery());
        connection.commit();
            
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();    
                }
    }

    @Override
    public void addToCommandHistory() {
          
        String command = insertPlayerQuery();

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
