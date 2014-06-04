package com.kasun.process;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProsesVerbTest {
	ProsesVerb prosesVerb;
	
	@BeforeTest
	public void setup() {
		 prosesVerb = new ProsesVerb();
	}

  @Test
  public void getMeaningOfAVerb() {
	  String[] verbs={"do","don't","am","are","going","coming"};
	  for(int i=0;i<verbs.length;i++){
		  System.out.println(prosesVerb.getMeaningOfAVerb(verbs[i]));
	  }
	  
  }

  @Test
  public void getMeaningOfPasveAVerb() {
	  String[] verbs={"has","have","had","gone","come"};
	  for(int i=0;i<verbs.length;i++){
		  System.out.println(prosesVerb.getMeaningOfPasveAVerb(verbs[i]));
	  }
  }

  @Test
  public void verbMeanOfSentence() {
	  String[] sentences = {""," ",null,"I go home","They are eating rice"," Mother has a book","I have come home"};
      for(int i=0;i<sentences.length;i++){
    	  String verbs;
          verbs = prosesVerb.verbMeanOfSentence(sentences[i]);
          System.out.println(verbs);
      }
  }

 /* @Test
  public void verbsInToArrayList() {
    throw new RuntimeException("Test not implemented");
  }*/
}
