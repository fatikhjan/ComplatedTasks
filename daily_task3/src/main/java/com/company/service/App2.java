package com.company.service;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.bouncycastle.cert.ocsp.Req;

import java.io.IOException;

public class App2 {
    static String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static void main(String[] args)throws IOException {
        Request request =new Request.Builder()
                .url(BASE_URL+"/todos")
//                .method("GET",null)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response execute = client.newCall(request).execute();
        String string = execute.body().string();
        System.out.println(string);

    }
}
