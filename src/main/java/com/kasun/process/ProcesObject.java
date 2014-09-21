package com.kasun.process;

import java.util.ArrayList;

import com.kasun.process.logics.ProcessLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcesObject {

    private static final Logger log = LoggerFactory.getLogger(ProcesObject.class);

    private static String[] beWorbs = { "is", "am", "are", "was", "were", "be" };

    private String[] hasHv = { "has", "have", "had" };
    private String[] hasHvMean = { "තියෙනවා", "තියෙනවා", " තිබුනා" };

    private static String[] preposisions = { "to", "for", "from", "on", "in", "with", "about", "" };
    private static String[] proposisionsMeaning = { "ට", " වෙනුවෙන්", " සිට", " මත", " තුල", " සමග", " පිලිබදව", "" };

    private static String[] englishObject = { "home", "school", "rice", "bicycle", "book", "books", "him", "her", "me", "apple",
            "mother", "eat", "talk", "father", "eat", "letter", "write", "teacher", "and", "eating", "reading", "writing" };
    private static String[] sinhalaObject = { "ගෙදර", "පාසල", "බත්", "බයිසිකලය", "පොත", "පොත්", "ඔහුට", "ඇයට", "මා",
            "ඇපල් ගෙඩිය", "මව", "කන්න", "කතා කරන්න", "පියා", "කන්න", "ලියුම", "ලියන්න", "ගුරුවරයා", "සහා", "කමින්", "කියවමින්",
            "ලියමින්" };

    public static String[] englishVerbWithIng = { "coming", "eating", "drinking", "riding", "runing", "kissing", "reading",
            "going", "talking", "writing" };

    private String[] sm = { "his", "her", "their", "my" };
    private String[] smMean = { "ඔහුගේ", "ඇයගේ", "ඔව්න්ගේ", "මගේ" };

    private String[] englishTime = { "tomorow" };
    private String[] sinhalaTime = { "හෙට" };

    private static String[] objectValues = { "a", "an", "many", "more", "the" };
    private static String[] objectValuesMeaning = { "ක්", "ක්", "ගොඩාක්", "ගොඩාක්", "" };

    private String[] adjectives = { "small", "big", "litle", "huge" };
    private String[] adjectivesMeaning = { "කුඩා", "ලොකු", "පොඩ්ඩක්", "විශාල" };

    public String ownerShipMean(String word) {
        String mean = "";
        int i = 0;
        while (i < sm.length) {
            if (word.equals(sm[i])) {
                mean = smMean[i];
            }
            i++;
        }
        return mean;
    }

    public static ArrayList<String> makeObjectsAsList(String sentence) {
        ArrayList<String> obj = new ArrayList<String>();
        String[] words = ProcessLogic.splitSentence(sentence);
        boolean check = true;
        int ch = 0;

        int i = 0;
        log.info("isSimpleTense "+ProcessLogic.isSimpleTense(sentence));
        if (ProcessLogic.isContinues(sentence) || ProcessLogic.isPasiveVoice(sentence) || ProcessLogic.isSimpleTense(sentence))
        {
            
            while (i < words.length) {
                if ((ProcessLogic.isAVerbIng(words[i]) || ProcessLogic.isPastParticiple(words[i]) || ProcessLogic
                        .isNormalVerb(words[i])) && check) {
                    log.info("word.. "+words[i]);
                    log.info("isNormalVerb.. "+ProcessLogic.isNormalVerb(words[i]));
                    ch = 1;
                }
                if (!check) {
                    if (!(ProcessLogic.isATime(words[i]))) {
                        obj.add(words[i]);
                        log.info("word obj "+words[i]);
                    }
                }
                if (ch == 1) {
                    check = false;
                }
                i++;
            }
        } else {
            i = 0;
            while (i < words.length) {
                if ((ProcessLogic.isABeVerb(words[i]) || ProcessLogic.isAHvHs(words[i])) && check) {
                    ch = 1;
                }
                if (!check) {
                    if (!(ProcessLogic.isATime(words[i]))) {
                        obj.add(words[i]);
                    }
                }
                if (ch == 1) {
                    check = false;
                }
                i++;
            }

        }
        return obj;
    }
    
    public static ArrayList<String> makeObjectsAsListTest(String sentence) {
    	
    	
    	return null;
    }

    public static String getObjectMeaning(String word) {
        int i = 0;
        String wordObject = "";
        while (i < englishObject.length) {
            if (word.equals(englishObject[i])) {
                wordObject = sinhalaObject[i];
                break;
            }
            i++;
        }
        return wordObject;
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

    public static boolean isObVal(String word) {
        int i = 0;
        while (i < objectValues.length) {
            if (word.equals(objectValues[i])) {
                return true;
            }
            i++;
        }

        return false;
    }

    public static String objValMean(String word) {
        String mean = "";
        int i = 0;
        while (i < objectValues.length) {
            if (word.equals(objectValues[i])) {
                mean = objectValuesMeaning[i];
            }
            i++;
        }
        return mean;
    }

    public static boolean isAndInObjects(String sentence,String [] pattern) {
        ArrayList<String> obj = Process.objectToList(sentence,pattern);
        String[] objects = new String[obj.size()];
        obj.toArray(objects);
        int i = 0;
        while (i < objects.length) {
            if (objects[i].equals("and")) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static int andPosision(ArrayList<String> object) {
        String[] objects = new String[object.size()];
        object.toArray(objects);
        int i = 0;
        while (i < objects.length) {
            if (objects[i].equals("and")) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static ArrayList<String> veryfyAnd(String sentence,String [] pattern) {
        ArrayList<String> obj = Process.objectToList(sentence,pattern);
        int remAndPosistion = andPosision(obj);
        ArrayList<String> modifiedObj = new ArrayList<String>();
        if (isAndInObjects(sentence,pattern) && !ProcessLogic.isIngVerb(obj.get(remAndPosistion + 1))) {
            String[] objects = new String[obj.size()];
            obj.toArray(objects);

            int count = 0;
            int i = andPosision(obj);
            int end = i + 1;
            int j = i - 1;
            int k = i + 1;

            ArrayList<String> beforAnd = new ArrayList<String>();
            ArrayList<String> afterAnd = new ArrayList<String>();

            ArrayList<String> beforAndM = new ArrayList<String>();
            ArrayList<String> afterAndM = new ArrayList<String>();

            while ((0 <= j)
                    && !(ProcessLogic.isPreposision(objects[j]) || ProcessLogic.isABeVerb(objects[j]) || ProcessLogic
                            .isIngVerb(objects[j]))) {
                beforAnd.add(objects[j]);
                j--;
                count++;
            }
            if ((0 <= j) && ProcessLogic.isPreposision(objects[j])) {
                beforAnd.add(objects[j]);
                count++;
            }

            j = 0;
            while (k < objects.length && !(ProcessLogic.isPreposision(objects[k]))) {
                end++;
                afterAnd.add(objects[k]);
                k++;
            }
            j = beforAnd.size() - 1;
            while (0 <= j) {
                beforAndM.add(beforAnd.get(j));
                j--;
            }
            k = 1;
            if (ProcessLogic.isPreposision(beforAnd.get(beforAnd.size() - 1))) {
                afterAndM.add(beforAnd.get(beforAnd.size() - 1));
            }
            k = 0;
            while (k < afterAnd.size()) {
                afterAndM.add(afterAnd.get(k));
                k++;
            }
            i = 0;
            ArrayList<String> modified = new ArrayList<String>();
            while (i < beforAndM.size()) {
                modified.add(beforAndM.get(i));
                i++;
            }
            i = 0;
            while (i < afterAndM.size()) {
                modified.add(afterAndM.get(i));
                i++;
            }

            i = 0;
            int start = andPosision(obj) - count;

            while (i <= start - 1) {
                modifiedObj.add(obj.get(i));
                i++;
            }
            i = 0;
            while (i < afterAndM.size()) {
                modifiedObj.add(afterAndM.get(i));
                start++;
                i++;
            }
            i = 0;
            if (!ProcessLogic.isIngVerb(obj.get(remAndPosistion + 1))) {
                modifiedObj.add("and");
            }
            while (i < beforAndM.size()) {
                modifiedObj.add(beforAndM.get(i));
                i++;
            }
            while (end < objects.length) {
                modifiedObj.add(objects[end]);
                log.info("objects[end]) " + objects[end]);
                end++;
            }
            
            

        } else {
            modifiedObj = obj;
        }
        return modifiedObj;
    }
    
    public String objMeanTest(String sentence, String [] pattern) {
    	
    	
    	
    	return null;
    }

    public String objMean(String sentence, String [] pattern) {

        ArrayList<String> obj = veryfyAnd(sentence,pattern);
        String[] objects = new String[obj.size()];

        obj.toArray(objects);
        String mean = "";

        int i = 0;

        while (i < objects.length) {
            if (ProcessLogic.isPreposision(objects[i]) && !(ProcessLogic.isOwnerShip(objects[i + 1]))) {
                mean = getObjectMeaning(objects[i + 1]) + ProcessLogic.propMean(objects[i]) + " " + mean;
                i++;
            } else if (ProcessLogic.isPreposision(objects[i]) && ProcessLogic.isOwnerShip(objects[i + 1])) {
                mean = " " + ProcessLogic.ownerShipMean(objects[i + 1]) + " " + getObjectMeaning(objects[i + 2])
                        + ProcessLogic.propMean(objects[i]) + " " + mean;
                i = i + 2;
            } else if (isObVal(objects[i])) {
                if (objects[i].equals("a") || objects[i].equals("an")) {
                    mean = getObjectMeaning(objects[i + 1]) + objValMean(objects[i]) + " " + mean;
                    i++;
                } else {
                    mean = " " + getObjectMeaning(objects[i + 1]) + " " + objValMean(objects[i]) + " " + mean;
                    i++;
                }
            } else if (ProcessLogic.isOwnerShip(objects[i])) {
                mean = ProcessLogic.ownerShipMean(objects[i]) + " " + getObjectMeaning(objects[i + 1]) + " " + mean;
                i++;
            } else {
                mean = getObjectMeaning(objects[i]) + " " + mean;
            }
            i++;
        }
        log.info("Object Meaning : " + mean);
        return mean;
    }
}
