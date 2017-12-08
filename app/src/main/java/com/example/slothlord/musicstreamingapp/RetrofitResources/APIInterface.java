package com.example.slothlord.musicstreamingapp.RetrofitResources;

import com.example.slothlord.musicstreamingapp.POJO.MultipleResource;
import com.example.slothlord.musicstreamingapp.POJO.NewsArticle;
import com.example.slothlord.musicstreamingapp.POJO.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Andrew Schaffer on 11/16/2017.
 */

public interface APIInterface {

    @GET("/createSession.php")
    Call<User> authenticateUser(@Query("email") String email, @Query("password") String password);

    @GET("/addUser.php")
    Call<User> createUser(@Query("email") String email, @Query("password") String password);

    @GET("/getnews.php")
    Call<NewsArticle>  getNews();
}
