package com.example.databasebuilding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;
import java.io.IOException;


    public class sqlAddingtoBase {

        private String JDBC_URL = "jdbc:mysql://localhost:3306/fnba";
        private String username = "root";
        private String password = "EkaSql3#!";
        //team
        private String teamName;
        private String conference;
        //player
        private String firstName;
        private String lastName;
        private double fantasyPrice;
        private int teamID;
        private String gameCommand;

        sqlAddingtoBase(String teamName, String conference){

            this.teamName = teamName;
            this.conference = conference;
        }

        sqlAddingtoBase(String firstName, String lastName, double fantasyPrice, int teamID){

            this.firstName = firstName;
            this.lastName = lastName;
            this.fantasyPrice = fantasyPrice;
            this.teamID = teamID;
        }

        sqlAddingtoBase(){}

        public void ConnectionTeam() throws SQLException{
    
            try{
            
                Connection connection = DriverManager.getConnection(JDBC_URL, username, password);
                connection.setAutoCommit(false);
                Statement statement = connection.createStatement();
                statement.executeUpdate(insertTeam());
            
                connection.commit();
        
        
                } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();    
                }
            }

        //adding the 30 teams in nba, two methods bulding the string and
        private String insertTeam(){

                StringBuilder addQuery = new StringBuilder();

                //teamID on auto_increment, so add name and conference
                addQuery.append("INSERT INTO team (name, conference) VALUES ('");
                addQuery.append(teamName).append("', '").append(conference).append("');");
            
                return addQuery.toString();
            
        }
        //add sql command to histry
        public void addToCommandHistory(String type){

            String path =  System.getProperty("user.dir") + "\\SqlCommandHistory.txt";
            String command = "";

            switch (type) {
                case "team":
                    command = insertTeam();
                    break;
                case "player":
                    command = insertPlayer();
                    break;
                case "InGame":
                    command = getGameCommand();
                    break;
                default:
                    break;
            }
             
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

        private String insertPlayer(){

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
                statement.executeUpdate(insertPlayer());
            
                connection.commit();
        
        
                } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();    
                }
        }

        public void addToInGame(String name, String points, String assists, String rebounds, String steals, String blocks, String turnovers) throws SQLException{

            getDataFromSql playerID = new getDataFromSql(name, teamName);

            try{
            
                Connection connection = DriverManager.getConnection(JDBC_URL, username, password);
                connection.setAutoCommit(false);
                Statement statement = connection.createStatement();
                statement.executeUpdate(insertInGame(playerID.getPlayerID(), points, assists, rebounds, steals, blocks, turnovers));
                addToCommandHistory("InGame");
            
                connection.commit();
        
        
                } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();    
                }
        }

        private String insertInGame(int playerID, String points, String assists, String rebounds, String steals, String blocks, String turnovers) {
                
                StringBuilder addQuery = new StringBuilder();
    

                addQuery.append("INSERT INTO ottelussa (playerID, points, boards, assists, blocks, steals, turnovers) VALUES ('");
                addQuery.append(playerID).append("', '").append(points).append("', '").append(rebounds).append("', '").append(assists).append("', '").append(blocks).append("', '").
                append(steals).append("', '").append(turnovers).append("');");
                
                gameCommand = addQuery.toString();
                return addQuery.toString();
        }

        public String getGameCommand(){
            return gameCommand;
        }
        
    }