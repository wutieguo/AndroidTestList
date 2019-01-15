package com.tieguo.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.tieguo.test.Adapter.ActorAdapter;
import com.tieguo.test.Adapter.MovieAdapter;
import com.tieguo.test.Model.Actor;
import com.tieguo.test.Model.Movie;
import com.tieguo.test.Model.MovieDetail;

public class MovieDetailActivity extends AppCompatActivity {
    MovieDetail movieDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        movieDetail = (MovieDetail) getIntent().getExtras().getSerializable("movie");
        if(movieDetail != null){
            setTitle(movieDetail.name);
            initUI();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initUI() {
        ((TextView)findViewById(R.id.txtName)).setText(movieDetail.name);
        ((TextView)findViewById(R.id.txtScore)).setText("score"+movieDetail.score);
        ((TextView)findViewById(R.id.txtDescription)).setText(movieDetail.description);
        ListView listView = findViewById(R.id.listView);
        ActorAdapter mAdapter = new ActorAdapter(this, movieDetail.actors);
        listView.setAdapter(mAdapter);
    }

}
