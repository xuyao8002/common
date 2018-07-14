package com.xuyao.utils;

import java.util.Base64;

public class Base64Utils {

    public static String encodeBase64(byte[] arr){
        return Base64.getEncoder().encodeToString(arr);
    }

    public static String decodeBase64(String str){
        return new String(Base64.getDecoder().decode(str));
    }

    public static byte[] decodeBase64ToByte(String str){
        return Base64.getDecoder().decode(str);
    }
}
