package com.example.slothlord.musicstreamingapp.RetrofitResources;

import com.example.slothlord.musicstreamingapp.POJO.MultipleResource;
import com.example.slothlord.musicstreamingapp.POJO.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by Andrew Schaffer on 11/16/2017.
 */

public interface APIInterface {

    @GET("/createSession.php")
    Call<User> authenticateUser();

    @GET("/addUser.php")
    Call<User> createUser(@Body User user);
}
