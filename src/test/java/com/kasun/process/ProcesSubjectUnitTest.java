package com.kasun.process;

import java.util.ArrayList;

public class ProcesSubjectUnitTest {

    public static void main(String [] args){
    	String [] pattern = {"somthing"};
        ProcesSubject procesSubject = new ProcesSubject();
        String sentence = "his mother and my mother is going to talk to me";
        String mean = procesSubject.getSubjectMean(sentence,pattern);
        System.out.println(mean);
    }
}
