package com.kasun.process.logics;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessLogic {

    private static final Logger log = LoggerFactory.getLogger(ProcessLogic.class);

    private static String[] beWorbs = { "is", "am", "are", "was", "were", "be"};

    private static String[] hasHv = { "has", "have", "had" };

    private static String[] pastPari = { "gone", "come", "eatten", "drunk", "read" };

    private static String[] preposisions = { "to", "for", "from", "on", "in", "with", "about", "" };
    private static String[] proposisionsMeaning = { "ට", " වෙනුවෙන්", " සිට", " මත", " තුල", " සමග", " පිලිබදව", "" };

    private static String[] englishSubject = { "i", "he", "she", "teacher", "student", "you", "mother", "father", "farmer" };
    private static String[] sinhalaSubject = { "මම", "ඔහු", "ඇය", "ගුරුවරයා", "ළමයා", "ඔබ", "අම්මා", "තාත්තා", "ගොවියා" };

    private static String[] englishObject = { "home", "school", "rice", "bicycle", "book", "books", "him", "her", "me", "apple",
            "mother", "eat", "talk", "father", "eat", "letter", "write", "teacher", "and", "eating", "reading", "writing" };
    private static String[] sinhalaObject = { "ගෙදර", "පාසල", "බත්", "බයිසිකලය", "පොත", "පොත්", "ඔහුට", "ඇයට", "මා",
            "ඇපල් ගෙඩිය", "මව", "කන්න", "කතා කරන්න", "පියා", "කන්න", "ලියුම", "ලියන්න", "ගුරුවරයා", "සහා", "කමින්", "කියවමින්",
            "ලියමින්" };

    public static String[] englishVerbWithIng = { "coming", "eating", "drinking", "riding", "runing", "kissing", "reading",
            "going", "talking", "writing" };

    private static String[] sm = { "his", "her", "their", "my" };
    private static String[] smMean = { "ඔහුගේ", "ඇයගේ", "ඔව්න්ගේ", "මගේ" };

    private static String[] englishTime = { "tomorow" };
    private String[] sinhalaTime = { "හෙට" };

    private String[] objectValues = { "a", "an", "many", "more", "the" };
    private String[] objectValuesMeaning = { "ක්", "ක්", "ගොඩාක්", "ගොඩාක්", "" };

    private String[] adjectives = { "small", "big", "litle", "huge" };
    private String[] adjectivesMeaning = { "කුඩා", "ලොකු", "පොඩ්ඩක්", "විශාල" };

    private static String[] doDes = { "do", "does", "don't", "doesn't" };

    private static String[] verbsPrasentSingl = { "goes", "comes", "eats", "runs", "reads", "has" };
    public static String[] verbsPrasent = { "go", "come", "eat", "run", "read", "had" };
    private static String[] verbsPast = { "went", "came", "ate", "ran", "red", "had" };

    private static String[] verbsPrasentSingulerMeaning = { "යයි", "එයි", "කයි", "දුවයි", "කියවයි", "තියෙනවා" };
    private static String[] verbsPrasentPlurelMeaning = { "යති", "එති", "කති", "දුවති", "කියවති", "තියෙනවා" };
    private static String[] verbsPastSingulerMeaning = { "ගියේය", "අවේය", "කෑවේය", "දිව්වේය", "කියෙව්වේය", "තිබුනේය" };
    public static String[] verbsPastPlurelMeaning = { "ගියෝය", "ආවෝය", "කෑවෝය", "දිව්වෝය", "කියෙව්වෝය", "තිබුනෝය" };
    public static String[] verbWithWill = {"යාවි","ඒවි","කාවි","දුවාවි","කියවාවි","තිබේවි"};;

    public static boolean isDoDoes(String verb) {
        int i = 0;
        while (i < doDes.length) {
            if (verb.equals(doDes[i])) {
                return true;
            }
            i++;
        }
        return false;
    }
    
    public static boolean isWill(String verb){
        if (verb.equals("will")){
            return true;
        }
        return false;
    }
    
    public static boolean isBeen(String verb){
        if(verb.equals("been")){
            return false;
        }
        return false;
    }

    public static boolean isNormalVerb(String verb) {
        String verbEnd = verb.substring(verb.length() - 1, verb.length());
        String verbEndPlurel = verb.substring(verb.length() - 2, verb.length());
        if (verbEndPlurel.equals("es")) {
            verb = verb.substring(0, verb.length() - 2);
        } else if (verbEnd.equals("s")) {
            verb = verb.substring(0, verb.length() - 1);
        }
        int i = 0;
        while (i < verbsPrasent.length) {
            if (verb.equals(verbsPrasent[i])) {
                return true;
            }
            i++;
        }
        i = 0;
        while (i < verbsPast.length) {
            if (verb.equals(verbsPast[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static String normalVerbMean(String verb) {
        int i = 0;
        log.info("checking this: " + verb);
        while (i < verbsPrasentSingl.length) {
            if (verb.equals(verbsPrasentSingl[i])) {
            	log.info("checking database...");
                return verbsPrasentSingulerMeaning[i];
            } else if (verb.equals(verbsPrasent[i])) {
                return verbsPrasentPlurelMeaning[i];
            } else if (verb.equals(verbsPast[i])) {
                return verbsPastSingulerMeaning[i];
            }
            i++;
        }
        return "Verb not found in the database";
    }

    public static boolean isSimpleTense(String sentence) {
        String[] words = splitSentence(sentence);
        int i = 0;
        while (i < words.length) {
            if (isPastParticiple(words[i]) || isIngVerb(words[i]) || isABeVerb(words[i])) {
                return false;
            }
            if (isOnlyHaveHas(sentence)) {
                return false;
            }
            if (isOnlyBeVerb(sentence)) {
                log.info("isOnlyBeVerb " + isOnlyBeVerb(sentence));
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean isOnlyHaveHas(String sentence) {
        String[] words = splitSentence(sentence);
        int i = 0;
        while (i < words.length) {
            if (isAHvHs(words[i])) {
                if (!isPastParticiple(words[i + 1])) {
                    log.info("isAHvHs " + isAHvHs(words[i]));
                    log.info("!isPastParticiple " + !isPastParticiple(words[i + 1]));
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public static boolean isOnlyBeVerb(String sentence) {
        String[] words = splitSentence(sentence);
        int i = 0;
        while (i < words.length - 1) {
            if (isABeVerb(words[i])) {
                if (isPastParticiple(words[i + 1]) || isIngVerb(words[i + 1])) {
                    return false;
                } else {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public static String ownerShipMean(String word) {
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

    public static String[] splitSentence(String sentence) {
    	log.info("splitSentence");
    	log.info("Input : "+sentence);
        String words[];
        words = sentence.split(" ");
        log.info("Word : "+words[0]);
        log.info("End splitSentence");
        return words;
    }

    public static boolean isPastParticiple(String word) {
        int i = 0;
        while (i < pastPari.length) {
            if (word.equals(pastPari[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean isPasiveVoice(String sentence) {

        String[] words = splitSentence(sentence);

        int i = 0;
        while (i < words.length - 1) {
            if (isAHvHs(words[i]) && isPastParticiple(words[i + 1])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean isABeVerb(String word) {
        int i = 0;
        while (i < beWorbs.length) {
            if (word.equals(beWorbs[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean isAHvHs(String word) {
        int i = 0;
        while (i < hasHv.length) {
            if (word.equals(hasHv[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static int beDitector(String sentence) {
        String[] words = splitSentence(sentence);
        int i = 0;
        while (i < words.length) {
            if (isABeVerb(words[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int prepoDitector(String sentence) {
        String[] words = splitSentence(sentence);
        int i = 0;
        int j = 0;
        while (i < words.length) {
            while (j < preposisions.length) {
                if (words[i].equals(preposisions[j])) {
                    return i;
                }
                j++;
            }
            j = 0;
            i++;
        }
        return 0;
    }
    
    public static boolean isFutureTense(String sentence){
        int i = 0;
        String[] words = splitSentence(sentence);
        while(i<words.length){
            if(isWill(words[i])){
                return true;
            }
            i++;
        }
        
        return false;
    }

    public static boolean isContinues(String sentence) {
        String[] words = splitSentence(sentence);
        int beWorb = beDitector(sentence);
        if (beWorb != -1) {
            if (isAVerbIng(words[beWorb + 1])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOwnerShip(String word) {
        int i = 0;
        while (i < sm.length) {
            if (word.equals(sm[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public String getObjectMeaning(String word) {
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

    public static String getAnyWordMeaning(String word) {
        int i = 0;
        while (i < englishSubject.length) {
            if (word.equals(englishSubject[i])) {
                return sinhalaSubject[i];
            }
            i++;
        }
        i = 0;
        while (i < englishObject.length) {
            if (word.equals(englishObject[i])) {
                return sinhalaObject[i];
            }
            i++;
        }
        return "word not in database";
    }

    public static boolean isPreposision(String word) {
        int i = 0;
        while (i < preposisions.length) {
            if (preposisions[i].equals(word)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean isAVerbIng(String word) {
        int i = 0;
        while (i < englishVerbWithIng.length) {
            if (word.equals(englishVerbWithIng[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean isATime(String word) {
        int i = 0;
        while (i < englishTime.length) {
            if (word.equals(englishTime[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static String propMean(String word) {
        int i = 0;
        while (i < preposisions.length) {
            if (word.equals(preposisions[i])) {
                return proposisionsMeaning[i];
            }
            i++;
        }
        return null;
    }

    public boolean isObVal(String word) {
        int i = 0;
        while (i < objectValues.length) {
            if (word.equals(objectValues[i])) {
                return true;
            }
            i++;
        }

        return false;
    }

    public String objValMean(String word) {
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

    public int andPosision(ArrayList<String> object) {
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

    public static boolean isIngVerb(String word) {
        int i = 0;
        while (i < englishVerbWithIng.length) {
            if (word.equals(englishVerbWithIng[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

}
