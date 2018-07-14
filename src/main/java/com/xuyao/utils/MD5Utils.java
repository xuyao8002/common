package com.xuyao.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    public static String encodeMD5(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String result = null;
        if(md != null){
            md.update(str.getBytes());
            result = new BigInteger(1, md.digest()).toString(16);
        }
        return result;
    }

}
