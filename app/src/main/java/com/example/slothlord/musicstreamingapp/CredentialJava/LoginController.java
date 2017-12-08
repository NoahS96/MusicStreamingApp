package com.example.slothlord.musicstreamingapp.CredentialJava;


import com.example.slothlord.musicstreamingapp.NewsfeedJava.NewsFeedActivity;
import com.example.slothlord.musicstreamingapp.POJO.User;
import com.example.slothlord.musicstreamingapp.R;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIClient;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIInterface;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrew Schaffer on 10/27/2017.
 */

public class LoginController {

    User user = null;
    volatile Context cxt;

    public LoginController(Context context) {
        cxt = context;
    }

    /**
     * Takes an email and password and sends them asynchronously to login server. Based on the
     * status response the controller will either create a toast or move to the newsFeed screen.
     * If the user object is needed for the next activity it can be passed in a bundle.
     * @param email
     * @param password
     * @return
     */
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

                if (user == null) {
                    Toast.makeText(cxt, "Server Authentication Error", Toast.LENGTH_SHORT).show();
                } else if (user.status.equals("DENIED")) {
                    Toast.makeText(cxt, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    Activity activity = (Activity) cxt;
                    TextView password_input = (TextView) activity.findViewById(R.id.password_input);
                    password_input.setText("", TextView.BufferType.EDITABLE);
                } else if (user.status.equals("USER_NOT_FOUND")) {
                    Toast.makeText(cxt, "Email Address Not Found", Toast.LENGTH_SHORT).show();
                } else if (user.status.equals("OK")) {
                    Intent myIntent = new Intent(cxt, NewsFeedActivity.class);
                    cxt.startActivity(myIntent);
                } else {
                    Toast.makeText(cxt, "Unknown Error", Toast.LENGTH_SHORT).show();
                }
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
