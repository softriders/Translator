package com.kasun.process;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.parser.Parser;
import com.kasun.process.logics.ProcessLogic;

public class Process {

	private static final Logger log = LoggerFactory.getLogger(Process.class);

//	public static ArrayList<String> subToArrayList(String sentence,
//			String[] pattern) {
//
//		String[] words = ProcessLogic.splitSentence(sentence);
//
//		ArrayList<String> subAsArrayList = new ArrayList<String>();
//
//		int i = 0;
//
//		while (i < words.length && !(ProcessLogic.isABeVerb(words[i]))
//				&& !pattern[i].equals("VBZ") && !pattern[i].equals("VBP")
//				&& !pattern[i].equals("VBG") && !pattern[i].equals("VB")
//				&& !pattern[i].equals("MD") && !pattern[i].equals("VBN")
//				&& !pattern[i].equals("VBD") && !pattern[i].equals("VBZpos")
//				&& !pattern[i].equals("VBPpos") && !pattern[i].equals("MDbe")) {
//
//			subAsArrayList.add(words[i]);
//			log.info("pattern: " + pattern[i]);
//			log.info("Subject words " + i + " " + words[i]);
//			i++;
//
//		}
//
//		return subAsArrayList;
//	}
	
	public static String [] subToArray(String sentence,
			String[] pattern) {
		
		String [] subjectArray = Parser.splitSentence(sentence,Parser.predictTense(pattern))[1]; 
		
		return subjectArray;
	}

//	public static ArrayList<String> verbsToArrayList(String sentence,
//			String[] pattern) {
//		String[] words = ProcessLogic.splitSentence(sentence);
//
//		ArrayList<String> verbsAsArrayList = new ArrayList<String>();
//
//		int m = 0;
//		while (m < pattern.length) {
//			System.out.println(words[m] + " " + pattern[m] + " " + m);
//			m++;
//		}
//
//		int i = 0;
//		while (i < words.length && !(isVerb(pattern[i]))) {
//			log.info("Parsing " + pattern[i] + " " + i);
//			i++;
//		}
//
//		while (i < words.length && isVerb(pattern[i])) {
//			log.info("isVerb " + words[i] + " " + isVerb(pattern[i]) + " "
//					+ pattern[i]);
//			verbsAsArrayList.add(words[i]);
//			log.info("Verb : " + words[i]);
//			i++;
//		}
//
//		return verbsAsArrayList;
//	}
	
	public static String [] verbsToArray(String sentence,
			String[] pattern) {
		
		String [] verbArray = Parser.splitSentence(sentence,Parser.predictTense(pattern))[2]; 
		
		return verbArray;
	}

	public static boolean isVerb(String patternWord) {

		if (patternWord.equals("VBZ") || patternWord.equals("VBP")
				|| patternWord.equals("VBG") || patternWord.equals("VB")
				|| patternWord.equals("MD") || patternWord.equals("VBN")
				|| patternWord.equals("VBD") || patternWord.equals("VBZbe")
				|| patternWord.equals("VBDbe") || patternWord.equals("VBbe")
				|| patternWord.equals("VBZpos") || patternWord.equals("VBPpos")
				|| patternWord.equals("VBPbe")) {

			return true;

		}
		return false;
	}

	public static ArrayList<String> objectToList(String sentence,
			String[] pattern) {
		ArrayList<String> obj = new ArrayList<String>();
		String[] words = ProcessLogic.splitSentence(sentence);

		int i = 0;
		log.info("isSimpleTense " + ProcessLogic.isSimpleTense(sentence));

		while (i < words.length && !(isVerb(pattern[i]))) {
			i++;
		}

		while (i < words.length && isVerb(pattern[i])) {
			i++;
		}

		while (i < words.length) {
			obj.add(words[i]);
			i++;
		}

		return obj;
	}
	
	public static String [] objectToArray(String sentence,
			String[] pattern) {
		
		String [] objArray = Parser.splitSentence(sentence,Parser.predictTense(pattern))[3]; 
		
		return objArray;
		
	}

}
