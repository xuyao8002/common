package com.xuyao.utils;


import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageUtils {

    public static String getBase64StrFromUrl(String imgURL) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        try {
            // 创建URL
            URL url = new URL(imgURL);
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len;
            while ((len = is.read(data)) != -1) {
                stream.write(data, 0, len);
            }
            // 关闭流
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64Utils.encodeBase64(stream.toByteArray());
    }

    /**
     * 返回指定url图片的base64编码
     * @param imgURL 图片url
     * @return 图片base64编码值
     */
    public static String getImageStrFromUrl(String imgURL) {
        if(StringUtils.isBlank(imgURL)) return "";
        String suffix = imgURL.substring(imgURL.lastIndexOf(".") + 1);
        return getData(suffix) + getBase64StrFromUrl(imgURL);
    }

    public static String getData(String suffix) {
        String data = "data:image/jpeg;base64,";
        if(suffix.equals("gif")) {
            data = "data:image/gif;base64,";
        }else if(suffix.equals("png")) {
            data = "data:image/png;base64,";
        }
        return data;
    }
}
