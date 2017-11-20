package com.example.slothlord.musicstreamingapp.CredentialJava;

import android.util.Log;

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

    public void addUser(String email, String password, String password_conf) {

        if (!password.equals(password_conf)) {
            //Password conf must match password
            return;
        }

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<User> call = apiInterface.createUser(email, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("TAG", response.code()+"");
                String displayResponse = "";

                System.out.println("Response: " + response);
                //Place response variables in a User object
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
                System.out.println("Authentication Call Failed");
            }
        });
    }
}
