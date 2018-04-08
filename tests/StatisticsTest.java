package tests;

import java.util.HashMap;

import users.Employer;
import users.Student;
import users.User;
import utilities.Statistics;

public class StatisticsTest {

	public StatisticsTest() {
		testTypePopulationsAndPercentages(); //Tests all Methods looking for specific Users
		testAttributesPopulationsAndPercentages(); //Tests all Methods looking for specific attributes
		
	}
	


	
	public static void testAttributesPopulationsAndPercentages() {
		Statistics attributesPopAndPercentTest = new Statistics();
		HashMap<String, User> q = new HashMap<String, User>();
		Student s1 = new Student();
		Employer e1 = new Employer();
		
		//Adding users to searching database
		s1.setUID("30054936");
		s1.setDegree("BIO");
		q.put(s1.getUID(), s1);
		
		s1 = new Student();
		s1.setUID("32154686");
		s1.setDegree("MED");
		q.put(s1.getUID(), s1);

		s1 = new Student();
		s1.setUID("32452386");
		s1.setDegree("BIO");
		q.put(s1.getUID(), s1);		
		
		q.put("1", e1);
		
		//Beginning Tests
	    assert(attributesPopAndPercentTest.howManyStudentsInDegree(q,"BIO") ==2): ("BIO Degree Test Failed, Was looking for 2 and got " + attributesPopAndPercentTest.howManyStudentsInDegree(q,"BIO"));
	    assert(attributesPopAndPercentTest.howManyStudentsInDegree(q,"MED") ==1): ("MED Degree Test Failed, Was looking for 1 and got " + attributesPopAndPercentTest.howManyStudentsInDegree(q,"MED"));
	    assert(attributesPopAndPercentTest.howManyStudentsInDegree(q,"ENG") ==0): ("ENG Degree Test Failed, Was looking for 0 and got " + attributesPopAndPercentTest.howManyStudentsInDegree(q,"ENG"));
	    
	    //Prints if none of the assertions are thrown
	    System.out.println("All Statistics Tests for Searching Attributes Passed");
		
	}
	
	
	
	public static void testTypePopulationsAndPercentages() {
		Statistics typePopAndPercentTest = new Statistics();
		HashMap<String, User> q = new HashMap<String, User>();
		Student s1 = new Student();
		Employer e1 = new Employer();
		
		//Adding users to searching database
		s1.setUID("30054936");
		s1.setGPA(3.1);
		q.put(s1.getUID(), s1);
		
		s1 = new Student();
		s1.setUID("32154686");
		s1.setGPA(1.1);
		q.put(s1.getUID(), s1);
		
		s1 = new Student();
		s1.setUID("30098531");
		s1.setGPA(2.1);
		q.put(s1.getUID(), s1);
		
		q.put("1", e1);
		
		//Beginning Tests
	    assert(typePopAndPercentTest.howManyStudents(q) ==3): ("Amount of Students Test Failed, Was looking for 3 and got " + typePopAndPercentTest.howManyStudents(q));
	    assert(typePopAndPercentTest.percentageofStudents(q) ==75.0): ("Percentage of Students Test Failed, Was looking for 75.0 and got " + typePopAndPercentTest.percentageofStudents(q));
	    assert(typePopAndPercentTest.howManyEmployers(q) ==1): ("Amount of Employers Test Failed, Was looking for 1 and got " + typePopAndPercentTest.howManyEmployers(q));
	    assert(typePopAndPercentTest.percentageofEmployers(q) ==25.0): ("Percentage of Employers Test Failed, Was looking for 25.0 and got " + typePopAndPercentTest.percentageofEmployers(q));
	    
	    //Prints if none of the assertions are thrown
	    System.out.println("All Statistics Tests for Searching Types of Users Passed");
	}
	
}
