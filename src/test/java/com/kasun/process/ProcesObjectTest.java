package com.kasun.process;

import java.util.ArrayList;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.AssertJUnit;

public class ProcesObjectTest {
	ProcesObject procesObject;
  @BeforeTest
  public void setup() {
	  procesObject=new ProcesObject();
  }

  @Test
  public void andPosision() {
	  ArrayList<String> list = new ArrayList<String>() {{
		    add("A");
		    add("and");
		    add("B");
		}};
		AssertJUnit.assertEquals(1,ProcesObject.andPosision(list));
	  
	  list = new ArrayList<String>() {{
		    add("A B ");
		}};
		AssertJUnit.assertEquals(-1,ProcesObject.andPosision(list));
		
		list = new ArrayList<String>() {{
		    add("and");
		}};
		AssertJUnit.assertEquals(0,ProcesObject.andPosision(list));
		
  }

  @Test
  public void getObjectMeaning() {
	  AssertJUnit.assertEquals("ගෙදර",ProcesObject.getObjectMeaning("home"));
	  AssertJUnit.assertEquals("මා",ProcesObject.getObjectMeaning("me"));
	  AssertJUnit.assertEquals("බත්",ProcesObject.getObjectMeaning("rice"));
  }

  @Test
  public void isATime() {
	  AssertJUnit.assertEquals(false,procesObject.isATime("home"));
	  AssertJUnit.assertEquals(true,procesObject.isATime("tomorrow"));
	  AssertJUnit.assertEquals(false,procesObject.isATime("rice"));
  }

  @Test//reconsider
  public void isAndInObjects() {
    	AssertJUnit.assertEquals(true, ProcesObject.isAndInObjects("I came home and ate rice"));
    	AssertJUnit.assertEquals(false, ProcesObject.isAndInObjects("I eat rice"));
    	AssertJUnit.assertEquals(true, ProcesObject.isAndInObjects("Mother went there and came"));
    	AssertJUnit.assertEquals(false, ProcesObject.isAndInObjects("rice"));
  }

  @Test
  public void isObVal() {
	  	AssertJUnit.assertEquals(false, ProcesObject.isObVal("Mother"));
  		AssertJUnit.assertEquals(false, ProcesObject.isObVal("Aandk"));
  		AssertJUnit.assertEquals(true, ProcesObject.isObVal("a"));
  		AssertJUnit.assertEquals(true, ProcesObject.isObVal("many"));
  }

  @Test
  public void makeObjectsAsList() {
	System.out.println("Testing makeObjectsAsList");
    System.out.println("output of 'I have my home' is "+ ProcesObject.makeObjectsAsList("I have my home"));
    System.out.println("output of 'I eat rice' is "+ ProcesObject.makeObjectsAsList("I eat rice"));
    System.out.println("output of 'Mother and I came home and ate' is "+ ProcesObject.makeObjectsAsList("Mother and I came home and ate"));
    System.out.println("output of 'Mother and I have come to home with him' is "+ ProcesObject.makeObjectsAsList("Mother and I have come to home with him"));
    System.out.println("End of Testing makeObjectsAsList");
  }

  @Test
  public void objMean() {
	  AssertJUnit.assertEquals("කන්නට ",procesObject.objMean("I came to eat"));
	  AssertJUnit.assertEquals("ඇපල් ගෙඩියක් ",procesObject.objMean("The bird ate an apple"));
	  AssertJUnit.assertEquals("බත් ",procesObject.objMean("She and her friends ate rice"));
  }

  @Test
  public void objValMean() {
	  AssertJUnit.assertEquals("ක්",ProcesObject.objValMean("a"));
	  AssertJUnit.assertEquals("ගොඩාක්",ProcesObject.objValMean("more"));
  }

  @Test
  public void ownerShipMean() {
		AssertJUnit.assertEquals("", procesObject.ownerShipMean("your"));
  		AssertJUnit.assertEquals("ඔහුගේ", procesObject.ownerShipMean("his"));
  		AssertJUnit.assertEquals( "ඇයගේ", procesObject.ownerShipMean("her"));
  }

  @Test
  public void veryfyAnd() {
	System.out.println("Testing veryfyAnd");
    System.out.println("output of 'I came here' is "+ProcesObject.veryfyAnd("I came here"));
    System.out.println("output of 'I came here and ate rice' is "+ProcesObject.veryfyAnd("I came here and ate rice"));
    System.out.println("end of Testing veryfyAnd");
  }
}
