package com.kasun.parser;

public class ProcessParserOutput {
	private static String[] beVerbs={"am","is","are","was","were","will","shall"};
	private static String[] possesiveVebs={"has","have","had"};
	
	public static boolean isABeVerb(String word){
		for(int i=0;i<beVerbs.length;i++){
			if(word.equals(beVerbs[i]))	return true;
		}
		return false;
	}
	
	public static boolean isAPossesiveVerb(String word){
		for(int i=0;i<possesiveVebs.length;i++){
			if(word.equals(possesiveVebs[i]))	return true;
		}
		return false;
	}
}
