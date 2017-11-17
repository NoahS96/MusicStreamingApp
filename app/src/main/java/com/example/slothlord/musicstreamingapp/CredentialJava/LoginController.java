package com.example.slothlord.musicstreamingapp.CredentialJava;

import android.os.AsyncTask;

import com.example.slothlord.musicstreamingapp.RetrofitResources.APIClient;
import com.example.slothlord.musicstreamingapp.RetrofitResources.APIInterface;
import com.example.slothlord.musicstreamingapp.RetrofitResources.NetworkController;

import org.json.JSONObject;

import java.net.Socket;

/**
 * Created by Andrew Schaffer on 10/27/2017.
 * www.journaldev.com/13639/retrofit-android-example-tutorial
 */

public class LoginController { //extends AsyncTask<Void, Void, Void> {

    NetworkController net_info = new NetworkController();

    public void checkCredentials(String username, String password) {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

    }

    /*@Override
    protected Void doInBackground(Void... arg0) {

    }*/
}
