package com.company.service;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class App6 {
    static String BASE_URL = "http://10.10.2.189:8080";
    public static void main(String[] args)throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/delete").newBuilder();

        urlBuilder.addQueryParameter("id","29");

        String url = urlBuilder.build().toString();

//        new HttpUrl.Builder()
//                .addQueryParameter("userId","15")
//                .build().toString();
//
        Request request =new Request.Builder()
                .url(url)
                .delete()
//                .method("GET",null)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response execute = client.newCall(request).execute();
        String string = execute.body().string();
        System.out.println(string);

    }
}
