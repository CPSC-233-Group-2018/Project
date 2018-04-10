package users;

import java.util.Scanner;

public class Student extends User{


  private int programYear;
  private String UID; //university ID number
  private String university; //Create a dropdown list of options
  private String degree;
  private double GPA;
  private String studentType = "";
  private String DOB;

  //Default Constructor
  public Student(){

  }

  //Copy Constructor used to make user to student
  // Student(User toCopy) {
  //   super(toCopy); //calls the User class's constructor to copy common attributes (like name for example)
  // }


  /**
    * Method for setting instance variables for student
    */
  public void set_User_Attributes(){
    setContactInfo();
    Scanner input = new Scanner(System.in);
    /** A method to set a users attributes based on user input*/
    System.out.println("\nWhat year of your degree are you in?:  ");
    input = new Scanner(System.in);
    programYear = input.nextInt();

    System.out.println("\nWhat university are you at?: ");
    input = new Scanner(System.in);
    university = input.nextLine();

    System.out.println("\nPlease put in your 8 digit UID: ");
    input = new Scanner(System.in);
    UID = input.nextLine();

    System.out.println("\nWhat degree are you in?: ");
    input = new Scanner(System.in);
    degree = input.nextLine();

    System.out.println("\nWould You like to input or calculate your GPA? (1 for input 2 for calcuate): ");
    input = new Scanner(System.in);
    GPA = input.nextInt();
    if (GPA == 1){
      System.out.println("\nPlease Enter your GPA: ");
      input = new Scanner(System.in);
      GPA = input.nextDouble();
    }
    if (GPA == 2){
      calc_GPA();
    }

    System.out.println("\nAre you an (1)undergraduate student, (2)masters student, or (3)doctoral candidate?: ");
    input = new Scanner(System.in);
    int choice = input.nextInt();

    switch(choice){
      case 1: studentType = "Undergraduate Student";
        break;
      case 2: studentType = "Masters Student";
        break;
      case 3: studentType = "Doctoral Candidate";
      break;

    }
  }

  /**
    * Method for calculating the gpa and setting it to instance variable
    */
  public void calc_GPA(){
    GPA = 0;
    Scanner input = new Scanner(System.in); //GPA Calculation
		System.out.println("Enter number of courses: ");
    input = new Scanner(System.in);
		int courseAmount = input.nextInt();
		double weightTotal = 0;
		for (int i = 0; i < courseAmount; i++) {
		 System.out.println("Enter grade for course " + (i+1) + ": ");
		 double grade = 0;
     input = new Scanner(System.in);
		 grade = input.nextDouble();
		 System.out.println("Enter weight for course " + (i+1) + ": ");
		 double weight = 0;
     input = new Scanner(System.in);
		 weight = input.nextDouble();
		 GPA += (grade*weight);
		 weightTotal += weight;
		}
		GPA /= weightTotal;
		System.out.println("Your GPA is: " + GPA);
  }

  /**
    * Method equivalent to toString
    */
  @Override
  public void printContactInfo(){
    System.out.println("\nSearching database for: " + getFirstName());
    super.printContactInfo();
    System.out.println("Users UID is: "+ getUID());
    System.out.println("Users University is: "+ getUniversity());
    System.out.println("User is a: "+ getStudentType());
    System.out.println("Users Program Year is: "+ getProgramYear());
    System.out.println("Users Degree is: "+ getDegree());
    System.out.println("Users GPA is: "+ getGPA());

  }

  /** Setter for UID*/
  public void setUID(String newUID){
    UID = newUID;
  }

  /** Getter for UID
    * @return UID
    */
  public String getUID(){
    String printedUID = new String(UID);
    return printedUID;
  }

  /** Setter for University*/
  public void setUniversity(String newUniversity){
    university = newUniversity;
  }

  /** Getter for University
    * @return printedUniversity
    */
  public String getUniversity(){
    String printedUniversity = new String(university);
    return printedUniversity;
  }

  /** Setter for StudentType*/
  public void setStudentType(String newStudentType){
    studentType = newStudentType;
  }

  /** Getter for StudentType
    * @return printedStudentType
    */
  public String getStudentType(){
    String printedStudentType = new String(studentType);
    return printedStudentType;
  }

  /** Setter for ProgramYear*/
  public void setProgramYear(int newProgramYear){
    programYear = newProgramYear;
  }

  /** Getter for ProgramYear
    * @return printedProgramYear
    */
  public int getProgramYear(){
    int printedProgramYear = new Integer(programYear);
    return printedProgramYear;
  }

  /** Setter for Degree*/
  public void setDegree(String newDegree){
    degree = newDegree;
  }

  /** Getter for Degree
    * @return printedDegree
    */
  public String getDegree(){
    String printedDegree = new String(degree);
    return printedDegree;
  }

  /** Setter for GPA*/
  public void setGPA(Double newGPA){
    GPA = newGPA;
  }

  /** Getter for GPA
    * @return printedGPA
    */
  public Double getGPA(){
    double printedGPA = new Double(GPA);
    return printedGPA;
  }

  /** Getter for Date of birth
    * @return printedDOB
    */
  public String getDOB() {
	  String printedDOB = new String(DOB);
	  return printedDOB;
  }

  public void setDOB(String dob) {
	  DOB = dob;
  }

}
