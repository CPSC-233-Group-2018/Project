import java.util.Scanner;

public class Student extends User{


  public int programYear;
  public String UID; //university ID number
  public String university; //Create a dropdown list of options
  public String degree;
  public double GPA;
  public String studentType;


  public void set_User_Attributes(){
    setContactInfo();
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);
    /** A method to set a users attributes based on user input*/


    System.out.println("\nWhat year of your degree are you in?:  ");
    programYear = input.nextInt();

    System.out.println("\nWhat university are you at?: ");
    university = input2.nextLine();

    System.out.println("\nPlease put in your 8 digit UID: ");
    UID = input3.nextLine();

    System.out.println("\nWhat degree are you in?: ");
    degree = input4.nextLine();

    System.out.println("\nWould You like to input or calculate your GPA? (1 for input 2 for calcuate): ");
    GPA = input2.nextInt();
    if (GPA == 1){
      System.out.println("\nPlease Enter your GPA: ");
      GPA = input4.nextDouble();
    }
    if (GPA == 2){
      calc_GPA();
    }

    System.out.println("\nAre you an (1)undergraduate student, (2)masters student, or (3)doctoral candidate?: ");
    int choice = input3.nextInt();

    switch(choice){
      case 1: studentType = "Undergraduate Student";
        break;
      case 2: studentType = "Masters Student";
        break;
      case 3: studentType = "Doctoral Candidate";
      break;

    }
  }

  public void calc_GPA(){
    /** A method to calculate a users GPA based on input */
    GPA = 0;
    Scanner input1 = new Scanner(System.in); //GPA Calculation
		System.out.println("Enter number of courses: ");
		int courseAmount = input1.nextInt();
		double weightTotal = 0;
		for (int i = 0; i < courseAmount; i++) {
		 System.out.println("Enter grade for course " + (i+1) + ": ");
		 double grade = 0;
		 grade = input1.nextDouble();
		 System.out.println("Enter weight for course " + (i+1) + ": ");
		 double weight = 0;
		 weight = input1.nextDouble();
		 GPA += (grade*weight);
		 weightTotal += weight;
		}
		GPA /= weightTotal;
		System.out.println("Your GPA is: " + GPA);
  }


  public void print_Vars(){
    /** A method that prints a users atributes*/
    System.out.println("\nSearching database for: " + fullName);

    printContactInfo();
    System.out.println("Users UID is: "+ UID);
    System.out.println("Users University is: "+ university);
    System.out.println("User is a : "+ studentType);
    System.out.println("Users Program Year is: "+ programYear);
    System.out.println("Users Degree is: "+ degree);
    System.out.println("Users GPA is: "+ GPA);

  }

}
