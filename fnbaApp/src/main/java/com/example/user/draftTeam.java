package com.example.user;

import com.example.makePlayers.player;

public class draftTeam {

    private player[] team = new player[5];

    public draftTeam(player player1, player player2, player player3, player player4, player player5){

        team[0] = player1;
        team[1] = player2;
        team[2] = player3;
        team[3] = player4;
        team[4] = player5;
    }

    public player[] getTeam(){
        return team;
    }

    public void setCaptain(player player){

        player.setCaptain();
        
    }
    
}
