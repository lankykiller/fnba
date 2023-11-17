package com.example.databasebuilding;


import java.sql.SQLException;
import java.util.ArrayList;


import com.example.webScarping.playerBoxScore;


public class updatingGames {

    private ArrayList<playerBoxScore> playerBoxScore;
    private String playerID;

    public updatingGames(ArrayList<playerBoxScore> playerBoxScores){

            this.playerBoxScore = playerBoxScores;
    }

    public void addBoxScores() throws SQLException{

        sqlAddingtoBase newPlayerData = new sqlAddingtoBase();
        

        for(int index = 0; index < playerBoxScore.size() ; index++){

            //System.out.println(playerBoxScore.get(index).getName() + playerBoxScore.get(index).getPoints());
            newPlayerData.addToInGame(playerBoxScore.get(index).getName(), playerBoxScore.get(index).getPoints(), playerBoxScore.get(index).getAssists(), playerBoxScore.get(index).getRebounds(), playerBoxScore.get(index).getSteals(), playerBoxScore.get(index).getBlocks(), playerBoxScore.get(index).getTurnovers());

        }
    }

    public String getPlayerID(){
        return playerID;
    }

    public void setPlayerID(String name){

       
    }
    
}
