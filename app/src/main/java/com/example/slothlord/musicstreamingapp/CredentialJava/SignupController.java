package com.example.slothlord.musicstreamingapp.CredentialJava;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.slothlord.musicstreamingapp.NewsfeedJava.NewsFeedActivity;
import com.example.slothlord.musicstreamingapp.POJO.User;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIClient;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrew Schaffer on 10/31/2017.
 */

public class SignupController {

    User user = null;
    volatile Context cxt;

    public SignupController(Context context) {
        cxt = context;
    }

    /**
     * Takes an email and password and sends them asynchronously to login server. Based on the
     * status response the controller will either create a toast or move to the newsFeed screen.
     * If the user object is needed for the next activity it can be passed in a bundle.
     * @param email
     * @param password
     * @param password_conf
     * @return
     */
    public User addUser(String email, String password, String password_conf) {

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<User> call = apiInterface.createUser(email, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("TAG", response.code()+"");
                user = response.body();

                System.out.println("Response: " + response);
                System.out.println(user.toString());

                if (user.status.equals(("USER_ALREADY_EXISTS"))) {
                    Toast.makeText(cxt, "User Already Exists", Toast.LENGTH_SHORT).show();
                } else if (user.status.equals("ADD_USER_ERROR")) {
                    Toast.makeText(cxt, "User Creation Error", Toast.LENGTH_SHORT).show();
                } else if (user.status.equals("USER_ADDED")) {
                    Intent myIntent = new Intent(cxt, NewsFeedActivity.class);
                    cxt.startActivity(myIntent);
                } else {
                    Toast.makeText(cxt, "Unknown Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
                System.out.println("Authentication Call Failed");
            }
        });

        return user;
    }
}
