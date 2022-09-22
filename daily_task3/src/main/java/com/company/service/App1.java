package com.company.service;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class App1 {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/todos/").build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response);
            System.out.println(request.body().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
