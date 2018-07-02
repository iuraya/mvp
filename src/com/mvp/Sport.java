package com.mvp;


public abstract class Sport implements SportInterface {

    
	public static final int BONUS_WINNER_TEAM = 10;

    private String position;
    private int numberWinningGames;
    
    
    public Sport(String[] stats) {
        numberWinningGames = 0;
        setPosition(stats[4]);
    }

    public int increaseWinnerGamesCounter() {
        return this.numberWinningGames++;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public int getNumberWinningGames() {
        return numberWinningGames;
    }

}
