package com.example.slothlord.musicstreamingapp.RetrofitResources;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Andrew Schaffer on 11/2/17.
 */

public class NetworkController {

    public final String SERVER_IP = "";
    public final int SERVER_PORT = 80;
    public volatile Socket socket = null;

    public NetworkController() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
        } catch (IOException e) {
            System.err.println("Failed to create socket: " + e);
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
