package com.kasun.process;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.process.logics.ProcessLogic;

public class ProsesVerb {

    private static final Logger log = LoggerFactory.getLogger(ProsesVerb.class);

    public static String[] englishVerb = { "coming", "eating", "drinking", "riding", "runing", "kissing", "reading", "going",
            "talking", "writing" };
    private String[] sinhalaVerb = { "එමින්", "කමින්", "බොමින්", "පදිමින්", "දුවමින්", "හාදු දෙමින්", "කියවමින්", "යමින්",
            "කතා කරමින්", "ලියමින්" };
    
    private static String[] doDes = {"do","does","don't","doesn't"};
    private static String[] doDoesMean = {"","","නො","නො"};

    private String[] pastPari = { "gone", "come", "eatten", "drunk", "read" };
    private String[] pastPariMean = { "ගොස්", " පැමින", " කා", "බී", "කියවා" };

    private String[] hasHv = { "has", "have", "had" };
    private String[] hasHvMean = { "තියෙනවා", "තියෙනවා", " තිබුනා" };

    private String[] beVerbs = { "is", "are", "was", "were", "am", "will", "be" };
    private String[] beVerbsMean = { "සිටියි", "සිටිති", "සිටියේය", "සිටියෝය", "සිටිමි","හිඳීවි" };

    public ArrayList<String> verbsInToArrayList(String sentence) {
        String[] words = ProcessLogic.splitSentence(sentence);

        ArrayList<String> verbsAsArrayList = new ArrayList<String>();
        int i = 0;
        while (i < words.length && !(ProcessLogic.isPreposision(words[i]))) {

            if (ProcessLogic.isABeVerb(words[i])) {
                if (!(ProcessLogic.isIngVerb(words[i + 1]) || ProcessLogic.isPastParticiple(words[i + 1]))) {
                    verbsAsArrayList.add(words[i]);
                    log.info(" ??? " + words[i]);
                    break;
                } else {
                    log.info("Verb " + words[i]);
                    verbsAsArrayList.add(words[i]);
                    verbsAsArrayList.add(words[i + 1]);
                    break;
                }
            }
            if (ProcessLogic.isAHvHs(words[i])) {
                verbsAsArrayList.add(words[i]);
                if (!ProcessLogic.isPastParticiple(words[i + 1])) {
                    break;
                }
            }
            if (ProcessLogic.isPastParticiple(words[i])) {
                verbsAsArrayList.add(words[i]);
                break;
            }
            if (ProcessLogic.isDoDoes(words[i])) {
                log.info("verb 0 " + words[i]);
                verbsAsArrayList.add(words[i]);
            } else if (ProcessLogic.isNormalVerb(words[i])) {
                verbsAsArrayList.add(words[i]);
                log.info(" verb 1 " + words[i]);
                break;
            }
            i++;
        }
        return verbsAsArrayList;
    }

    public String verbMeanOfSentence(String sentence) {
    	
    	if(sentence != null && !sentence.isEmpty() && !sentence.trim().isEmpty()){
    		sentence=sentence.trim();
    		 ArrayList<String> verbs = verbsInToArrayList(sentence);
    	        String[] verb = new String[verbs.size()];
    	        verbs.toArray(verb);
    	        String mean = "";
    	        if (1 < verb.length) {
    	            int j = verb.length - 1;
    	            int i = 0;
    	            if (!ProcessLogic.isDoDoes(verb[0])) {
    	                if (ProcessLogic.isContinues(sentence)) {
    	                    while (i < verb.length) {
    	                        mean = mean + " " + getMeaningOfAVerb(verb[j]);
    	                        j--;
    	                        i++;
    	                    }
    	                } else {
    	                    while (i < verb.length) {
    	                        mean = mean + " " + getMeaningOfPasveAVerb(verb[j]);
    	                        j--;
    	                        i++;
    	                    }
    	                }
    	                log.info("Verb Meaning : " + mean);
    	            }
    	            else{
    	                    mean =  getMeaningOfAVerb(verb[i])+ProcessLogic.normalVerbMean(verb[i+1]);
    	                    log.info("verb "+verb[i]);
    	                    log.info("Mean "+mean);
    	            }
    	        } else {
    	            mean = ProcessLogic.normalVerbMean(verb[0]);
    	            log.info("verb is :) " + verb[0]);
    	        }
    	        return mean;
    	}
    	return "empty sentence";
       
    }
    

    public String getMeaningOfAVerb(String Verb) {
        int i = 0;
        if (ProcessLogic.isIngVerb(Verb)) {
            while (i < englishVerb.length) {
                if (Verb.equals(englishVerb[i])) {
                    return sinhalaVerb[i];
                }
                i++;
            }
            i = 0;
        } else if (ProcessLogic.isABeVerb(Verb)) {
            while (i < beVerbs.length) {
                if (Verb.equals(beVerbs[i])) {
                    return beVerbsMean[i];
                }
                i++;
            }
        }else if(ProcessLogic.isDoDoes(Verb)){
            while (i < doDes.length) {
                if (Verb.equals(doDes[i])) {
                    log.info("doDes "+doDes[i]);
                    return doDoesMean[i];
                }
                i++;
            }
        }
        return "";
    }

    public String getMeaningOfPasveAVerb(String verb) {
        int i = 0;
        if (ProcessLogic.isAHvHs(verb)) {
            while (i < hasHv.length) {
                if (verb.equals(hasHv[i])) {
                    return hasHvMean[i];
                }
                i++;
            }
            i = 0;
        } else if (ProcessLogic.isPastParticiple(verb)) {
            while (i < pastPari.length) {
                if (verb.equals(pastPari[i])) {
                    return pastPariMean[i];
                }
                i++;
            }
        }
        return "";
    }
}
