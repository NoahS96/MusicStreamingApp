package com.example.slothlord.musicstreamingapp;

/**
 * Created by Andrew Schaffer on 11/2/17.
 *
 * SaltAndHasher
 * This class will take a password and add concatenate a salt to it.
 * The new string will be hashed using SHA-256 and returned.
 */

public class SaltAndHasher {

    private final byte[] hashedPass = new byte[256];
    private String password;

    public SaltAndHasher(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] generate() {


        return hashedPass;
    }
}
