package com.company.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class App5 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/comments?postId=777");

            URLConnection urlConnection = url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            String line = null;

            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

            // shu input stream dagi ma;lumotlarni excelga yozish

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
