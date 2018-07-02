package com.mvp.test;

import com.mvp.FileProcessor;
import com.mvp.Game;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class FileProcessorTest {

    private String filePath1 = "files/game1.txt";

    private FileProcessor fileProcessor;

    @Before
    public void setUp() {
        fileProcessor = new FileProcessor();
    }

    @Test
    public void readFile() throws FileNotFoundException {
        List<String> list = new ArrayList<String>();
        list.add(filePath1);
        List<Game> result = fileProcessor.extractGames(list);
        assertEquals("File processing failure", 1, result.size());
    }

    @Test(expected = FileNotFoundException.class)
    public void readFileNotFound() throws FileNotFoundException {
        List<String> list = new ArrayList<String>();
        list.add("111");
        fileProcessor.extractGames(list);
    }

}
