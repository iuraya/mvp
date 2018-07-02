package com.mvp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileProcessor {

    private static final String FIELD_SEPARATOR = ";";
    public static final String TEAM_A = "Team A";
	public static final String TEAM_B = "Team B";
    private Scanner scanner;
    

    /**
     * Method that read and parse the file with the game result
     *
     * @param fileList Path of the files to read
     * @return List of games
     */
    public List<Game> extractGames(List<String> fileList) throws FileNotFoundException {

        List<Game> result = new ArrayList<Game>();

        for (String path : fileList) {
            scanner = new Scanner(new File(path));
            Game game = new Game(scanner.nextLine());

            int pointsTeamA = 0;
            int pointsTeamB = 0;

            // Read the player game stats
            while (scanner.hasNext()) {

                String row = scanner.nextLine();

                Player player = game.addPlayerStats(game.getSport(), row.split(FIELD_SEPARATOR));
                if (player.getTeam().equals(TEAM_A)) {
                    pointsTeamA += player.getPointsScore();
                } else {
                    pointsTeamB += player.getPointsScore();
                }
            }

            //indicate who won the game
            game.updateWinner(pointsTeamA > pointsTeamB ? TEAM_A : TEAM_B);

            result.add(game);
        }

        return result;
    }
}
