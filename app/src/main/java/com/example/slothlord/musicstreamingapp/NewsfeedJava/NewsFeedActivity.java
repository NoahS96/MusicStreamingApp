package com.example.slothlord.musicstreamingapp.NewsfeedJava;

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
import android.widget.ListView;

import com.example.slothlord.musicstreamingapp.R;

import java.util.ArrayList;

public class NewsFeedActivity extends AppCompatActivity {

    private Toolbar toolbar;
    String TITLES[] = {"News Feed", "Radios", "Media Player", "Alarm"};
    int ICONS[] = {R.drawable.ic_news_feed, R.drawable.ic_radios, R.drawable.ic_media_player, R.drawable.ic_alarm};

    String NAME = "Akash Bangad";
    String EMAIL = "akash.bangad@android4devs.com";
    int PROFILE = R.mipmap.ic_sexi_man;

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;


    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<NewsCard> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_feed);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call
        toolbar.bringToFront();                         //did nothing

        /*mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new MyAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }



        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State

    }*/


        /*^^^Drawer Initializations^^^^*/

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

