package com.kasun.process;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.process.logics.ProcessLogic;

public class Process {

	private static final Logger log = LoggerFactory.getLogger(Process.class);

	public static ArrayList<String> subToArrayList(String sentence,
			String[] pattern) {

		String[] words = ProcessLogic.splitSentence(sentence);

		ArrayList<String> subAsArrayList = new ArrayList<String>();

		int i = 0;

		while (i < words.length && !(ProcessLogic.isABeVerb(words[i]))
				&& !pattern[i].equals("VBZ") && !pattern[i].equals("VBP")
				&& !pattern[i].equals("VBG") && !pattern[i].equals("VB")
				&& !pattern[i].equals("MD") && !pattern[i].equals("VBN")
				&& !pattern[i].equals("VBD")) {

			subAsArrayList.add(words[i]);
			log.info("pattern: " + pattern[i]);
			log.info("Subject words " + i + " " + words[i]);
			i++;

		}

		return subAsArrayList;
	}

	public static ArrayList<String> verbsToArrayList(String sentence,
			String[] pattern) {
		String[] words = ProcessLogic.splitSentence(sentence);

		ArrayList<String> verbsAsArrayList = new ArrayList<String>();
		int i = 0;
		while (i < words.length && !(isVerb(pattern[i]))) {
			i++;
		}

		while (i < words.length && isVerb(pattern[i])) {
			log.info("isVerb " + words[i] + " " + isVerb(pattern[i]) + " "
					+ pattern[i]);
			verbsAsArrayList.add(words[i]);
			log.info("Verb : " + words[i]);
			i++;
		}

		return verbsAsArrayList;
	}

	public static boolean isVerb(String patternWord) {

		if (patternWord.equals("VBZ") || patternWord.equals("VBP")
				|| patternWord.equals("VBG") || patternWord.equals("VB")
				|| patternWord.equals("MD") || patternWord.equals("VBN")
				|| patternWord.equals("VBD")) {

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

}
