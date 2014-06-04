package com.kasun.process.logics;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessLogic {

    private static final Logger log = LoggerFactory.getLogger(ProcessLogic.class);

    private static String[] beWorbs = { "is", "am", "are", "was", "were", "be", "will", "shall","isn't","aren't","ain't","wasn't","weren't","won't","shan't" };

    private static String[] hasHv = { "has", "have", "had","hasn't","haven't","hadn't" };

    private static String[] pastPari = { "gone", "come", "eaten", "drunk", "read" };

    private static String[] preposisions = { "to", "for", "from", "on", "in", "with", "about", "" };
    private static String[] proposisionsMeaning = { "ට", " වෙනුවෙන්", " සිට", " මත", " තුල", " සමග", " පිලිබදව", "" };

    private static String[] englishSubject = { "I", "He", "She", "Teacher", "Student", "You", "Mother", "Father", "Farmer" };
    private static String[] sinhalaSubject = { "මම", "ඔහු", "ඇය", "ගුරුවරයා", "ළමයා", "ඔබ", "අම්මා", "තාත්තා", "ගොවියා" };

    private static String[] englishObject = { "home", "school", "rice", "bicycle", "book", "books", "him", "her", "me", "apple",
            "mother", "eat", "talk", "father", "eat", "letter", "write", "teacher", "and", "eating", "reading", "writing" };
    private static String[] sinhalaObject = { "ගෙදර", "පාසල", "බත්", "බයිසිකලය", "පොත", "පොත්", "ඔහුට", "ඇයට", "මා",
            "ඇපල් ගෙඩිය", "මව", "කන්න", "කතා කරන්න", "පියා", "කන්න", "ලියුම", "ලියන්න", "ගුරුවරයා", "සහා", "කමින්", "කියවමින්",
            "ලියමින්" };

    public static String[] englishVerbWithIng = { "coming", "eating", "drinking", "riding", "runing", "kissing", "reading",
            "going", "talking", "writing" };

    private static String[] sm = { "his", "her", "their", "my","our" };
    private static String[] smMean = { "ඔහුගේ", "ඇයගේ", "ඔව්න්ගේ", "මගේ","අපේ" };

    private static String[] englishTime = { "tomorrow","today","yesterday" };
    private String[] sinhalaTime = { "හෙට","අද","ඊයේ" };

    private String[] objectValues = { "a", "an", "many", "more", "the","little" };
    private String[] objectValuesMeaning = { "ක්", "ක්", "ගොඩාක්", "ගොඩාක්","", "ටිකක්" };

    private String[] adjectives = { "small", "big", "litle", "huge" };
    private String[] adjectivesMeaning = { "කුඩා", "ලොකු", "පොඩ්ඩක්", "විශාල" };

    private static String[] doDes = { "do", "does", "don't", "doesn't","did","didn't" };

    private static String[] verbsPrasentSingl = { "goes", "comes", "eats", "runs", "reads", "has" };
    private static String[] verbsPrasent = { "go", "come", "eat", "run", "read", "had","cry"};
    private static String[] verbsPast = { "went", "came", "ate", "ran", "red", "had" };

    private static String[] verbsPrasentSingulerMeaning = { "යයි", "එයි", "කයි", "දුවයි", "කියවයි", "තියෙනවා" };
    private static String[] verbsPrasentPlurelMeaning = { "යති", "එති", "කති", "දුවති", "කියවති", "තියෙනවා" };
    private static String[] verbsPastSingulerMeaning = { "ගියේය", "අවේය", "කෑවේය", "දිව්වේය", "කියෙව්වේය", "තිබුනේය" };
    private static String[] verbsPastPlurelMeaning = { "ගියෝය", "ආවෝය", "කෑවෝය", "දිව්වෝය", "කියෙව්වෝය", "තිබුනෝය" };

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

    public static boolean isNormalVerb(String verb) {
    	String verbEnd="",verbEndPlurel ="" ,verbEndPlurel3="";
    	if(verb.length()!=0){
    		verbEnd = verb.substring(verb.length() - 1, verb.length());
    		if(verb.length()>1){
    			verbEndPlurel = verb.substring(verb.length() -2, verb.length());
        	}
    		if(verb.length()>2){
    	        verbEndPlurel3=verb.substring(verb.length() - 3, verb.length());//
    		}
    	}
 
    	if (verbEndPlurel3.equals("ves") | verbEndPlurel3.equals("ies")){
        	if(verbEndPlurel3.equals("ies")){
        		verb = verb.substring(0, verb.length() - 3)+'y';
        	}
        	else{
        		//code this
        	}
        	//
        }else if (verbEndPlurel.equals("es")) {
            verb = verb.substring(0, verb.length() - 2);
        } //added by shashi
        else if (verbEnd.equals("s")) {
            verb = verb.substring(0, verb.length() - 1);
        }
        int i = 0;
        //check present tense
        while (i < verbsPrasent.length) {
            if (verb.equals(verbsPrasent[i])) {
                return true;
            }
            i++;
        }
        i = 0;
        //check past tense
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
        log.info("checking this    " + verb);
        while (i < verbsPrasentSingl.length) {
            if (verb.equals(verbsPrasentSingl[i])) {
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
            if (isAHvHs(words[i]) && (i+1)<words.length) {
                if (!(isPastParticiple(words[i + 1]) || words[i + 1].equals("been") || (words[i + 1].equals("being")))) {
                    log.info("isAHvHs " + isAHvHs(words[i]));
                    log.info("!isPastParticiple " + !isPastParticiple(words[i + 1]));
                    return true;
                }
            }else if(isAHvHs(words[i])){
            	return true;
            }
            i++;
        }
        return false;
    }

    public static boolean isOnlyBeVerb(String sentence) {
        String[] words = splitSentence(sentence);
        int i = 0;
        while (i < words.length) {
            if (isABeVerb(words[i])) {
            	if((i+1)<words.length){
            		if (isPastParticiple(words[i + 1]) || isIngVerb(words[i + 1])||words[i + 1].equals("being")) {
                        return false;
                    }
            		else{
            			return true;
            		}
            	}else {
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
        String words[];
        sentence = sentence.replaceAll("\\s+", " ");
        words = sentence.split(" ");
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

    public static boolean isPerfectTense(String sentence) {

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

    public static boolean isContinues(String sentence) {
        String[] words = splitSentence(sentence);
        int beWorb = beDitector(sentence);
        if (beWorb != -1) {
            if ((beWorb+1)<words.length && isIngVerb(words[beWorb + 1])) {
                return true;
            }
            else if((beWorb+2)<words.length && words[beWorb + 1].equals("be") && isIngVerb(words[beWorb + 2])){
            	return true;
            }
        }
        return false;
    }

    public static boolean isOwnerShip(String word) {
        int i = 0;
        String verbEnd;
        if(word.length()>1){
	        verbEnd=word.substring(word.length() - 2, word.length());
	        if(verbEnd.equals("'s") || verbEnd.equals("s'")){
	        	return true;
	        }
		}
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
