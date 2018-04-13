

import java.util.*;

import application.Main;
import tests.EmployerTest;
import tests.StatisticsTest;
import tests.StudentTest;
import tests.UserTest;
import utilities.Menu;

/**Class that facilitates the choice of which version of the program you want to run*/
public class Program {

/**Lets you choose which you want to run; the gui version, the text version, or the tests*/
public static void main(String[] args) {
        Scanner GUIorText = new Scanner(System.in);
        System.out.println("Gui(1), Text Version (2) or Run Tests(3)");
        int choice = GUIorText.nextInt();
        String[] q = new String[1];
        switch(choice) {

        case 1: while(true) {
                        Main.main(q);
        }

        case 2: Menu m1 = new Menu();
                while (true) {
                        m1.selectMenu();
                }

        case 3: UserTest ut = new UserTest();
                System.out.println("\nAll User Tests Completed \n\n");
                StudentTest st = new StudentTest();
                System.out.println("\nAll Student Tests Completed \n\n");
                EmployerTest et = new EmployerTest();
                System.out.println("\nAll Employer Tests Completed \n\n");
                StatisticsTest stat1 = new StatisticsTest();
                System.out.println("\nAll Statistics Tests Completed \n\n");
                System.out.println("\nAll Tests Completed");

        }
}
}
