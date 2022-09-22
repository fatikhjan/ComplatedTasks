package com.company.service;

import com.company.service.entitiy.Comment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class App6 {

    static String BASE_CLASS = "src/main/resources/files";

    public static void main(String[] args) {
        File file = new File(BASE_CLASS, "comments.xlsx");
        file.getParentFile().mkdirs();
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/comments");

            URLConnection urlConnection = url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<Comment> comments = gson.fromJson(reader, new TypeToken<List<Comment>>() {
            }.getType());
            try (FileOutputStream out = new FileOutputStream(file)) {

                XSSFWorkbook workbook = new XSSFWorkbook();

                XSSFSheet sheet = workbook.createSheet("people");

                XSSFRow header = sheet.createRow(0);

                String[] columns = {"PostID", "id", "name", "email", "body"};

                for (int i = 0; i < columns.length; i++) {
                    header.createCell(i).setCellValue(columns[i]);
                }


                for (int i = 0; i < comments.size(); i++) {
                    Comment comment = comments.get(i);

                    XSSFRow row = sheet.createRow(i + 1);

                    row.createCell(0).setCellValue(i + 1);
                    row.createCell(1).setCellValue(comment.getPostId());
                    row.createCell(2).setCellValue(comment.getId());
                    row.createCell(3).setCellValue(comment.getName());
                    row.createCell(4).setCellValue(comment.getEmail());
                    row.createCell(5).setCellValue(comment.getBody());

                }

                for (int i = 0; i < columns.length; i++) {
                    sheet.autoSizeColumn(i);
                }
                reader.close();
                workbook.close();
            }
            // shu input stream dagi ma;lumotlarni excelga yozish

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




