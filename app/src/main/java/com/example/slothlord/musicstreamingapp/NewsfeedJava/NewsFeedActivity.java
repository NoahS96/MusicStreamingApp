package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        NewsCard n = new NewsCard("Hello", "Hey there!", 0);
        cardList.add(n);

        n = new NewsCard("World", "Hey there!", 0);
        cardList.add(n);

        n = new NewsCard("1", "Hey there!", 0);
        cardList.add(n);

        n = new NewsCard("2", "Hey there!", 0);
        cardList.add(n);

        n = new NewsCard("3", "Hey there!", 0);
        cardList.add(n);

        adapter.notifyDataSetChanged();
    }
}
