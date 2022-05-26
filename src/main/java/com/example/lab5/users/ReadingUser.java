package com.example.lab5.users;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadingUser {
    private String[] male_name;
    private String[] female_name;
    private String[] surname;
    private String[] teacher_surname;
    private String[] patronymic;

    public String[] getMale_name(){
        return male_name;
    }

    public String[] getFemale_name(){
        return female_name;
    }

    public String[] getMale_Surname(){
        return surname;
    }

    public String[] getTMale_Surname(){
        return teacher_surname;
    }

    public String[] getPatronymic() {
        return patronymic;
    }


    public String[] read(XSSFWorkbook book, int index) {
        XSSFSheet sheet = book.getSheetAt(index);
        String[] arr = new String[sheet.getLastRowNum()+1];
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0)!=null)
                arr[i] = sheet.getRow(i).getCell(0).getStringCellValue();
        }
        return arr;
    }

    public void Readingus (File file) throws IOException, InvalidFormatException {
        XSSFWorkbook book = new XSSFWorkbook(file);
        male_name = read(book,0);
        female_name = read(book,1);
        surname = read(book,2);
        teacher_surname = read(book,3);
        patronymic = setMale_patronymic();
        book.close();
    }

    public String[] setMale_patronymic() {
        String[] patronymic = new String[male_name.length];
        int k=0;
        for (String male_name: male_name) {
            if (male_name.endsWith("ев")) {
                patronymic[k] = male_name.substring(0, male_name.length() - 2) + "ьвович";}
            else if (male_name.endsWith("а")|male_name.endsWith("ья")) {
                patronymic[k] = male_name.substring(0, male_name.length() - 1) + "ич";
            } else if (male_name.endsWith("ж")|male_name.endsWith("ш")|male_name.endsWith("ч")|male_name.endsWith("щ")|male_name.endsWith("ц")|male_name.endsWith("р")|
                    male_name.endsWith("н")|male_name.endsWith("л")|male_name.endsWith("б")|male_name.endsWith("м")|male_name.endsWith("с")|
                    male_name.endsWith("к")|male_name.endsWith("г")|male_name.endsWith("в")|male_name.endsWith("д")|male_name.endsWith("п")){
                patronymic[k]=male_name+"ович";}
            else if (male_name.endsWith("ь")|male_name.endsWith("й")){
                patronymic[k]=male_name.substring(0, male_name.length() - 1) +"евич";
            } else
                patronymic[k]=male_name+"eвич";
            k++;
        }

        return patronymic;
    }

}
