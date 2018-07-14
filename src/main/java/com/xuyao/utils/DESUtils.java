package com.xuyao.utils;


import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DESUtils {

    public static byte[] hex(String key){
        String f = DigestUtils.md5Hex(key);
        byte[] bkeys = f.getBytes();
        byte[] enk = new byte[24];
        System.arraycopy(bkeys, 0, enk, 0, 24);
        return enk;
    }

    public static String  encode3Des(String key,String srcStr){
        byte[] keybyte = hex(key);
        byte[] src = srcStr.getBytes();
        try {
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            Cipher c1 = Cipher.getInstance("DESede");
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return Base64Utils.encodeBase64(c1.doFinal(src));
        } catch(Exception e3){
            e3.printStackTrace();
        }
        return null;
    }

    public static String decode3Des(String key, String desStr){
        byte[] keybyte = hex(key);
        byte[] src = Base64Utils.decodeBase64ToByte(desStr);
        try {
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            Cipher c1 = Cipher.getInstance("DESede");
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return new String(c1.doFinal(src));
        } catch(Exception e3){
            e3.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String key = "kitty";
        String haha = encode3Des("hello", key);
        System.out.println(haha);
        System.out.println(decode3Des("hello", haha));
    }

}
