package com.kasun.process;

import java.util.ArrayList;

public class ProcesVerbUnitTest {
    
    public static void main(String [] args){
        String sentence = "They are eating for eating rice";
        ProsesVerb prosesVerb = new ProsesVerb();
        String verbs;
        verbs = prosesVerb.verbMeanOfSentence(sentence);
        System.out.println(verbs);
    }
}
