package com.company.selfMAde;

import com.company.entetiys.Person;
import com.company.service.Database;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class exelCreate {
    static final String BASE_FOLDER = "src/main/resources/files/documents";

    public static void main(String[] args) {

        File file = new File(BASE_FOLDER, "people.xlsx");
        file.getParentFile().mkdirs();

        try (FileOutputStream out = new FileOutputStream(file)) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            XSSFRow header = sheet.createRow(0);
            List<Person> people = Database.getPeople();


            String[] columns = {"Number", "First name", "Last name", "Age", "Region", "Image"};
            for (int i = 0; i < columns.length; i++) {
                header.createCell(i).setCellValue(columns[i]);
            }
            for (int i = 0; i < people.size(); i++) {
                Person person = people.get(i);
                XSSFRow row = sheet.createRow(i);
                row.createCell(0).setCellValue(person.getFirstName());
                row.createCell(1).setCellValue(person.getLastName());
                row.createCell(2).setCellValue(person.getAge());
                row.createCell(3).setCellValue(person.getRegion());
                row.createCell(4).setCellValue(person.getImageUrl());
            }

            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }


            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
