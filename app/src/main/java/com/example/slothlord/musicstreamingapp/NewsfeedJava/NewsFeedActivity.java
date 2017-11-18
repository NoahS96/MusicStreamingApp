package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.slothlord.musicstreamingapp.R;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private List<NewsCard> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        cardList = new ArrayList<>();
        adapter = new CardAdapter(this, cardList);

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
