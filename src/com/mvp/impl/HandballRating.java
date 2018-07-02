package com.mvp.impl;

import com.mvp.Sport;


public class HandballRating extends Sport {

    private static final String GOAL_KEEPER = "G";
    private static final String FIELD_PLAYER = "F";
    
    private int initialRatingPoints;
    private int goalMade;
    private int goalReceived;

    
    public HandballRating(String[] stats) {
        super(stats);
        this.initialRatingPoints = 0;
        this.goalMade = Integer.parseInt(stats[5]);
        this.goalReceived = Integer.parseInt(stats[6]);
    }
    
    @Override
    public int calculateRating() {
        int result = 0;

        if (this.getPosition().equals(GOAL_KEEPER)) {
            result += this.getInitialRatingPoints() * 50 + this.getGoalMade() * 5 - this.getGoalReceived() * 2;
        } else if(this.getPosition().equals(FIELD_PLAYER)) {
            result += this.getInitialRatingPoints() * 20 + this.getGoalMade() * 1 - this.getGoalReceived() * 1;
        }

        result += this.getNumberWinningGames() * BONUS_WINNER_TEAM;

        return result;
    }

    @Override
    public int getScore() {
        return getGoalMade();
    }

    public int getInitialRatingPoints() {
        return initialRatingPoints;
    }

    public int getGoalMade() {
        return goalMade;
    }

    public int getGoalReceived() {
        return goalReceived;
    }
    
}
