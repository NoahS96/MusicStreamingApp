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
 */

public class LoginController { //extends AsyncTask<Void, Void, Void> {

    User user = null;

    //Should change the return type to boolean or User
    public User checkCredentials(String email, String password) {

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<User> call = apiInterface.authenticateUser(email, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("TAG", response.code()+"");
                user = response.body();
                System.out.println("Response: " + response);
                System.out.println(user.toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                call.cancel();
                System.out.println("Authentication Call Failed");
            }
        });

        return user;
    }
}
