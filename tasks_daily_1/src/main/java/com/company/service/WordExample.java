package com.company.service;

import com.company.entetiys.Person;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.System.out;

public class WordExample {

    static File baseFile = new File("src/resources");
    public static void main(String[] args) {

        File file  = new File(baseFile,"people.docx");

      try(FileOutputStream stream = new FileOutputStream(file)){
          XWPFDocument document = new XWPFDocument();

          XWPFParagraph paragraph = document.createParagraph();

          XWPFRun run = paragraph.createRun();
          run.setText("Salome");
          run.setBold(true);
          run.setFontSize(16);
          run.setFontFamily("Consolas");
          XWPFTable table = document.createTable();
          table.setWidth("100%");

          XWPFTableRow header = table.getRow(0);

          XWPFTableCell cell00 = header.getCell(0);
          cell00.setText("First name");
          cell00.setWidth("20%");

          String[] columns = {"First name", "Last name", "Age", "Region", "Image"};

          for (int i = 1; i < columns.length; i++) {
              XWPFTableCell cell = header.createCell();
              cell.setText(columns[i]);
              cell.setWidth("20%");
          }

          List<Person> people = Database.getPeople();

          for (Person person : people) {
              XWPFTableRow row = table.createRow();
              row.getCell(0).setText(person.getFirstName());
              row.getCell(1).setText(person.getLastName());
              row.getCell(2).setText(String.valueOf(person.getAge()));
              row.getCell(3).setText(String.valueOf(person.getRegion()));

              XWPFTableCell imageCell = row.getCell(4);
              XWPFParagraph imageParagraph = imageCell.addParagraph();
              imageParagraph.createRun().addPicture(
                      new FileInputStream(person.getImageUrl()), XWPFDocument.PICTURE_TYPE_JPEG,
                      person.getImageUrl(),
                      Units.pixelToEMU(100), Units.pixelToEMU(100)
              );
          }

          XWPFParagraph pTime = document.createParagraph();
          pTime.setAlignment(ParagraphAlignment.RIGHT);

          XWPFRun rTime = pTime.createRun();
          rTime.setText(LocalDateTime.now().format(
                  DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
          )+" holatiga ko'ra");
          rTime.setBold(true);

          document.write(out);


      } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
      } catch (IOException e) {
          throw new RuntimeException(e);
      } catch (InvalidFormatException e) {
          throw new RuntimeException(e);
      }
    }
}
