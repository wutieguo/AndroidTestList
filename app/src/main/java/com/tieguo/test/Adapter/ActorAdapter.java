package com.tieguo.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tieguo.test.Model.Actor;
import com.tieguo.test.R;

import java.util.ArrayList;

/**
 * Created by Tieguo Wu on 1/15/2019.
 */

public class ActorAdapter extends ArrayAdapter<Actor> {
    private final Context mContext;
    private final ArrayList<Actor> mItems;

    public ActorAdapter(Context context, ArrayList<Actor> items) {
        super(context, R.layout.list_adapter_detail, items);
        this.mItems = items;
        this.mContext=context;
    }
    @Override
    public Actor getItem(int position){
        return mItems.get(position);
    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View itemView = convertView;
        LayoutInflater inflater;
        MovieInfoHolder holder = null;
        final Actor actor = getItem(position);
        if(itemView == null) {
            inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = (View)inflater.inflate(R.layout.list_adapter_detail, parent, false);
            holder = new MovieInfoHolder();
            holder.txtName = (TextView)itemView.findViewById(R.id.txtName);
            holder.txtAge = (TextView)itemView.findViewById(R.id.txtAge);
            holder.imgView = (ImageView) itemView.findViewById(R.id.imgView);
            itemView.setTag(holder);
        } else {
            holder = (MovieInfoHolder)itemView.getTag();
        }
        holder.txtName.setText(actor.name);
        holder.txtAge.setText("Age:" + actor.age);
        if(actor.imageUrl != null && actor.imageUrl.length() > 0){
            Picasso.get().load(actor.imageUrl).placeholder(R.drawable.ic_launcher_background).into(holder.imgView);
        }
        return itemView;
    }

    static class MovieInfoHolder{
        TextView txtName;
        TextView  txtAge;
        ImageView imgView;
    }
}
