package com.gameserver.Helper;

import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class HelperMethods {

    public String MD5(String text) throws NoSuchAlgorithmException {

        byte[] bytesOfMessage = text.getBytes();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        BigInteger no = new BigInteger(1, thedigest);
        return no.toString(16);
    }
}
