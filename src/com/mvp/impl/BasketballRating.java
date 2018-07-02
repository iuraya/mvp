package com.mvp.impl;

import com.mvp.Sport;


public class BasketballRating extends Sport {

    private static final String GUARD = "G";
    private static final String FORWARD = "F";
    private static final String CENTER = "C";
    
    private int scoredPoint;
    private int rebound;
    private int assist;

    
    public BasketballRating(String[] stats) {
        super(stats);
        this.scoredPoint = Integer.parseInt(stats[5]);
        this.rebound = Integer.parseInt(stats[6]);
        this.assist = Integer.parseInt(stats[7]);
    }

    
    @Override
    public int calculateRating() {
        int result = 0;

        if (this.getPosition().equals(GUARD)) {
            result += this.getScoredPoint() * 2 + this.getRebound() * 3 + this.getAssist() * 1;
        } else if(this.getPosition().equals(FORWARD)) {
            result += this.getScoredPoint() * 2 + this.getRebound() * 2 + this.getAssist() * 2;
        } else if(this.getPosition().equals(CENTER)) {
            result += this.getScoredPoint() * 2 + this.getRebound() * 1 + this.getAssist() * 3;
        }

        result += this.getNumberWinningGames() * BONUS_WINNER_TEAM;

        return result;
    }

    @Override
    public int getScore() {
        return getScoredPoint();
    }
    
    public int getScoredPoint() {
        return scoredPoint;
    }

    public int getRebound() {
        return rebound;
    }

    public int getAssist() {
        return assist;
    }
}
