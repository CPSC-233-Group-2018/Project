package utilities;
import java.util.Scanner;

import users.Employer;
import users.Student;
import users.User;
import utilityUsers.EmployerJohnDoe;
import utilityUsers.JohnDoe;

import java.util.ArrayList;

public class Menu {
// public static Scanner mainclassinput = new Scanner(System.in);
private Student s1 = new Student();
private JohnDoe jd = new JohnDoe();
private EmployerJohnDoe e = new EmployerJohnDoe();
private Database db = new Database();
private Employer ep = new Employer();
private FileIO f = new FileIO();
private int employerCount = 0;   //Count of the amount of employers (acts like UID)
private String currentCount;
public void createStudent(){
        /** method to call all methods needed to create a user*/
        s1.set_User_Attributes();

        if (s1.getGPA() == 2) {
                s1.calc_GPA();
        }

        if (s1.getGPA() == 1) {
                Scanner GPAInput = new Scanner(System.in);
                System.out.println("\nEnter your GPA: ");
                s1.setGPA(GPAInput.nextDouble());
        }
}


public void selectMenu(){
        /** Gives the user options to select from that call methods*/
        Scanner input = new Scanner(System.in);
        String sChoice = "";


        System.out.println("\nPlease select an option:");
        System.out.println("1 for creating a new Student:");
        System.out.println("2 for creating an Employer: ");
        System.out.println("3 Search for a user: ");
        System.out.println("4 for creating and printing random users:");
        System.out.println("5 Load database: ");
	      System.out.println("6 Search for multiple users: "); //will expand this to search by other criteria too
        System.out.println("7 Exit program: ");

        input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) { //users choice of action with 3 cases
        case 1: createStudent(); //If they select 1 at the first menu create a new student and add to database
                db.database.put(s1.getUID(),s1);
                s1 = new Student();
                break;

        case 2: ep.setEmployerAttributes();
                currentCount = Integer.toString(employerCount);
                db.database.put(currentCount,ep);
                ep = new Employer(); //Resets Class after its creation
                employerCount += 1;
                break;

        case 3: db.searchUser();
                break;

        case 4: System.out.println("\nPlease select an option: ");
                System.out.println("1 for creating a database of random students: ");
                System.out.println("2 for creating a database of random Employers: ");

                input = new Scanner(System.in);
                int choice2Selection = input.nextInt();

                switch (choice2Selection) { //users choice of what type of class to print

                case 1: db.createRandomStudents();
                // System.out.println("Enter S to save: ");
                // input = new Scanner(System.in);
                // sChoice = input.nextLine();
                // sChoice = sChoice.toUpperCase();
                // if (sChoice.equals("S")) {
                  f.fileSave(db.getDatabase());
                // }
                        break;

                case 2: employerCount = db.createRandomEmployers(employerCount);
                // System.out.println("Enter S to save: ");
                // input = new Scanner(System.in);
                // sChoice = input.nextLine();
                // sChoice = sChoice.toUpperCase();
                // if (sChoice.equals("S")) {
                  f.fileSave(db.getDatabase());
                // }
                        break;
                }
                break;

        case 5: db = new Database(f.fileLoad());
                break;


		case 6: System.out.println("Enter 1 to search by first name: ");
            System.out.println("Enter 2 to search by last name: ");
            System.out.println("Enter 3 to search by major: ");
            System.out.println("Enter 4 to search by GPA: ");

            input = new Scanner(System.in);
            int searchBy = input.nextInt();
            ArrayList<User> tempList = new ArrayList<User>();
            if (searchBy == 1 || searchBy == 2 || searchBy == 3) {
              if (searchBy == 1) {
                System.out.println("Enter the first name to search for: ");
                input = new Scanner(System.in);
    				    String searchTerm = input.nextLine();
                tempList = db.searchStr(searchTerm, searchBy); //finds the users with search method
              } else if (searchBy == 2) {
                System.out.println("Enter the last name to search for: ");
                input = new Scanner(System.in);
    				    String searchTerm = input.nextLine();
                tempList = db.searchStr(searchTerm, searchBy); //finds the users with search method
              } else if (searchBy == 3) {
                System.out.println("Enter the major to search for: ");
                input = new Scanner(System.in);
    				    String searchTerm = input.nextLine();
                tempList = db.searchStr(searchTerm, searchBy); //finds the users with search method
              }
      				for (User user : tempList) { //iterate through arraylist
      					user.printContactInfo(); //print each users info,
      					//#NOTE: this method needs to be changed to work better with the GUI later
      					//because the method always prints to the console, it should rather return the text
      				}
            } else if (searchBy == 4) {
              if (searchBy == 4) {
                System.out.println("Enter the minimum GPA to search for: ");
                input = new Scanner(System.in);
                double searchTerm = input.nextDouble();
                tempList = db.searchNum(searchTerm, searchBy); //finds the users with search method
            }
            for (User user : tempList) { //iterate through arraylist
              user.printContactInfo(); //print each users info,
              //#NOTE: this method needs to be changed to work better with the GUI later
              //because the method always prints to the console, it should rather return the text
            }
            }



				break;

        case 7:
                System.out.println("Checking for save ...");
                if (f.exitCheck()) {
                    f.fileSave(db.getDatabase());
                } else {
                  System.out.println("Do you want to overwrite your current database? (Y/N) ");
                  input = new Scanner(System.in);
                  String overwrite = input.nextLine().toUpperCase();
                  if (overwrite.equals("Y")) {
                    f.fileSave(db.getDatabase());
                    System.exit(0);
                  } else {
                    System.exit(0);
                  }
                }

                break;

        }

}
} //end of class
