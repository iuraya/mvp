package com.mvp;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.mvp.exception.FileWithBugException;


/**
 * Class that process the tournament data indicating who is the MVP
 */
public class Tournament {

    private FileProcessor fileProcessor;
    private Map<String, PlayerOverall> playerList;

    public Tournament() {

        fileProcessor = new FileProcessor();
        playerList = new HashMap<String, PlayerOverall>();
    }

    /**
     * Load the games data files and calculate the rating of each player through all the games played, determining
     * who is the player with greatest rating.
     *
     * @param fileList List of file paths
     * @return the MVP player
     * @throws FileWithBugException
     */
    public PlayerOverall calculateMvp(List<String> fileList) throws FileWithBugException, FileNotFoundException {

        List<Game> games = fileProcessor.extractGames(fileList);

        //Merge the player stats from all the games to get the player overall stats
        for (Game game : games) {
            for (Player player : game.getPlayerList()) {

                if (playerList.get(player.getNickName()) == null) {
                    playerList.put(player.getNickName(), new PlayerOverall(player));
                } else {
                    playerList.put(player.getNickName(), mergePlayerStats(playerList.get(player.getNickName()),
                            player));
                }
            }
        }

        return getMvp(playerList);
    }

    /**
     * Merge the stats for of two players
     *
     * @param player1
     * @param player2
     * @return
     */
    private PlayerOverall mergePlayerStats(PlayerOverall player1, Player player2) {
        return player1.mergeStats(player2);
    }

    /**
     * Method that loops a list of player stats and return the player with the highest rating
     *
     * @param playerStats list of player rating points
     * @return the player with the most rating points
     */
    public PlayerOverall getMvp(Map<String, PlayerOverall> playerStats) {

        PlayerOverall result = null;

        Iterator it = playerStats.entrySet().iterator();

        //Find the player with the most rating points
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();
            if (result == null) {
                result = (PlayerOverall) pair.getValue();
            } else {
                PlayerOverall tempPlayer = (PlayerOverall) pair.getValue();

                result = result.getRatingPoints() > tempPlayer.getRatingPoints() ? result : tempPlayer;
            }
        }

        return result;
    }
}
