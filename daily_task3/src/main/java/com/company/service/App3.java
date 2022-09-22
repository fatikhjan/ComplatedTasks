package com.company.service;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.math3.analysis.function.StepFunction;

import java.io.IOException;

public class App3 {
    static String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static void main(String[] args)throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/todos").newBuilder();

        urlBuilder.addQueryParameter("userId","8");
        urlBuilder.addQueryParameter("id","150");

        String url = urlBuilder.build().toString();

//        new HttpUrl.Builder()
//                .addQueryParameter("userId","15")
//                .build().toString();
//
        Request request =new Request.Builder()
                .url(url)
//                .method("GET",null)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response execute = client.newCall(request).execute();
        String string = execute.body().string();
        System.out.println(string);

    }
}
