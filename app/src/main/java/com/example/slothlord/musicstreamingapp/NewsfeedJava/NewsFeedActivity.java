package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.slothlord.musicstreamingapp.R;

import java.util.ArrayList;

public class NewsFeedActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<NewsCard> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_feed);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call
        toolbar.bringToFront();

        recyclerView = (RecyclerView) findViewById(R.id.cardView);



                 cardList = new ArrayList<>();

        adapter = new CardAdapter(cardList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        retrieveNews();

    }

    private void retrieveNews() {
        NewsCard n = new NewsCard("The 'Despacito' Story Continues", "The \"Despacito\" phenomenon continues with this morning's announcement of the 2018 Grammy nominations.", R.mipmap.card1bkg);
        cardList.add(n);

        n = new NewsCard("Grammy Nominations Name", "Name Kendrick Lamar, Luis Fonsi, Kesha In Top Categories", R.mipmap.card2bkg);
        cardList.add(n);

        n = new NewsCard("Steely Dan Inc. Fights Itself In Lawsuit Over Shares", "Steely Dan, the artistic partnership of Donald Fagen and Walter Becker", R.mipmap.card3bkg);
        cardList.add(n);

        n = new NewsCard("Celebrating 100 Years Of Bernstein With Gianandrea Noseda", "In Washington, D.C., the choice was made with astonishing harmony.", R.mipmap.card4bkg);
        cardList.add(n);

        adapter.notifyDataSetChanged();
    }
}
