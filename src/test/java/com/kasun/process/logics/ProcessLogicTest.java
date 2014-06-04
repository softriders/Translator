package com.kasun.process.logics;

import java.util.ArrayList;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.kasun.process.ProcesObject;

public class ProcessLogicTest {
	ProcessLogic processLogic;
  @BeforeTest
  public void setup() {
	  processLogic=new ProcessLogic();
  }


  @Test
  public void andPosision() {
	  ArrayList<String> list = new ArrayList<String>() {{
		    add("A");
		    add("and");
		    add("B");
		}};
		AssertJUnit.assertEquals(1,processLogic.andPosision(list));
	  
	  list = new ArrayList<String>() {{
		    add("A B ");
		}};
		AssertJUnit.assertEquals(-1,processLogic.andPosision(list));
		
		list = new ArrayList<String>() {{
		    add("and");
		}};
		AssertJUnit.assertEquals(0,processLogic.andPosision(list));
		
  }

  @Test
  public void beDitector() {
	  //positive
	  AssertJUnit.assertEquals(-1,ProcessLogic.beDitector("I went school"));
	  AssertJUnit.assertEquals(1,ProcessLogic.beDitector("I am tall"));
	  AssertJUnit.assertEquals(1,ProcessLogic.beDitector("school is wonderful"));
	  AssertJUnit.assertEquals(3,ProcessLogic.beDitector("all the cats are hungry"));
	  AssertJUnit.assertEquals(4,ProcessLogic.beDitector("she and her mother were beautiful"));
	  AssertJUnit.assertEquals(2,ProcessLogic.beDitector("That girl was tall"));
	  AssertJUnit.assertEquals(1,ProcessLogic.beDitector("she will eat"));
	  AssertJUnit.assertEquals(1,ProcessLogic.beDitector("You shall go now"));
	  //negative
	  AssertJUnit.assertEquals(1,ProcessLogic.beDitector("I ain't tall"));
	  AssertJUnit.assertEquals(1,ProcessLogic.beDitector("school isn't wonderful"));
	  AssertJUnit.assertEquals(3,ProcessLogic.beDitector("all the cats aren't hungry"));
	  AssertJUnit.assertEquals(4,ProcessLogic.beDitector("she and her mother weren't beautiful"));
	  AssertJUnit.assertEquals(2,ProcessLogic.beDitector("That girl wasn't tall"));
	  AssertJUnit.assertEquals(1,ProcessLogic.beDitector("she won't eat"));
	  AssertJUnit.assertEquals(1,ProcessLogic.beDitector("You shan't go now"));
  }

  @Test
  public void getAnyWordMeaning() {
	  AssertJUnit.assertEquals("මම",ProcessLogic.getAnyWordMeaning("I"));
	  AssertJUnit.assertEquals("මා",ProcessLogic.getAnyWordMeaning("me"));
	  AssertJUnit.assertEquals("word not in database",ProcessLogic.getAnyWordMeaning("Ice"));
  }

  @Test
  public void getObjectMeaning() {
	  AssertJUnit.assertEquals("ඔහුට",processLogic.getObjectMeaning("him"));
	  AssertJUnit.assertEquals("ඇපල් ගෙඩිය",processLogic.getObjectMeaning("apple"));
	  AssertJUnit.assertEquals("",processLogic.getObjectMeaning("he"));
  }

