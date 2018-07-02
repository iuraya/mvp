package com.mvp;


public interface SportInterface {

    int calculateRating();

    int increaseWinnerGamesCounter();

    /**
     * @return Value for knowing the winning game
     */
    int getScore();

}
