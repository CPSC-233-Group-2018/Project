package utilities;
import java.util.*;

import users.User;
import utilityUsers.EmployerJohnDoe;
import utilityUsers.JohnDoe;

import java.io.*;

@SuppressWarnings("unchecked")    //temporary use for compiling
/**class that holds all the database specific methods and initialization*/
public class Database implements Serializable{

  public HashMap<String, User> database = new HashMap<String, User>();
  public String randomEmployerCount;
  public FileIO f = new FileIO();

  public Database() {

  }
  public Database(HashMap<String, User> db) {
    database = db;
  }
/** A method to create Random Students, and add them to the database*/
  public void createRandomStudents() {
  Scanner continuetoSearch = new Scanner(System.in); /*scaner that takes input as to whether
  or not you want to continue searching */

  int JohnDoeS = howManyRandos();
  for(int i=0; i<JohnDoeS; i++){
    JohnDoe temp = new JohnDoe();
    database.put(temp.getUID(), temp);
  }
}

/** A method to create Random Employers, and add them to the database*/
  public int createRandomEmployers(int count) {
  Scanner continuetoSearch = new Scanner(System.in); /*scaner that takes input as to whether
  or not you want to continue searching */

  int EmployerJohnDoeS = howManyRandos();
  for(int i=0; i<EmployerJohnDoeS; i++){
    randomEmployerCount = Integer.toString(count);
    EmployerJohnDoe temp = new EmployerJohnDoe();
    database.put(randomEmployerCount, temp);
    count += 1;
  }
  return count;
}

/** A method that takes user input and returns a string to be used to search
the database for the corresponding user */
public void searchUser(){
  System.out.println(database);
  Scanner searchUID = new Scanner(System.in);

  System.out.println("\nPlease enter the UID of the user you would like to find: ");
  String searchedUser = searchUID.nextLine();
  System.out.println("\nDatabase Returned: ");
  database.get(searchedUser).printContactInfo();

}


/** Creates a new random User from class JohnDoe*/
public JohnDoe newJohnDoe(){
  JohnDoe JoDo = new JohnDoe();
  return JoDo;
  }

  /** A method that returns user input as an int,
  used to select amount of random users to create*/
public int howManyRandos(){
  Scanner randos = new Scanner(System.in);
  System.out.println("\nHow Many randos?: ");
  return randos.nextInt();
  }

  public HashMap<String, User> getDatabase() {
    return database;
  }


//-------------------------------------------------------
/**
* TEST VERSION: searches the database for a certainn trait of the user and returns them
* @param name 				search criteria
* @return ArrayList<User> 	list of users found to match the search criteria
*/
public ArrayList<User> searchStr(String searchTerm, int searchBy) {
	ArrayList<User> nameList = new ArrayList<User>(); //make an arrayList to return

	//Iterate through database and get an arraylist of the keys with the right name
	for (String key : database.keySet()) {
		User tempUser = database.get(key); //just a temporary user to do checks with
    if (searchBy == 1) {
      if (tempUser.getFirstName().equals(searchTerm)) { //if the name matches the search criteria...
  			//System.out.println("Found: "+tempUser.getFirstName());
  			nameList.add(tempUser);
      }
		} else if (searchBy == 2) {
      if (tempUser.getLastName().equals(searchTerm)) { //if the name matches the search criteria...
  			//System.out.println("Found: "+tempUser.getLastName());
  			nameList.add(tempUser);
      }
    } else if (searchBy == 3) {
      if (tempUser.getDegree().equals(searchTerm)) { //if the name matches the search criteria...
  			System.out.println("Found: "+tempUser.getFirstName());
  			nameList.add(tempUser);
      }
    }
	}
	return nameList;
} //end of method

  public ArrayList<User> searchNum(double searchTerm, int searchBy) {
    ArrayList<User> nameList = new ArrayList<User>();
    for (String key : database.keySet()) {
  		User tempUser = database.get(key); //just a temporary user to do checks with
      if (searchBy == 4) {
        if (tempUser.getGPA() >= searchTerm) { //if the name matches the search criteria...
    			//System.out.println("Found: "+tempUser.getFirstName());
    			nameList.add(tempUser);
        }
      }
    }
    return nameList;
  }

  // public HashMap<String, String> returnAllNames(){
  //   HashMap<String, String> names = new HashMap();
  //   for (String key : database.keySet()) {
  //     User tempUser = database.get(key); //just a temporary user to do checks with
  //     names.put(tempUser.getFirstName(), tempUser.getLastName());
  //   }
  //   return names;
  // }


//---------------------------------------------------
//Test suite for Database
// public static void main(String[] args) {
//   test_setter_getter();
// }
//
// public static void test_setter_getter() {
//   Database testDB = new Database();
//   testDB.database.put("12345678", new Student());
//
//   boolean result = ((testDB.getDatabase()).get("12345678")) instanceof Student;
//   assertEquals("Inserted one student into database hashmap and returned",true,result);

// }


} //end of class
