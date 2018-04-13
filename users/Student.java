package users;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends User {


private int programYear;
private String UID;   //university ID number
private String university;   //Create a dropdown list of options
private String degree;
private double GPA;
private String studentType = "";

//Default Constructor
public Student(){

}


/**
 * Method for setting instance variables for student
 */
public void set_User_Attributes(){
        setContactInfo();
        Scanner input = new Scanner(System.in);
        int decision = 0; //Used to store decision Values
        boolean validNumber = false; //Used to Validate Number choice
        System.out.println("\nWhat year of your degree are you in?:  ");
        input = new Scanner(System.in);
        programYear = input.nextInt();

        System.out.println("\nWhat university are you at?: ");
        input = new Scanner(System.in);


        switch(this.getProvince()) {

        case ("Alberta"):
                System.out.println("(1)University of Calgary \n(2)University of Lethbridge \n(3)SAIT \n(4)Mount Royal \n(5)Athabasca University");
                decision = input.nextInt();

                switch(decision) {//Inside Alberta
                case 1: this.university = "University of Calgary";
                        break;

                case 2: this.university = "University of Lethbridge";
                        break;

                case 3: this.university = "SAIT";
                        break;

                case 4: this.university = "Mount Royal";
                        break;

                case 5: this.university = "Athabasca University";
                        break;

                }
                break;

        case ("Illinois"):
                System.out.println("(1)University of Chicago \n(2)Boston University");
                decision = input.nextInt();

                switch(decision) {// Inside Illinois
                case 1: this.university = "University of Chicago";
                        break;

                case 2: this.university = "Boston University";
                        break;

                }
                break;

        case ("Nevada"):
                System.out.println("(1)University of Vegas ");
                decision = input.nextInt();

                switch(decision) {//Inside Nevada
                case 1: this.university = "University of Vegas";
                        break;
                }
                break;


        case ("Massachusetts"):
                System.out.println("(1)MIT");
                decision = input.nextInt();

                switch(decision) {
                case 1: this.university = "MIT";
                        break;
                }
                break;
        }


        System.out.println("\nPlease put in your 8 digit UID: ");
        UID = validateUID();

        System.out.println("\nWhat degree program are you in?: ");
        System.out.println("(1)BIO \n(2)ENG  \n(3)MED \n(4)CPSC \n(5)COMM \n(6)PSYC \n(7)SOCI \n(8)CMF \n(9)LING");

        input = new Scanner(System.in);
        decision = input.nextInt();


        switch(decision) {

        case 1: this.degree = "BIO";
                System.out.println("\nDegree Program set to BIO (Biology)");
                break;

        case 2: this.degree = "ENG";
                System.out.println("\nDegree Program set to ENG (Engineering)");
                break;

        case 3: this.degree = "MED";
                System.out.println("\nDegree Program set to MED (Medicine)");
                break;

        case 4: this.degree = "CPSC";
                System.out.println("\nDegree Program set to CPSC (Biology)");
                break;

        case 5: this.degree = "COMM";
                System.out.println("\nDegree Program set to COMM (Commerce)");
                break;

        case 6: this.degree = "PSYC";
                System.out.println("\nDegree Program set to PSYC (Psychology)");
                break;

        case 7: this.degree = "SOCI";
                System.out.println("\nDegree Program set to SOCI (Sociology)");
                break;

        case 8: this.degree = "CMF";
                System.out.println("\nDegree Program set to CMF (Communications, Media, and Film)");
                break;

        case 9: this.degree = "LING";
                System.out.println("\nDegree Program set to LING (Linguistics)");
                break;

        }

        System.out.println("\nWould You like to input or calculate your GPA? (1 for input 2 for calcuate): ");
        input = new Scanner(System.in);
        GPA = input.nextInt();
        if (GPA == 1) {
                System.out.println("\nPlease Enter your GPA: ");
                input = new Scanner(System.in);
                setGPA(input.nextDouble());
        }
        if (GPA == 2) {
                calc_GPA();
        }

        System.out.println("\nAre you an (1)undergraduate student, (2)masters student, or (3)doctoral candidate?: ");
        input = new Scanner(System.in);
        int choice = input.nextInt();

        switch(choice) {
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

/**Method to validate UID for Scanner input*/
public String validateUID() {
	boolean validUID = false;
	String newUID = "";
	Scanner enterUID = new Scanner(System.in);

	while(validUID == false) {

		newUID = enterUID.nextLine();
	if (!newUID.matches("[0-9]+") || newUID.length() != 8) {
		System.out.println("Invalid UID entered Please Try Again");
		validUID = false;
	}
	else {
		validUID = true;
	}
  }
	return newUID;
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
        if(newGPA <1.5){
          newGPA = 1.5;
        }
        GPA = newGPA;
}

/** Getter for GPA
 * @return printedGPA
 */
public Double getGPA(){
        double printedGPA = new Double(GPA);
        return printedGPA;
}

}
