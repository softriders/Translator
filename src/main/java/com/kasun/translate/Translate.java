package com.kasun.translate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.parser.Parser;

import com.kasun.process.ProcesObject;
import com.kasun.process.ProcesSubject;
import com.kasun.process.ProsesVerb;

public class Translate {

    private static final Logger log = LoggerFactory.getLogger(Translate.class);

    public static String[] englishVerb = { "coming", "eating", "drinking", "riding", "runing", "kissing", "reading", "going",
            "talking", "writing" };

    private String[] englishTime = { "tomorow" };


    public String getMeaning(String sentence) {
    	

    	String [] pattern = Parser.getPattern(sentence);
        
        ProcesObject procesObject = new ProcesObject();
        ProsesVerb prosesVerb = new ProsesVerb();
        ProcesSubject procesSubject = new ProcesSubject();
        
        String sinhalaMeaning;

        sinhalaMeaning = procesSubject.getSubjectMean(sentence,pattern) + procesObject.objMean(sentence,pattern)
                + prosesVerb.verbMeanOfSentence(sentence,pattern);

        return sinhalaMeaning;
    }

    public boolean isATime(String word) {
        int i = 0;
        while (i < englishTime.length) {
            if (word.equals(englishTime[i])) {
                return true;
            }
            i++;
        }
        return false;
    }
}
