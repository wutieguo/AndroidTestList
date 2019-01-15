package com.tieguo.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tieguo.test.Model.Movie;
import com.tieguo.test.R;

import java.util.ArrayList;

/**
 * Created by Tieguo Wu on 1/15/2019.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {
    private final Context mContext;
    private final ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.list_adapter_movie, movies);
        this.movies = movies;
        this.mContext=context;
    }
    @Override
    public Movie getItem(int position){
        return movies.get(position);
    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View itemView = convertView;
        LayoutInflater inflater;
        MovieInfoHolder holder = null;
        final Movie movie = getItem(position);
        if(itemView == null) {
            inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = (View)inflater.inflate(R.layout.list_adapter_movie, parent, false);
            holder = new MovieInfoHolder();
            holder.txtName = (TextView)itemView.findViewById(R.id.txtName);
            itemView.setTag(holder);
        } else {
            holder = (MovieInfoHolder)itemView.getTag();
        }
        holder.txtName.setText(movie.name);
        return itemView;
    }

    static class MovieInfoHolder{
        TextView txtName;
    }
}
