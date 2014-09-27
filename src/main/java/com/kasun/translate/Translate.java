package com.kasun.translate;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.parser.Parser;
import com.kasun.process.ProcesObject;
import com.kasun.process.ProcesSubject;
import com.kasun.process.ProsesVerb;
import com.kasun.process.logics.ProcessLogic;

public class Translate {

    private static final Logger log = LoggerFactory.getLogger(Translate.class);

    public static String[] englishVerb = { "coming", "eating", "drinking", "riding", "runing", "kissing", "reading", "going",
            "talking", "writing" };

    private String[] englishTime = { "tomorow" };


    public String getMeaning(String sentence) throws SQLException {
    	

    	String [] pattern = Parser.getPattern(sentence);
    	String[][] split_sentence=Parser.splitSentence(sentence,Parser.predictTense(pattern));
        
        ProcesObject procesObject = new ProcesObject();
        ProsesVerb prosesVerb = new ProsesVerb();
        ProcesSubject procesSubject = new ProcesSubject();
        
        String sinhalaMeaning;

        sinhalaMeaning = procesSubject.getSubjectMean(sentence,pattern) + procesObject.objMean(sentence,pattern)
                + prosesVerb.verbMeanOfSentence(sentence,pattern,split_sentence);

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
    
    public static String convertToStanderdString(String meaning){
    	
    	String [] meaningInArray = ProcessLogic.splitSentence(meaning);
    	String standerdMeaning = meaningInArray[0];
    	log.info("meaningInArray "+meaningInArray[0]);
    	int i = 1;
    	while(i<meaningInArray.length){
    		standerdMeaning = standerdMeaning + " ";
    		log.info(standerdMeaning);
    		i++;
    	}
    	return standerdMeaning;
    }
    
//    public static void main(String [] args){
//    	String example = "He Is going A book";
//    	log.info("log "+example);
//    	System.out.println(convertToStanderdString(example));
//    }
    
}
