package com.example.slothlord.musicstreamingapp.CredentialJava;


import com.example.slothlord.musicstreamingapp.POJO.User;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIClient;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIInterface;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrew Schaffer on 10/27/2017.
 * www.journaldev.com/13639/retrofit-android-example-tutorial
 */

public class LoginController { //extends AsyncTask<Void, Void, Void> {

    //Should change the return type to boolean or User
    public void checkCredentials(String email, String password) {

        //User user = new User(email, password);
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<User> call = apiInterface.authenticateUser(email, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("TAG", response.code()+"");
                String displayResponse = "";

                System.out.println("Response: " + response);
                //Place response variables in a User object
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                call.cancel();
                System.out.println("Authentication Call Failed");
            }
        });


    }
}
