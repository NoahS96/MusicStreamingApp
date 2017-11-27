package com.example.slothlord.musicstreamingapp.POJO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew Schaffer on 11/16/2017.
 */

public class User {

    @SerializedName("status")
    public String status;

    @SerializedName("email")
    public String email;

    @SerializedName("id")
    public String id;

    public String getStatus() {
        return status;
    }

    public String getEmail() { return email; }

    public String getId() { return id; }

    public String toString() {
        return "[User: [status : " + this.status + " email : " + this.email + ", ID : " + this.id + "]]";
    }
}
