

import java.util.*;

import application.Main;
import tests.EmployerTest;
import tests.StatisticsTest;
import tests.StudentTest;
import tests.UserTest;
import utilities.Menu;

public class Program{

    public static void main(String[] args) {
      Scanner GUIorText = new Scanner(System.in);
      System.out.println("Gui(1), Text Version (2) or Run Tests(3)");
      int choice = GUIorText.nextInt();
      String[] q = new String[1];
      switch(choice){

        case 1: while(true){
          Main.main(q);
        }

        case 2:Menu m1 = new Menu();
          while (true){
            m1.selectMenu();
          }

        case 3: UserTest ut = new UserTest();
        StudentTest st = new StudentTest();
        EmployerTest et = new EmployerTest();
        StatisticsTest stat1 = new StatisticsTest();
        System.out.println("All Tests Completed");
          
  }
}
}
