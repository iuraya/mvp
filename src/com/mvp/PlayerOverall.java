package com.mvp;


public class PlayerOverall {

    private final String nickName;
    private int ratingPoints;

    public PlayerOverall(Player player) {
        this.nickName = player.getNickName();
        ratingPoints = player.calculateRating();
    }

    public PlayerOverall mergeStats(Player player2) {
        ratingPoints += player2.calculateRating();
        return this;
    }

    public int getRatingPoints() {
        return ratingPoints;
    }

    public String getNickName() {
        return nickName;
    }
}
