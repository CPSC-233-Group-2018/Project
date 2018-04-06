package users;
import java.util.Scanner;
import java.io.*;
/*
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
*/
public class Employer extends User implements Serializable{

  private String companyName = "Google";
  private String offeringJobs = "Yes";/*
  private final StringProperty companyNameGUI;
  private final StringProperty offeringJobsGUI;
  */
  /*
  public Employer(String firstName, String lastName) {
	  super(firstName, lastName);
	  this.companyNameGUI = new SimpleStringProperty("Google");
	  this.offeringJobsGUI = new SimpleStringProperty("Yes");
  }

  public Employer() {
	  this(null, null);
  }
  */
  
  public Employer() {
	  
  }
  
  public void setEmployerAttributes() {
    Scanner input1 = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
    Scanner input4 = new Scanner(System.in);
    setContactInfo();   //calls the super class's method to set common traits of a user
    System.out.println("\nWhat is your company name: ");
    companyName = input2.nextLine();

    System.out.println("Is your company currently looking to hire?: ('Yes' or 'No')");
    offeringJobs = input1.nextLine();

    }

    @Override
    public void printContactInfo(){
      /** A method that prints a users atributes*/

      super.printContactInfo();
      //System.out.println("\nSearching database for: "+ getFirstName() + " " + getLastName());
      //System.out.println("\nUser Name: "+ getFirstName() + " " + getLastName());
      System.out.println("User Company: "+ getCompanyName());
      System.out.println("Offering Jobs: "+ getOfferingJobs());
      //System.out.println("Phone Numebr: "+ getPhoneNumber());
      //System.out.println("Email Address: "+ getEmail());
      //System.out.println("Country: " + getCountry());
      //System.out.println("Province: " + getProvince());
      //System.out.println("City: " + getCity());
    }

    /** getter for offeringJobs*/
    public String getOfferingJobs(){
      String printedOfferingJobs = new String(offeringJobs);
      return printedOfferingJobs;
    }

    /** getter for CompanyName*/
    public String getCompanyName(){
      String printedCompanyName = new String(companyName);
      return printedCompanyName;
    }

    public void setOfferingJobs(String newOfferingJobs){
      offeringJobs = newOfferingJobs;

    }


    public void setCompanyName(String newCompanyName){
      companyName = newCompanyName;
    }
    /*
    public StringProperty companyNameProperty() {
    	return companyNameGUI;
    }

    public StringProperty offeringJobsProperty() {
    	return offeringJobsGUI;
    }
    */

}
