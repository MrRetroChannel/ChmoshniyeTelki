package com.boostywannabe.springproj.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashHelper {
    private final static MessageDigest digest;

    static {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Sosi bebru");
        }
    }

    public static String getPasswordHash(String password) {
        return new String(digest.digest(password.getBytes()));
    }
}
