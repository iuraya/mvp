package com.mvp;


import com.mvp.impl.BasketballRating;
import com.mvp.impl.HandballRating;

/**
 * Class that stores the player stats for an specific game and sport
 */
public class Player {

    private String nickName;
    private SportInterface sport;
    private String team;
    

    public Player(String nickName, String team) {
        this.nickName = nickName;
        setTeam(team);
    }

    public int calculateRating() {
        return sport.calculateRating();
    }

    public String getNickName() {
        return nickName;
    }

    public void addStats(SportEnum sportEnum, String[] fields) {
        if (sportEnum.equals(SportEnum.BASKETBALL)) {
            sport = new BasketballRating(fields);
        } else {
            sport = new HandballRating(fields);
        }
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPointsScore() {
        return sport.getScore();
    }
    
    public void increaseWinnerCounter() {
        sport.increaseWinnerGamesCounter();
    }

}
