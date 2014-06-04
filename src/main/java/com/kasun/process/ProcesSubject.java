package com.kasun.process;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.process.logics.ProcessLogic;

public class ProcesSubject {
    
    public boolean singuler = false;

    private static final Logger log = LoggerFactory.getLogger(ProcesSubject.class);

    public ArrayList<String> subAsArrayList(String sentence) {
        String[] words = ProcessLogic.splitSentence(sentence);

        ArrayList<String> subAsArrayList = new ArrayList<String>();

        int i = 0;
       
        while (i < words.length && !(ProcessLogic.isABeVerb(words[i])) && !(ProcessLogic.isAHvHs(words[i])) && !(ProcessLogic.isNormalVerb(words[i])) && !(ProcessLogic.isDoDoes(words[i])) ) {
            subAsArrayList.add(words[i]);
            log.info("Sub "+words[i]);
            log.info("ProcessLogic.isDoDoes(words[i]) "+ProcessLogic.isDoDoes(words[i]));
            i++;
        }
        return subAsArrayList;
    }

    public String getSubjectMean(String sentence) {
    	if(sentence != null && !sentence.isEmpty() && !sentence.trim().isEmpty()){
    		sentence=sentence.trim();
    		ArrayList<String> subAsArrayList = new ArrayList<String>();
            subAsArrayList = subAsArrayList(sentence);
            String[] arr = new String[subAsArrayList.size()];
            subAsArrayList.toArray(arr);

            String mean = "";

            int i = 0;

            while (i < arr.length) {
                if (ProcessLogic.isOwnerShip(arr[i])) {
                    mean = mean + " " + ProcessLogic.ownerShipMean(arr[i]) + " ";
                    //commented by shashi
                    // + ProcessLogic.getAnyWordMeaning(arr[i + 1]) + " ";
                    //i++;
                } else {
                    mean = mean + " " + ProcessLogic.getAnyWordMeaning(arr[i]) + " ";
                }
                i++;
            }
            log.info("Subject Meaning : " + mean);
            return mean;
    	}
		return "sentence is empty";
    }
}
