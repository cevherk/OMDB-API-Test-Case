package org.apptest;

import org.junit.Test;

public class AppTest {

    AppTestHelper appTestHelper = new AppTestHelper();

    String apiKey = System.getProperty("apiKey","3016feed");
    String searchWord = System.getProperty("searchWord","harry potter");
    String movieTitle = System.getProperty("movieTitle","Harry Potter and the Sorcerer's Stone");

    @Test
    public void harryPotterSearchAssertion(){

        String id = appTestHelper.getIdFromMovie(apiKey, searchWord, movieTitle);

        appTestHelper.searchByID(apiKey, id);
    }
}