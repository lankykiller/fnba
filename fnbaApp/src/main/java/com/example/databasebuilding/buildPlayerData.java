package com.example.databasebuilding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class buildPlayerData {

            private String firstName;
            private String lastName;
            private double fantasyPrice;
            private int teamID;

            public buildPlayerData(){}        
            
            public buildPlayerData(String fileName){
                buildPlayerInfo(fileName);
            }

            public buildPlayerData(String firstname, String lastName, Double fantasyPrice, int teamID){
                buildPlayerInfo(firstname, lastName, fantasyPrice, teamID);
            }

            public void buildPlayerInfo(String fileName){
            
            Scanner scanner = new Scanner(System.in);
            
            String filePath =  System.getProperty("user.dir") + "\\" + fileName;
            // read firstname, lastname, teamid from file, fantasyprice asked
            try{
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String line = br.readLine();
             
                while (line != null){
                    
                    String[] parts = line.split("\\s+");
                    if(parts.length >= 3){
                    firstName = parts[0];
                    lastName = parts[1];
                    
                    try{
                    teamID = Integer.parseInt(parts[2]);
                        }catch(Exception ex){
                            System.out.println("team id was not correctly given");
                        }
                    
                    System.out.println("Enter fantasy price for " + firstName + " " + lastName + ": ");
                    fantasyPrice = scanner.nextDouble();
                    
                    
                    try{
                    insertPlayer player = new insertPlayer(firstName, lastName, fantasyPrice, teamID);
                    player.ConnectionPlayer();
                        }
                        catch (SQLException e){
                        System.out.println("Error connecting to database");
                        e.printStackTrace();
                        }

                    }else{
                        System.out.println("Invalid data format: " + line);
                    }

                    line = br.readLine();
                }
                scanner.close();
                br.close();

                } catch (IOException e){
                System.out.println("Error reading file");
                e.printStackTrace();
                }
               
            }

            public void buildPlayerInfo(String firstname, String lastName, Double fantasyPrice, int teamID){
            
            this.firstName = firstname;
            this.lastName = lastName;
            this.fantasyPrice = fantasyPrice;
            this.teamID = teamID;
               
              try{
                    insertPlayer player = new insertPlayer(firstName, lastName, fantasyPrice, teamID);
                    player.ConnectionPlayer();
                        }
                        catch (SQLException e){
                        System.out.println("Error connecting to database");
                        e.printStackTrace();
                        }
            }

    
}
