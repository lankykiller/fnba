package com.example.databasebuilding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.dataStructures.queue;
import com.example.makePlayers.player;

public class getPlayerStats implements sqlAddingtoBase{

    public  queue<player> playerQueue = new queue<>();

    @Override
    public void addToCommandHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToCommandHistory'");
    }

    public void getPlayerBoxscores(){
   
        try {

            Connection connection = DriverManager.getConnection(JDBC_URL, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getPlayerStatsQuery());

            while (result.next()) {
                String lastName = result.getString("LastName");
                String firstName = result.getString("FirstName");
                int totalPoints = result.getInt("totalPoints");
                int totalAssist = result.getInt("totalAssist");
                int totalRebounds = result.getInt("totalRebounds");
                int totalBlocks = result.getInt("totalBlocks");
                int totalSteals = result.getInt("totalSteals");
                int totalTurnovers = result.getInt("totalTurnovers");
                player newPlayer = new player(lastName, firstName, totalPoints, totalAssist, totalRebounds, totalBlocks, totalSteals, totalTurnovers);
                playerQueue.enqueue(newPlayer);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPlayerStatsQuery(){

        StringBuilder getPlayerStats = new StringBuilder();
        getPlayerStats.append("SELECT player.LastName, player.FirstName, ");
        getPlayerStats.append("SUM(ottelussa.points) AS totalPoints, SUM(ottelussa.assists) AS totalAssist, SUM(ottelussa.boards) AS totalRebounds, ");
        getPlayerStats.append("SUM(ottelussa.blocks) AS totalBlocks, SUM(ottelussa.steals) AS totalSteals, SUM(ottelussa.turnovers) AS totalTurnovers "); 
        getPlayerStats.append("FROM player JOIN ottelussa ON player.playerID = ottelussa.playerID GROUP BY player.LastName, player.FirstName;");

        return getPlayerStats.toString();
    }

    public queue<player> getPlayerQueue(){
        return playerQueue;
    }

}
