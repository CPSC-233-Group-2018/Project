package utilityUsers;
import java.util.*;

import users.Student;

import java.text.DecimalFormat;
import java.io.*;

public class JohnDoe extends Student implements Serializable{

  public JohnDoe(){
    randomUser();
    createRandomUIDNumber();
    createRandomUniversity();
    createRandomDegree();
    createRandomYear();
    createRandomGPA();
    if (getProgramYear() < 5){
      setStudentType("Undergraduate Student");
    }

    if (getProgramYear() >= 5 && getProgramYear() < 8){
      setStudentType("Masters Student");
    }

    if (getProgramYear() >= 8){
      setStudentType("Doctoral Candidate");
    }

  }
  /** A method to create a random UID #*/
  public void createRandomUIDNumber(){
    Random rand = new Random();

    int n = (30000000 + rand.nextInt(900000) + 1);
    String randomUID = Integer.toString(n);
    setUID(randomUID);
  }

  /** A method to create a random University*/
  public void createRandomUniversity(){
    Random rand = new Random();
    String names[] = {"University of Calgary","University of Lethbridge","University of Alabama","University of Alberta","University of Toronto","University of Oregon","University of Portland","University of Staffordshire","University of Westminister","University of Kent","University of California","Massachusetts Institute of Technology","keele university","University of Milan","University of Turin","University of Bologna","Ca' Foscari University of Venice","University of Grenoble","University of British Columbia","Université Pierre et Marie Curie","Harvard University","McGill University","Princeton University","University of Chicago","University of Halifax","Stanford University","University of Pennsylvania","Mount Royal Collage","St. Mary's University", "Devry"};
    String randomUniversity = (names[(rand.nextInt(29))]);
    setUniversity(randomUniversity);
  }

  /** A method to create a random Year*/
  public void createRandomYear(){
    Random rand = new Random();
    int n = (rand.nextInt(7)+1);
    setProgramYear(n);
  }

  /** A method to create a random GPA #*/
  public void createRandomGPA(){
    double rangeMin = 2.0;
    double rangeMax = 4.0;
    Random rand = new Random();
    double n = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
    setGPA(n);
  }

  /** A method to create a random University*/
  public void createRandomDegree(){
    Random rand = new Random();
    String names[] = {"CPSC","BIO", "MED", "ENG", "SOCI", "PSYC"};
    String randomDegree = (names[(rand.nextInt(5))]);
    setDegree(randomDegree);
  }


  public void printContactInfo(){
    /** A method that prints a users atributes*/
    DecimalFormat twoDecimals = new DecimalFormat(".##");
    System.out.println("\nSearching database for: "+ getFirstName() + " " + getLastName());
    System.out.println("\n\nUsers Name is: " + getFirstName() + " " + getLastName());
    System.out.println("Users UID is: "+ getUID());
    System.out.println("Users University is: "+ getUniversity());
    System.out.println("Users Program Year is: "+ getProgramYear());
    System.out.println("User is a : "+ getStudentType());
    System.out.println("Users Degree is: "+ getDegree());
    System.out.println("Users GPA is: "+ twoDecimals.format(getGPA()));
    System.out.println("Phone Numebr: "+ getPhoneNumber());
    System.out.println("Email Address: "+ getEmail());
    System.out.println("Country: " + getCountry());
    System.out.println("Province: " + getProvince());
    System.out.println("City: " + getCity());
  }


}
