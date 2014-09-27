package com.kasun.process;

import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.db.DBConnection;
import com.kasun.process.logics.ProcessLogic;

public class ProsesVerb {

	private static final Logger log = LoggerFactory.getLogger(ProsesVerb.class);

	public static String[] englishVerb = { "coming", "eating", "drinking",
			"riding", "runing", "kissing", "reading", "going", "talking",
			"writing" };
	private String[] sinhalaVerb = { "එමින්", "කමින්", "බොමින්", "පදිමින්",
			"දුවමින්", "හාදු දෙමින්", "කියවමින්", "යමින්", "කතා කරමින්",
			"ලියමින්" };

	private static String[] doDes = { "do", "does", "don't", "doesn't" };
	private static String[] doDoesMean = { "", "", "නො", "නො" };

	private String[] pastPari = { "gone", "come", "eatten", "drunk", "read" };
	private String[] pastPariMean = { "ගොස්", " පැමින", " කා", "බී", "කියවා" };

	private String[] hasHv = { "has", "have", "had" };
	private String[] hasHvMean = { "තියෙනවා", "තියෙනවා", " තිබුනා" };

	private String[] beVerbs = { "is", "are", "was", "were", "am", "be" };
	private String[] beVerbsMean = { "සිටියි", "සිටිති", "සිටියේය", "සිටියෝය",
			"සිටිමි", "සිටීවි" };

	private static String[] verbWithWillMean = { "යාවි", "ඒවි", "කාවි",
			"දුවාවි", "කියවාවි", "තිබේවි" };

	public ArrayList<String> verbsInToArrayList(String sentence,
			String[] pattern) {
		String[] words = ProcessLogic.splitSentence(sentence);

		ArrayList<String> verbsAsArrayList = new ArrayList<String>();
		int i = 0;
		while (i < words.length && !(ProcessLogic.isPreposision(words[i]))) {
			if (ProcessLogic.isABeVerb(words[i])) {
				if (!(ProcessLogic.isIngVerb(words[i + 1]) || ProcessLogic
						.isPastParticiple(words[i + 1]))) {
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
			}
			if (ProcessLogic.isNormalVerb(words[i])) {
				verbsAsArrayList.add(words[i]);
				log.info(" verb 1 " + words[i]);
				log.info("Normal Verb " + words[i]);
				break;
			}
			if (ProcessLogic.isWill(words[i])) {
				// System.out.println("will");
				// this.willForm = true;
				log.info("willForm " + words[i]);
				verbsAsArrayList.add(words[i]);

				if (!(ProcessLogic.isBeen(words[i + 1]))) {
					// verbsAsArrayList.add(words[i]);
				}
			}
			i++;
		}
		return verbsAsArrayList;
	}

	public String verbMeanOfSentence(String sentence, String[] pattern,String[][] split_sentence)
			throws SQLException {

		//ArrayList<String> verbs = Process.verbsToArrayList(sentence, pattern);
		String[] verb = Process.verbsToArray(sentence, pattern);
		//verbs.toArray(verb);
		//String[] verb =split_sentence[2];
		
		int k = 0;
		while (k < verb.length) {
			log.info("Verbs are ::: " + verb[k]);
			k++;
		}

		String mean = "";
		/*System.out.println(split_sentence[0][0]+"ooooooooooooo");
		simple present tense-ASMPRT
		if(split_sentence[0][0].equals("ASMPRT")){
			System.out.println("ok");
			if(split_sentence[1][0].equals("I")){
				mean=DBConnection.getSinhaleMean(verb[0], "vbp","I_mean");
			}
		}*/
		if (1 < verb.length) {
			int j = verb.length - 1;
			int i = 0;
			if (!ProcessLogic.isDoDoes(verb[0])) {
				log.info("ProcessLogic.isFutureTense(sentence) "
						+ ProcessLogic.isFutureTense(sentence));
				if (ProcessLogic.isContinues(sentence)) {
					log.info("isContinues "
							+ ProcessLogic.isContinues(sentence));
					while (i < verb.length) {
						mean = mean + " " + getMeaningOfAVerb(verb[j]);
						j--;
						i++;
					}
				} else if (ProcessLogic.isFutureTense(sentence)) {

					if (!verb[1].equals("be")) {
						mean = getMeaningWithWill(verb[1]);
					} else if (verb[1].equals("be") && verb.length > 2) {
						log.info("getMeaningOfAVerb(verb[2]): "
								+ getMeaningOfAVerb(verb[2]));
						mean = getMeaningOfAVerb(verb[2]) + " සිටීවි";
					} else {
						mean = "සිටීවි";
					}

					log.info("Mean Verb " + mean);
				} else {
					while (i < verb.length) {
						mean = mean + " " + getMeaningOfPasveAVerb(verb[j]);
						j--;
						i++;
					}
				}
				log.info("Verb Meaning : " + mean);
			} else if (ProcessLogic.isFutureTense(sentence)) {

				mean = getMeaningWithWill(verb[1]);

				log.info("Mean Verb " + mean);
			} else {
				mean = getMeaningOfAVerb(verb[i])
						+ ProcessLogic.normalVerbMean(verb[i + 1]);
				log.info("verb " + verb[i]);
				log.info("Mean " + mean);
			}
		} else {
			mean = ProcessLogic.normalVerbMean(verb[0]);
			log.info("verb is :) " + verb[0]);
			log.info("verb mean is : " + mean);
		}
		return mean;
	}

	public String getMeaningWithWill(String verb) {
		log.info("Search for " + verb);
		int i = 0;
		while (i < englishVerb.length) {
			if (verb.equals(ProcessLogic.verbsPrasent[i])) {
				return ProcessLogic.verbWithWill[i];
			}

			i++;
		}

		return "Not in Database...";
	}

	public String getMeaningWithWillBe(String verb) {

		return "Not in Database ";
	}

	public String getMeaningOfAVerb(String Verb) throws SQLException {
		int i = 0;
		if (ProcessLogic.isIngVerb(Verb)) {
			return DBConnection.getVerbIngMean(Verb);
			// while (i < englishVerb.length) {
			// if (Verb.equals(englishVerb[i])) {
			// return sinhalaVerb[i];
			// }
			// i++;
			// }
			// i = 0;
		} else if (ProcessLogic.isABeVerb(Verb)) {
			while (i < beVerbs.length) {
				if (Verb.equals(beVerbs[i])) {
					return beVerbsMean[i];
				}
				i++;
			}
		} else if (ProcessLogic.isDoDoes(Verb)) {
			while (i < doDes.length) {
				if (Verb.equals(doDes[i])) {
					log.info("doDes " + doDes[i]);
					return doDoesMean[i];
				}
				i++;
			}
			// }else if(ProcessLogic.isWill(Verb)){
			// return "වි";
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
