package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slothlord.musicstreamingapp.R;

/**
 * Created by Luis on 11/18/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
//    public TextView description;
    public ImageView background;

    public MyViewHolder(View v) {
        super(v);
        title = (TextView) v.findViewById(R.id.card_title);
//        description = (TextView) v.findViewById(R.id.card_description);
        background = (ImageView) v.findViewById(R.id.backgroundId);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("Cover Image Pressed");
            }
        });
    }
}