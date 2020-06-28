package org.lightfor.spider;

import lombok.Data;

import java.util.List;

@Data
public class DoubanGameResp {

    private List<Game> games;

    @Data
    static class Game{
        private String genres;
        private List<String> genreList;
        private int n_ratings;
        private String platforms;
        private List<String> platformList;
        private float rating;
        private String title;
        private long id;
    }
}