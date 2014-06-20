package com.kasun.process;

import java.util.ArrayList;

public class ProcesSubjectUnitTest {

    public static void main(String [] args){
        ProcesSubject procesSubject = new ProcesSubject();
        String sentence = "his mother and my mother is going to talk to me";
        String mean = procesSubject.getSubjectMean(sentence);
        System.out.println(mean);
    }
}
