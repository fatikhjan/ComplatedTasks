package com.company.service;

import okhttp3.*;

import java.io.IOException;

public class App5 {
    static String BASE_URL = "http://10.10.2.189:8080";
    public static void main(String[] args)throws IOException {

        RequestBody requestBody = new FormBody.Builder()
                .add("fullName","Madinaxon")
                .add("phoneNumber","+998001112252")
                .add("gender","f")
                .add("course","3")
                .build();

        Request request =new Request.Builder()
                .url(BASE_URL+"/todos")
                .post(requestBody)
//                .method("GET",null)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response execute = client.newCall(request).execute();
        String string = execute.body().string();
        System.out.println(string);

    }
}
