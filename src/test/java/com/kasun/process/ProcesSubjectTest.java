package com.kasun.process;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
//import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ProcesSubjectTest {
	 ProcesSubject procesSubject;
	 @BeforeTest
	 public void setup() {
		 procesSubject = new ProcesSubject();
	 }
	 

  @Test
  public void getSubjectMean() {
      AssertJUnit.assertEquals("sentence is empty",procesSubject.getSubjectMean(""));
      AssertJUnit.assertEquals("sentence is empty",procesSubject.getSubjectMean(" "));
      AssertJUnit.assertEquals("sentence is empty",procesSubject.getSubjectMean(null));
      AssertJUnit.assertEquals(" word not in database ",procesSubject.getSubjectMean("a"));
      AssertJUnit.assertEquals(" මම ",procesSubject.getSubjectMean("I"));
      AssertJUnit.assertEquals(" අම්මා ",procesSubject.getSubjectMean("Mother"));
      AssertJUnit.assertEquals(" ඔහුගේ  ගෙදර ",procesSubject.getSubjectMean("his home"));
      AssertJUnit.assertEquals(" ඔහුගේ  මව  සහා  මගේ  මව ",procesSubject.getSubjectMean("his mother and my mother is going to talk to me"));
  }

  @Test
  public void subAsArrayList() {
	System.out.println("=======start testing subAsArrayList()============");
    System.out.println("output for 'I eat rice' is "+procesSubject.subAsArrayList("I eat rice"));
    System.out.println("output for 'I eat rice' is "+procesSubject.subAsArrayList("I eat rice"));
    System.out.println("=======end testing subAsArrayList()==============");
  }
}
