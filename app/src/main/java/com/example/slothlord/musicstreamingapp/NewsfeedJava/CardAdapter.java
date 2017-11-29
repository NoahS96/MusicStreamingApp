package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slothlord.musicstreamingapp.R;

import java.util.ArrayList;

/**
 * Created by Luis on 11/17/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<NewsCard> list;

    public CardAdapter(ArrayList<NewsCard> Data) {
        list = Data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_feed_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.description.setText(list.get(position).getDescription());
        holder.background.setImageResource(list.get(position).getBackground());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
