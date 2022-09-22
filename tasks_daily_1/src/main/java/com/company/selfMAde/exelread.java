package com.company.selfMAde;

import com.company.entetiys.Person;
import com.company.service.Database;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class exelread {
    static final String BASE_FOLDER = "src/main/resources/files/documents";

    public static void main(String[] args) {

        File file = new File(BASE_FOLDER, "people.xlsx");
        file.getParentFile().mkdirs();

        try (FileInputStream inputStream = new FileInputStream(file)) {

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.createSheet();
            XSSFRow header = sheet.getRow(1);
            List <Person> people= new ArrayList<>();
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()){
                Person person = new Person();
                Row row = iterator.next();
                Iterator<Cell>cellIterator = row.iterator();
                while (cellIterator.hasNext()){
                    System.out.println(cellIterator.next());
                }
            }
            workbook.close();
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
