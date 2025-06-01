/*
 * TMDB Movie Metadata Viewer
 *
 * This is part of the Teleparty Android Developer Interview (Bonus Task).
 *
 * Please refer to the README.md file at the root of this project
 * for setup instructions, API key configuration, and other details.
 *
 * Thank you!
 */
package com.example.telepartybonusapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // UI elements
    private EditText editTextMovieId;
    private Button btnFetch, btnReset;
    private ProgressBar progressBar;
    private TextView textViewTitle, textViewReleaseDate, textViewOverview;
    private TextView textViewRuntime, textViewGenres, textViewVoteAverage;

    // TMDB API key (used to authenticate requests)
    private static final String API_KEY = "6e9a753fb216bd3136b6458cf2f91943";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI elements with layout components
        editTextMovieId = findViewById(R.id.editTextMovieId);
        btnFetch = findViewById(R.id.btnFetch);
        btnReset = findViewById(R.id.btnReset);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewReleaseDate = findViewById(R.id.textViewReleaseDate);
        textViewOverview = findViewById(R.id.textViewOverview);
        textViewRuntime = findViewById(R.id.textViewRuntime);
        textViewGenres = findViewById(R.id.textViewGenres);
        textViewVoteAverage = findViewById(R.id.textViewVoteAverage);
        progressBar = findViewById(R.id.progressBar);

        // Handle Fetch Button click
        btnFetch.setOnClickListener(v -> {
            String movieIdStr = editTextMovieId.getText().toString().trim();

            // Check if user entered a movie ID
            if (TextUtils.isEmpty(movieIdStr)) {
                Toast.makeText(this, "Please enter a movie ID", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate that the input is a valid integer
            int movieId;
            try {
                movieId = Integer.parseInt(movieIdStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid movie ID", Toast.LENGTH_SHORT).show();
                return;
            }

            // Make API call to fetch movie metadata
            fetchMovieMetadata(movieId);
        });

        // Handle Reset Button click
        btnReset.setOnClickListener(v -> {
            // Clear input and result fields
            editTextMovieId.setText("");
            clearResultFields();
        });
    }

    // This method makes the API call to TMDB and handles the response
    private void fetchMovieMetadata(int movieId) {
        // Show loading indicator and disable fetch button
        progressBar.setVisibility(View.VISIBLE);
        btnFetch.setEnabled(false);

        // Create a Retrofit API client and request object
        TMDBApi apiService = ApiClient.getClient().create(TMDBApi.class);
        Call<Movie> call = apiService.getMovieById(movieId, API_KEY);

        // Asynchronous API call
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                // Hide loading indicator and re-enable fetch button
                progressBar.setVisibility(View.GONE);
                btnFetch.setEnabled(true);

                // If API call was successful and movie data is available
                if (response.isSuccessful() && response.body() != null) {
                    Movie movie = response.body();

                    // Populate the UI with metadata
                    textViewTitle.setText("Title: " + movie.title);
                    textViewReleaseDate.setText("Release Date: " + movie.release_date);
                    textViewOverview.setText("Overview: " + movie.overview);
                    textViewRuntime.setText("Runtime: " + movie.runtime + " minutes");
                    textViewVoteAverage.setText("Vote Average: " + movie.vote_average);

                    // Format genres as comma-separated list
                    StringBuilder genresString = new StringBuilder();
                    for (Movie.Genre genre : movie.genres) {
                        genresString.append(genre.name).append(", ");
                    }

                    // Remove trailing comma if present
                    if (genresString.length() > 0) {
                        genresString.setLength(genresString.length() - 2);
                    }

                    textViewGenres.setText("Genres: " + genresString);
                } else {
                    // API responded but something went wrong
                    Toast.makeText(MainActivity.this, "Movie not found or API error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                // Handle failure scenario (e.g., no internet or server down)
                progressBar.setVisibility(View.GONE);
                btnFetch.setEnabled(true);
                Toast.makeText(MainActivity.this, "Failed to fetch data: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    // Clears all the result TextViews (called on reset)
    private void clearResultFields() {
        textViewTitle.setText("Title:");
        textViewReleaseDate.setText("Release Date:");
        textViewOverview.setText("Overview:");
        textViewRuntime.setText("Runtime:");
        textViewGenres.setText("Genres:");
        textViewVoteAverage.setText("Vote Average:");
    }
}