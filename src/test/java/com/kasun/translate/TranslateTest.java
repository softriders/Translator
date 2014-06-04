package com.kasun.translate;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class TranslateTest {
	Translate translate;
  @BeforeTest
  public void setup() {
	  translate=new Translate();
  }


  @Test
  public void getMeaning() {
    System.out.println(translate.getMeaning("I came home"));
    AssertJUnit.assertEquals(" මම ගෙදර අවේය",translate.getMeaning("I came home"));
    System.out.println(translate.getMeaning("Mother eat rice"));
    System.out.println(translate.getMeaning("He has a school"));
    System.out.println(translate.getMeaning("She has come school"));
    System.out.println(translate.getMeaning("He is going"));
    System.out.println(translate.getMeaning("I had a school"));
    System.out.println(translate.getMeaning("I was going to school"));
    System.out.println(translate.getMeaning("Mother had eaten apple"));
  }
}
