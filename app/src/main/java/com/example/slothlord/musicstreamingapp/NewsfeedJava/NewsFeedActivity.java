package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.slothlord.musicstreamingapp.AlarmJava.AlarmListActivity;
import com.example.slothlord.musicstreamingapp.MediaPlayer.MediaPlayerActivity;
import com.example.slothlord.musicstreamingapp.R;
import com.example.slothlord.musicstreamingapp.RadioStationJava.RadioStationsActivity;

import java.util.ArrayList;

public class NewsFeedActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {


    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<NewsCard> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_feed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.cardView);



                 cardList = new ArrayList<>();

        adapter = new CardAdapter(cardList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        retrieveNews();
    }


    //}

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


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_alarm) {
            intent = new Intent(this,AlarmListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(intent);
        } else if (id == R.id.nav_news_feed) {
            intent = new Intent(this,NewsFeedActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(intent);
        } else if (id == R.id.nav_player) {
            intent = new Intent(this,MediaPlayerActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(intent);
        } else if (id == R.id.nav_radios) {
            intent = new Intent(this,RadioStationsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

//}

