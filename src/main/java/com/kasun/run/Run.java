package com.kasun.run;

import java.sql.SQLException;
import java.util.Scanner;

import com.kasun.translate.Translate;

public class Run {
    
    static Translate translate = new Translate();

    public static void main(String[] args) throws SQLException {
        String sentence = "hi";
        while (!(sentence.equals(" "))) {

            System.out.print("Enter English sentence here : ");
            @SuppressWarnings("resource")
            Scanner scan = new Scanner(System.in);
            sentence = scan.nextLine();

            String meaning;
            meaning = translate.getMeaning(sentence);
            System.out.print("Meaning is : ");
            System.out.println(meaning);
        }
    }

    public static String getTranslation(String sentence) {
        String meaning = "";
        try {
            meaning = translate.getMeaning(sentence);
            return meaning;
        } catch (Exception e) {
            return "පරිවර්තනය කල නොහැක";
        }
    }
}
