package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slothlord.musicstreamingapp.R;

import java.util.List;

/**
 * Created by Luis on 11/17/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    private Context mContext;
    private List<NewsCard> cardList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;
        public int background;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.card_title);
            description = (TextView) view.findViewById(R.id.card_description);
//            background = (int) view.findViewById(R.id.card_background);

        }
    }

    public CardAdapter(Context mContext, List<NewsCard> cardList) {
        this.mContext = mContext;
        this.cardList = cardList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_feed_card, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewsCard card = cardList.get(position);
        holder.title.setText(card.getTitle());
        holder.description.setText(card.getDescription());
        holder.background = card.getBackground();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.print("News pressed\n");
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }




}
