package com.kasun.run;

import java.util.Scanner;

import com.kasun.translate.Translate;
public class Run {

    public static void main(String[] args) {

        Translate translate = new Translate();

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
}
