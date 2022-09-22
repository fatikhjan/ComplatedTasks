package com.company.service;

import okhttp3.*;

import java.io.IOException;

public class App4 {
    static String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static void main(String[] args)throws IOException {

        RequestBody requestBody = new FormBody.Builder()
                .add("username","ali")
                .add("password","123")
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
