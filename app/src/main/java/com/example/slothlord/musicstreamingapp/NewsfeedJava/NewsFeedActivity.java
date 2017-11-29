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
        NewsCard n = new NewsCard("Hello", "Hey there!", R.mipmap.im_music);
        cardList.add(n);

        n = new NewsCard("World", "lk;af asdlk;fj aslk;dfj a;sldfj asdjf lk;asdjf ;ladjsfl;asjk df;lkadfjs ", R.mipmap.im_music);
        cardList.add(n);

        n = new NewsCard("1", "Hey there!", R.mipmap.im_music);
        cardList.add(n);

        n = new NewsCard("2", "Hey there!", R.mipmap.im_music);
        cardList.add(n);

        n = new NewsCard("3", "Hey there!", R.mipmap.im_music);
        cardList.add(n);

        adapter.notifyDataSetChanged();
    }
}
