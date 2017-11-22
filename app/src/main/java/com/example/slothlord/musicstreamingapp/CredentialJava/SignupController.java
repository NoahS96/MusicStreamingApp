package com.example.slothlord.musicstreamingapp.CredentialJava;

import android.util.Log;

import com.example.slothlord.musicstreamingapp.POJO.User;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIClient;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIInterface;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrew Schaffer on 10/31/2017.
 */

public class SignupController {

    User user = null;

    public User addUser(String email, String password, String password_conf) {

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<User> call = apiInterface.createUser(email, password);

        try {
            user = call.execute().body();
        } catch (IOException e) {
            System.err.println("Server Comms Error: " + e);
            user = null;
        }
        //Use execute instead
        /*call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("TAG", response.code()+"");
                user = response.body();

                System.out.println("Response: " + response);
                System.out.println(user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
                System.out.println("Authentication Call Failed");
            }
        });*/

        return user;
    }
}
