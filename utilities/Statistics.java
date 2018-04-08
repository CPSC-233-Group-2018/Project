/**
 * 
 */
package utilities;

import java.util.HashMap;

import users.Employer;
import users.Student;
import users.User;

/**Has multiple methods to compute statistics of a database*/
public class Statistics {
	
	
	/**Default Constructor*/
	public Statistics() {
	}
	
	/** A method that returns the amount of Students as an int in a HashMap */
	public int howManyStudents(HashMap<String, User> db){
		int count = 0;
		for (String key : db.keySet()) {
				if (db.get(key).getGPA()>0) { //only students will have a GPA above 0
					count += 1;
				}
				else {
					
				}
		
	  }		
		return count;
	}
	
	/**Method returns a double representing the percentage of the population that is students*/
	public double percentageofStudents(HashMap<String, User> db){
		double populationCount = 0.0; //The count of all users
		double studentCount = 0.0; //Count of how many students are in the HashMap
		for (String key : db.keySet()) {
			populationCount += 1;
				if (db.get(key).getGPA()>0) { //only students will have a GPA above 0
					studentCount += 1;
				}
		
	  }
		//System.out.println("Total Population: " + populationCount);
		//System.out.println("Total Student Population: " + studentCount);

		return (100*(studentCount/populationCount)); //Multiply by 100 to represent a percentage
	}
	
	/** A method that returns the amount of Employers as an int in a HashMap */
	public int howManyEmployers(HashMap<String, User> db){
		int count = 0;
		for (String key : db.keySet()) {
				if (db.get(key).getGPA()==0.0) { //only Employers will have a GPA of 0
					count += 1;
				}
				else {
					
				}
		
	  }		
		return count;
	}
	
	/**Method returns a double representing the percentage of the population that is Employers*/
	public double percentageofEmployers(HashMap<String, User> db){
		double populationCount = 0.0; //The count of all users
		double employerCount = 0.0; //Count of how many Employers are in the HashMap
		for (String key : db.keySet()) {
			populationCount += 1;
				if (db.get(key).getGPA()== 0.0) { //only students will have a GPA above 0
					employerCount += 1;
				}
		
	  }
		//System.out.println("Total Population: " + populationCount);
		//System.out.println("Total Student Population: " + studentCount);

		return (100*(employerCount/populationCount)); //Multiply by 100 to represent a percentage
	}
	
	
	/** A method that returns the amount of Students have a specific Degree as an int in a HashMap */
	public int howManyStudentsInDegree(HashMap<String, User> db, String degree){
		int count = 0;
		for (String key : db.keySet()) {
				if (db.get(key).getDegree().equals(degree)) { //only students that are in the degree type
					count += 1;
				}
				else {
					
				}
		
	  }		
		return count;
	}
	
	

}