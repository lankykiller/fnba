package com.example.databasebuilding;


import java.sql.SQLException;
import java.util.ArrayList;

import com.example.webScarping.playerBoxScore;


public class updatingGames{

    private ArrayList<playerBoxScore> playerBoxScore;

    public updatingGames(ArrayList<playerBoxScore> playerBoxScores){

            this.playerBoxScore = playerBoxScores;
    }

    public void addBoxScores() throws SQLException{

        for(int index = 0; index < playerBoxScore.size() ; index++){
        
        insertInGame newPlayerData = new insertInGame(playerBoxScore.get(index).getName(), playerBoxScore.get(index).getPoints(), playerBoxScore.get(index).getAssists(), playerBoxScore.get(index).getRebounds(), playerBoxScore.get(index).getSteals(), playerBoxScore.get(index).getBlocks(), playerBoxScore.get(index).getTurnovers());
        newPlayerData.addToInGame();
        //System.out.println(playerBoxScore.get(index).getName() + playerBoxScore.get(index).getPoints());

        }
    }

    
}
