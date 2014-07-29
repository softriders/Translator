package com.kasun.process;

import java.util.ArrayList;

public class ProcesVerbUnitTest {
    
    public static void main(String [] args){
    	String [] pattern = {"somthing"};
        String sentence = "They are eating for eating rice";
        ProsesVerb prosesVerb = new ProsesVerb();
        String verbs;
        verbs = prosesVerb.verbMeanOfSentence(sentence,pattern);
        System.out.println(verbs);
    }
}
