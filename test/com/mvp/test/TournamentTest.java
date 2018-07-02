package com.mvp.test;

import com.mvp.PlayerOverall;
import com.mvp.Tournament;
import com.mvp.exception.FileWithBugException;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class TournamentTest {

    private Tournament tournament;
    private List<String> filesWithNoErrors;
    
    private String filePath1 = "files/game1.txt";
    private String filePath2 = "files/game2.txt";

    @Before
    public void setUp() {
        tournament = new Tournament();
        filesWithNoErrors = new ArrayList<String>();
    }

    @Test
    public void calculateMvpTournament() throws FileWithBugException, FileNotFoundException {
    	filesWithNoErrors.add(filePath1);
    	filesWithNoErrors.add(filePath2);

        PlayerOverall player = tournament.calculateMvp(filesWithNoErrors);

        assertNotNull(player); 
        assertEquals("The player nickname is incorrect", player.getNickName(), "nick3");
        assertEquals("The player rating is incorrect", player.getRatingPoints(), 52);
    }

}
