package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.content.Context;

import com.example.slothlord.musicstreamingapp.POJO.NewsArticle;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIClient;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by slothlord on 11/6/17.
 */

public class NewsFeedController {

    volatile Context cxt;
    ArrayList<NewsArticle> articles = new ArrayList<NewsArticle>();

    public NewsFeedController(Context cxt) { this.cxt = cxt; }

    public ArrayList<NewsArticle> retrieveNews() {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<NewsArticle> call = apiInterface.getNews();

        call.enqueue(new Callback<NewsArticle>() {
            @Override
            public void onResponse(Call<NewsArticle> call, Response<NewsArticle> response) {

            }

            @Override
            public void onFailure(Call<NewsArticle> call, Throwable t) {

            }
        });

        return articles;
    }
}
