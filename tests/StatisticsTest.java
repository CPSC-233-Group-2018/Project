package tests;

import java.util.HashMap;

import users.Employer;
import users.Student;
import users.User;
import utilities.Statistics;

/**Class to test the Statistics class and validate functionality*/
public class StatisticsTest {

/**Constructor that starts all the tests*/
public StatisticsTest() {
								testTypePopulationsAndPercentages(); //Tests all Methods looking for specific Users
								testAttributesPopulationsAndPercentages(); //Tests all Methods looking for specific attributes

}



/**Tests all statistics methods that have to do with User Attributes i.e. Degree*/
public static void testAttributesPopulationsAndPercentages() {
								Statistics attributesPopAndPercentTest = new Statistics();
								HashMap<String, User> q = new HashMap<String, User>();
								HashMap<String, User> z = new HashMap<String, User>(); //Empty HashMap
								Student s1 = new Student();
								Employer e1 = new Employer();

								//Adding users to searching database
								s1.setUID("30054936");
								s1.setDegree("BIO");
								s1.setGPA(4.0);
								s1.setUniversity("q");
								q.put(s1.getUID(), s1);

								s1 = new Student();
								s1.setUID("32154686");
								s1.setDegree("MED");
								s1.setGPA(3.0);
								s1.setUniversity("q");
								q.put(s1.getUID(), s1);

								s1 = new Student();
								s1.setUID("32452386");
								s1.setDegree("BIO");
								s1.setGPA(2.0);
								s1.setUniversity("v");
								q.put(s1.getUID(), s1);

								q.put("1", e1);

								//Valid input Tests
								assert (attributesPopAndPercentTest.howManyStudentsInDegree(q,"BIO") ==2) : ("BIO Degree Test Failed, Was looking for 2 and got " + attributesPopAndPercentTest.howManyStudentsInDegree(q,"BIO"));
								assert (attributesPopAndPercentTest.howManyStudentsInDegree(q,"MED") ==1) : ("MED Degree Test Failed, Was looking for 1 and got " + attributesPopAndPercentTest.howManyStudentsInDegree(q,"MED"));
								assert (attributesPopAndPercentTest.overallMeanGPA(q) == 3.0) : ("Mean GPA Test Failed, Was Looking for 3.0 and got " + attributesPopAndPercentTest.overallMeanGPA(q));
								assert (attributesPopAndPercentTest.universityMeanGPA(q,"q") == 3.5) : ("Mean GPA Test for University 'q' Failed, Was Looking for 3.5 and got " + attributesPopAndPercentTest.universityMeanGPA(q,"q"));
								assert (attributesPopAndPercentTest.universityMeanGPA(q,"v") == 2.0) : ("Mean GPA Test for University 'q' Failed, Was Looking for 2.0 and got " + attributesPopAndPercentTest.universityMeanGPA(q,"q"));

								//Empty HashMap & No User Found Tests
								assert (attributesPopAndPercentTest.universityMeanGPA(q,"l") == 0.0) : ("Mean GPA Test for University 'l' Failed, Was Looking for 0.0 and got " + attributesPopAndPercentTest.universityMeanGPA(q,"l")); //No Students at the University
								assert (attributesPopAndPercentTest.howManyStudentsInDegree(q,"ENG") ==0) : ("ENG Degree Test Failed, Was looking for 0 and got " + attributesPopAndPercentTest.howManyStudentsInDegree(q,"ENG")); //No Students in Degree
								assert (attributesPopAndPercentTest.universityMeanGPA(z,"l") == 0.0) : ("Mean GPA Test for University 'l' Failed, Was Looking for 0.0 and got " + attributesPopAndPercentTest.universityMeanGPA(z,"l"));//Empty HashMap
								assert (attributesPopAndPercentTest.overallMeanGPA(z) == 0.0) : ("Mean GPA Test Failed, Was Looking for 0.0 and got " + attributesPopAndPercentTest.overallMeanGPA(z));//Empty HashMap


								//Prints if none of the assertions are thrown
								System.out.println("All Statistics Tests for Searching Attributes Passed");

}


/**Tests all statistics methods that have to do with User Types i.e. Student, or Employer*/
public static void testTypePopulationsAndPercentages() {
								Statistics typePopAndPercentTest = new Statistics();
								HashMap<String, User> q = new HashMap<String, User>();
								HashMap<String, User> z = new HashMap<String, User>(); //Empty HashMap
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

								//Valid input tests
								assert (typePopAndPercentTest.howManyStudents(q) ==3) : ("Amount of Students Test Failed, Was looking for 3 and got " + typePopAndPercentTest.howManyStudents(q));
								assert (typePopAndPercentTest.percentageofStudents(q) ==75.0) : ("Percentage of Students Test Failed, Was looking for 75.0 and got " + typePopAndPercentTest.percentageofStudents(q));
								assert (typePopAndPercentTest.howManyEmployers(q) ==1) : ("Amount of Employers Test Failed, Was looking for 1 and got " + typePopAndPercentTest.howManyEmployers(q));
								assert (typePopAndPercentTest.percentageofEmployers(q) ==25.0) : ("Percentage of Employers Test Failed, Was looking for 25.0 and got " + typePopAndPercentTest.percentageofEmployers(q));

								//Empty HashMap Tests

								assert (typePopAndPercentTest.howManyStudents(z) ==0.0) : ("Empty HashMap Test: Amount of Students Test Failed, Was looking for 0 and got " + typePopAndPercentTest.howManyStudents(z));
								assert (typePopAndPercentTest.percentageofStudents(z) ==0.0) : ("Empty HashMap Test: Percentage of Students Test Failed, Was looking for 0 and got " + typePopAndPercentTest.percentageofStudents(z));
								assert (typePopAndPercentTest.howManyEmployers(z) ==0.0) : ("Empty HashMap Test: Amount of Employers Test Failed, Was looking for 0 and got " + typePopAndPercentTest.howManyEmployers(z));
								assert (typePopAndPercentTest.percentageofEmployers(z) ==0.0) : ("Empty HashMap Test: Percentage of Employers Test Failed, Was looking for 0 and got " + typePopAndPercentTest.percentageofEmployers(z));

								//Prints if none of the assertions are thrown
								System.out.println("All Statistics Tests for Searching Types of Users Passed");
}

}
