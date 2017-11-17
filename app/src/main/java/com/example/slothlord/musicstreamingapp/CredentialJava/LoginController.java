package com.example.slothlord.musicstreamingapp.CredentialJava;


import com.example.slothlord.musicstreamingapp.POJO.User;
import com.example.slothlord.musicstreamingapp.POJO.createUserResponse;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIClient;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIInterface;
import com.example.slothlord.musicstreamingapp.RetrofitResources.NetworkController;

import android.os.AsyncTask;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrew Schaffer on 10/27/2017.
 * www.journaldev.com/13639/retrofit-android-example-tutorial
 */

public class LoginController { //extends AsyncTask<Void, Void, Void> {

    NetworkController net_info = new NetworkController();

    public void checkCredentials(String username, String password) {

        User user = new User(username, password);
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call call = apiInterface.authenticateUser(user);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("TAG", response.code()+"");
                String displayResponse = "";

                User user1 = (User) response.body();
                System.out.println("Response:\n\tResponse: " + user1.status + "\tEmail: " + user1.email + "\tID: " + user1.id);

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                call.cancel();
                System.out.println("Authentication Call Failed");
            }
        });


    }

    /*@Override
    protected Void doInBackground(Void... arg0) {

    }*/
}
