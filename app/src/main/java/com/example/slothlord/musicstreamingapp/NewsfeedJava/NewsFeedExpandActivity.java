package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slothlord.musicstreamingapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewsFeedExpandActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        image = (ImageView) findViewById(R.id.ex_image);
        title = (TextView) findViewById(R.id.ex_title);
        description = (TextView) findViewById(R.id.ex_description);


    }
}
