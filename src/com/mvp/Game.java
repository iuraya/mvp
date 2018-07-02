package com.mvp;

import java.util.ArrayList;
import java.util.List;


public class Game {

    private SportEnum sport;
    private List<Player> playerList;
    

    public Game(String gameName) {
        playerList = new ArrayList<Player>();
        sport = gameName.equals(SportEnum.BASKETBALL.name()) ? SportEnum.BASKETBALL : SportEnum.HANDBALL;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Player addPlayerStats(SportEnum sport, String[] fields) {
        String nickName = fields[1];
        String team = fields[3];
        Player player = new Player(nickName, team);
        player.addStats(sport, fields);
        playerList.add(player);
        return player;
    }

    public SportEnum getSport() {
        return sport;
    }

    /**
     * Update the winner counter for the player that played the game with the winnerTeam
     * @param winnerTeam
     */
    public void updateWinner(String winnerTeam) {
        for (Player player: playerList) {
            if(player.getTeam().equals(winnerTeam)) {
                player.increaseWinnerCounter();
            }
        }
    }
}
