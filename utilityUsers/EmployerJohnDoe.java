package utilityUsers;
import java.util.*;

import users.Employer;

import java.io.*;

public class EmployerJohnDoe extends Employer implements Serializable{


  public EmployerJohnDoe(){
    randomUser();
    setCompanyName(createRandomCompany());
  }
    /** A method to create a random Company Name*/
    public String createRandomCompany(){
      Random rand = new Random();
      String names[] = {"Driive","Google","Rosignol","Nike","Addidas","Audi","Tesla","Enmax","the futur","Coca-Cola","Mcdonalds","Taco Time","Blind Studios","Blizzard","Electronic Arts","Apple","American Eagle","Bootlegger","Walmart","Helly Hansen","University of Calgary","Bob's Burgers","Microsoft","North Face","Samsung","Sandisk","Intel","AMD","ASUS", "Gigabyte"};
      String randomCompany = (names[(rand.nextInt(29))]);
      return randomCompany;
    }


    public void print_Vars(){
      /** A method that prints a users atributes*/
      System.out.println("\nSearching database for: "+ getFirstName() + " " + getLastName());
      System.out.println("\nUser Name: "+ getFirstName() + " " + getLastName());
      System.out.println("User Company: "+ getCompanyName());
      System.out.println("Offering Jobs: "+ getOfferingJobs());
      System.out.println("Phone Numebr: "+ getPhoneNumber());
      System.out.println("Email Address: "+ getEmail());
      System.out.println("Country: " + getCountry());
      System.out.println("Province: " + getProvince());
      System.out.println("City: " + getCity());
    }


}
