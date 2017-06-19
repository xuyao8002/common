package com.xuyao.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xuyao on 2017/6/7.
 */
public class HttpUtils {
    private static HttpClient httpClient = HttpClientBuilder.create().build();

    public static String doPost(String url, Map<String, String> map, String charset) {
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> e : map.entrySet()) {
            list.add(new BasicNameValuePair(e.getKey(), e.getValue()));
        }
        String result = null;
        try {
            if (!list.isEmpty()) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String doGet(String url, Map<String, String> map, String charset) {
        StringBuilder builder = new StringBuilder(url).append("?");
        for (Map.Entry<String, String> e : map.entrySet()) {
            builder.append(e.getKey()).append("=").append(e.getValue()).append("&");
        }
        url = builder.substring(0, builder.length() - 1);
        HttpGet httpGet = new HttpGet(url);
        String result = null;
        try {
            HttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
