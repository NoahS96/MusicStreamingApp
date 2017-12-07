package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.slothlord.musicstreamingapp.R;

import java.util.ArrayList;

public class NewsFeedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<NewsCard> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        recyclerView = (RecyclerView) findViewById(R.id.cardView);

        cardList = new ArrayList<>();

        adapter = new CardAdapter(cardList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        retrieveNews();

    }

    private void retrieveNews() {
        NewsCard n = new NewsCard("The 'Despacito' Story Continues", R.mipmap.card1bkg);
        cardList.add(n);

        n = new NewsCard("Grammy Nominations Name", R.mipmap.card2bkg);
        cardList.add(n);

        n = new NewsCard("Steely Dan Inc. Fights Itself In Lawsuit Over Shares", R.mipmap.card3bkg);
        cardList.add(n);

        n = new NewsCard("Celebrating 100 Years Of Bernstein With Gianandrea Noseda", R.mipmap.card4bkg);
        cardList.add(n);

        adapter.notifyDataSetChanged();
    }
}