  @Test
  public void isABeVerb() {
	  AssertJUnit.assertEquals(false,ProcessLogic.isABeVerb("he"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isABeVerb("cat"));
	  //positive
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("be"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("am"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("is"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("are"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("was"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("were"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("will"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("shall"));
	  //negative
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("ain't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("isn't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("aren't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("wasn't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("weren't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("won't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isABeVerb("shan't"));
  }

  @Test
  public void isAHvHs() {
	  //positive
	  AssertJUnit.assertEquals(true,ProcessLogic.isAHvHs("has"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isAHvHs("had"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isAHvHs("have"));
	  //negative
	  AssertJUnit.assertEquals(true,ProcessLogic.isAHvHs("hasn't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isAHvHs("hadn't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isAHvHs("haven't"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isAHvHs("hass"));
  }

  @Test
  public void isATime() {
	  AssertJUnit.assertEquals(false,ProcessLogic.isATime("has"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isATime("tomorrow"));
  }

  @Test
  public void isContinues() {
	  //positive
	  AssertJUnit.assertEquals(true,ProcessLogic.isContinues("I am coming"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isContinues("she is eating"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isContinues("They are going somewhere"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isContinues("she will be eating"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isContinues("They shall be going"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isContinues("People were coming"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isContinues("she was eating"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isContinues("she will be"));
  }

  @Test
  public void isDoDoes() {
	  AssertJUnit.assertEquals(true,ProcessLogic.isDoDoes("do"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isDoDoes("does"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isDoDoes("did"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isDoDoes("doesn't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isDoDoes("don't"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isDoDoes("didn't"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isDoDoes("donkey"));
  }

  @Test
  public void isIngVerb() {
	  AssertJUnit.assertEquals(true,ProcessLogic.isIngVerb("coming"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isIngVerb("come"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isIngVerb("riding"));
  }

  @Test
  public void isNormalVerb() {
	  AssertJUnit.assertEquals(false,ProcessLogic.isNormalVerb("riding"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isNormalVerb("goes"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isNormalVerb("eats"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isNormalVerb("went"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isNormalVerb("cries"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isNormalVerb("gone"));
  }

  @Test
  public void isObVal() {
	  AssertJUnit.assertEquals(false,processLogic.isObVal("gone"));
	  AssertJUnit.assertEquals(true,processLogic.isObVal("a"));
	  AssertJUnit.assertEquals(true,processLogic.isObVal("more"));
	  AssertJUnit.assertEquals(true,processLogic.isObVal("an"));
	  AssertJUnit.assertEquals(true,processLogic.isObVal("little"));
	  AssertJUnit.assertEquals(true,processLogic.isObVal("many"));
  }

  @Test
  public void isOnlyBeVerb() {
	  AssertJUnit.assertEquals(true,ProcessLogic.isOnlyBeVerb("The cat is fat"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOnlyBeVerb("The cat is going to be fat"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOnlyBeVerb("She was gone"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isOnlyBeVerb("tree is huge"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOnlyBeVerb("it is being modified"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isOnlyBeVerb("I am"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isOnlyBeVerb("That man is"));
  }

  @Test
  public void isOnlyHaveHas() {
	  AssertJUnit.assertEquals(false,ProcessLogic.isOnlyHaveHas("tree is huge"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isOnlyHaveHas("A tree has leaves"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOnlyHaveHas("I have gone there"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOnlyHaveHas("They have been coming"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOnlyHaveHas("He had being tortured"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOnlyHaveHas("The dogs have been hit"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isOnlyHaveHas("she had"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isOnlyHaveHas("Trees have leaves"));
  }

  @Test
  public void isOwnerShip() {
	  AssertJUnit.assertEquals(true,ProcessLogic.isOwnerShip("his"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isOwnerShip("my"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOwnerShip("him"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOwnerShip("him"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isOwnerShip("cat"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isOwnerShip("mother's"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isOwnerShip("mothers'"));
  }

  @Test
  public void isPerfectTense() {
	  AssertJUnit.assertEquals(false,ProcessLogic.isPerfectTense("They had been coming"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isPerfectTense("Mother has gone"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isPerfectTense("They had being drunk"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isPerfectTense("She had come"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isPerfectTense("She will have come"));
	  //negative
	  AssertJUnit.assertEquals(true,ProcessLogic.isPerfectTense("She hadn't come"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isPerfectTense("Mother hasn't gone"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isPerfectTense("She won't have come"));
  }

  @Test
  public void isPastParticiple() {
	  AssertJUnit.assertEquals(true,ProcessLogic.isPastParticiple("come"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isPastParticiple("drunk"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isPastParticiple("go"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isPastParticiple("ate"));
  }

  @Test
  public void isPreposision() {
	  AssertJUnit.assertEquals(false,ProcessLogic.isPreposision("ate"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isPreposision("in"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isPreposision("I"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isPreposision("on"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isPreposision("to"));
  }

  @Test
  public void isSimpleTense() {
	  AssertJUnit.assertEquals(true,ProcessLogic.isSimpleTense("They went"));
	  AssertJUnit.assertEquals(true,ProcessLogic.isSimpleTense("She comes"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isSimpleTense("I have gone there"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isSimpleTense("You should have come"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isSimpleTense("The cat was eating"));
	  AssertJUnit.assertEquals(false,ProcessLogic.isSimpleTense("The fat cat has a large tail"));
  }

  @Test
  public void normalVerbMean() {
	  AssertJUnit.assertEquals("එති",ProcessLogic.normalVerbMean("come"));
	  AssertJUnit.assertEquals("කති",ProcessLogic.normalVerbMean("eat"));
	  AssertJUnit.assertEquals("කයි",ProcessLogic.normalVerbMean("eats"));
	  AssertJUnit.assertEquals("ගියේය",ProcessLogic.normalVerbMean("went"));
  }

  @Test
  public void objValMean() {
	  AssertJUnit.assertEquals("ක්",processLogic.objValMean("a"));
	  AssertJUnit.assertEquals("ගොඩාක්",processLogic.objValMean("many"));
	  AssertJUnit.assertEquals("ගොඩාක්",processLogic.objValMean("more"));
  }

  @Test
  public void ownerShipMean() {
	  AssertJUnit.assertEquals("මගේ",ProcessLogic.ownerShipMean("my"));
	  AssertJUnit.assertEquals("ඔව්න්ගේ",ProcessLogic.ownerShipMean("their"));
	  AssertJUnit.assertEquals("ඔහුගේ",ProcessLogic.ownerShipMean("his"));
  }

  @Test
  public void prepoDitector() {
	  AssertJUnit.assertEquals(2,processLogic.prepoDitector("I came in"));
	  AssertJUnit.assertEquals(2,processLogic.prepoDitector("It is on the table"));
	  AssertJUnit.assertEquals(3,processLogic.prepoDitector("Please come here to rest"));
	  AssertJUnit.assertEquals(0,processLogic.prepoDitector("She went home"));
  }

  @Test
  public void propMean() {
	  AssertJUnit.assertEquals(" තුල",ProcessLogic.propMean("in"));
	  AssertJUnit.assertEquals(" මත",ProcessLogic.propMean("on"));
	  AssertJUnit.assertEquals(null,ProcessLogic.propMean("home"));
	  AssertJUnit.assertEquals(" පිලිබදව",ProcessLogic.propMean("about"));
  }

  @Test
  public void splitSentence() {
	String[] array=ProcessLogic.splitSentence("I came home yesterday when my mother was 	cooking");
	for(int i=0;i<array.length;i++){
		System.out.println(array[i]);
	}
  }
}
