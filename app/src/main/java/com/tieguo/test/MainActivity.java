package com.tieguo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tieguo.test.Adapter.MovieAdapter;
import com.tieguo.test.Model.Actor;
import com.tieguo.test.Model.Movie;
import com.tieguo.test.Model.MovieDetail;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> movies = new ArrayList<>();
    MovieAdapter mAdapter;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        initParams();
        mAdapter = new MovieAdapter(this, movies);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                intent.putExtra("movie", movies.get(position).movieDetail);
                startActivity(intent);
            }
        });
    }

    private void initParams() {
        for (int i = 0; i < 10; i++) {
            Movie movie = new Movie();
            movie.name = "Top Gun " + i;
            movie.lastUpdated = i * 10000;


            MovieDetail movieDetail = new MovieDetail();
            movieDetail.name = movie.name;
            Random r = new Random();
            int rand = r.nextInt(10);
            movieDetail.score = rand % 10;
            movieDetail.description = "As students at the United States Navy's elite fighter weapons school compete to be best in the class, one daring young pilot learns a few things from a civilian instructor that are not taught in the classroom.";

            Actor tomCruise = new Actor();
            tomCruise.name = "Tom Cruise";
            tomCruise.age = 50;

            Actor valKilmer = new Actor();
            valKilmer.name = "Val Kilmer";
            valKilmer.age = 46;
            valKilmer.imageUrl = "https://m.media-amazon.com/images/M/MV5BMTk3ODIzMDA5Ml5BMl5BanBnXkFtZTcwNDY0NTU4Ng@@._V1_UY317_CR4,0,214,317_AL_.jpg";

            movieDetail.actors.add(tomCruise);
            movieDetail.actors.add(valKilmer);

            if (i % 2 == 0) {
                Actor timRobbins = new Actor();
                timRobbins.name = "Tim Robbins";
                timRobbins.age = 55;
                timRobbins.imageUrl = "https://m.media-amazon.com/images/M/MV5BMTI1OTYxNzAxOF5BMl5BanBnXkFtZTYwNTE5ODI4._V1_UY317_CR16,0,214,317_AL_.jpg";

                movieDetail.actors.add(timRobbins);
            } else {
                Actor jenniferConnelly = new Actor();
                jenniferConnelly.name = "Jennifer Connelly";
                jenniferConnelly.age = 39;
                jenniferConnelly.imageUrl = "https://m.media-amazon.com/images/M/MV5BOTczNTgzODYyMF5BMl5BanBnXkFtZTcwNjk4ODk4Mw@@._V1_UY317_CR12,0,214,317_AL_.jpg";

                movieDetail.actors.add(jenniferConnelly);
            }

            movie.movieDetail = movieDetail;
            movies.add(movie);
        }
    }
}
