package com.example.lab5.books;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadingBook {

    private String[] Title_EngTextbook;
    private String[] Author_EngTextbook;
    private String[] University_EngTextbook;
    private String[] Title_EngFiction;
    private String[] Author_EngFiction;
    private String[] Title_RusTextbook;
    private String[] Title_RusFiction;
    private String[] Author_RusFiction;


    public String[] getTitle_EngTextbook() {
        return Title_EngTextbook;
    }
    public String[] getAuthor_EngTextbook() {
        return Author_EngTextbook;
    }
    public String[] getUniversity_EngTextbook() {
        return University_EngTextbook;
    }
    public String[] getTitle_RusTextbook() {
        return Title_RusTextbook;
    }
    public String[] getTitle_RusFiction() {
        return Title_RusFiction;
    }

    public String[] getAuthor_RusFiction() {
        return Author_RusFiction;
    }

    public String[] getTitle_EngFiction() {
        return Title_EngFiction;
    }

    public String[] getAuthor_EngFiction() {
        return Author_EngFiction;
    }


    public void Readingbook (File file) throws IOException, InvalidFormatException {
        XSSFWorkbook book = new XSSFWorkbook(file);
        University_EngTextbook = read(book, 0);
        Title_EngTextbook = read(book, 1);
        Author_EngTextbook = read(book, 2);
        Title_EngFiction = read(book, 3);
        Author_EngFiction = read(book, 4);
        Title_RusTextbook = read(book, 5);
        Title_RusFiction = read(book, 6);
        Author_RusFiction = read(book, 7);

        book.close();
    }

    public String[] read(XSSFWorkbook book, int num) {
        XSSFSheet sheet = book.getSheetAt(num);
        String[] arr = new String[sheet.getLastRowNum() + 1];
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0) != null) {
                arr[i] = sheet.getRow(i).getCell(0).getStringCellValue();
            }
        }
        return arr;
    }

}

