package com.example.telepartybonusapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBApi {
    @GET("movie/{movie_id}")
    Call<Movie> getMovieById(
            @Path("movie_id") int movieId,
            @Query("api_key") String apiKey
    );
}