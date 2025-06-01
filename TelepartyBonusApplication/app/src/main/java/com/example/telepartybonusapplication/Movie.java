package com.example.telepartybonusapplication;

import java.util.List;

public class Movie {
    public String title;
    public String overview;
    public String release_date;

    public int runtime;
    public List<Genre> genres;
    public double vote_average;

    public static class Genre {
        public String name;
    }
}