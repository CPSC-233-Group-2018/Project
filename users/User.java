package users;
import java.util.*;
import java.io.*;

public class User implements Serializable {

private String firstName = "";
private String lastName = "";
private String phoneNumber = "";
private String email = "";
private String city = "";
private String province = "";
private String country = "";
private String aboutMe = "";


//blank constructor
public User() {

}


/**A method called to set up a Users Startup info initially, not a constructor because it's only used in text version*/
public void setContactInfo(){
        Scanner input = new Scanner(System.in);
        int selection;

        System.out.println("Please enter your contact info: \n");

        System.out.println("\nPlease enter your first Name: ");
        input = new Scanner(System.in);
        this.firstName = input.nextLine();

        System.out.println("\nPlease enter your last Name: ");
        input = new Scanner(System.in);
        this.lastName = input.nextLine();

        System.out.println("\nPlease enter your Phone Number: ");
        input = new Scanner(System.in);
        this.phoneNumber = input.nextLine();

        System.out.println("\nPlease enter your Email: ");
        input = new Scanner(System.in);
        this.email = input.nextLine();

        System.out.println("\nPlease Select your City:");
        System.out.println("(1)Calgary \n(2)Edmonton \n(3)Lethbridge \n(4)Boston \n(5)Chicago \n(6)Vegas"); //List of Cities
        input = new Scanner(System.in);
        selection = input.nextInt();
        switch(selection) { //Assign a city based on User input

        case 1: this.city = "Calgary";
                break;

        case 2: this.city = "Edmonton";
                break;

        case 3: this.city = "Lethbridge";
                break;

        case 4: this.city = "Boston";
                break;

        case 5: this.city = "Chicago";
                break;

        case 6: this.city = "Vegas";
                break;


        }

        //Switch Statement to Assign Province based on City
        switch(this.city) {

        case ("Calgary"): this.province = "Alberta";
                System.out.println("\nProvince set to Alberta");
                break;

        case ("Lethbridge"): this.province = "Alberta";
                System.out.println("\nProvince set to Alberta");
                break;

        case ("Edmonton"): this.province = "Alberta";
                System.out.println("\nProvince set to Alberta");
                break;


        case ("Boston"): this.province = "Massachusetts";
                System.out.println("\nState Set to Massachusetts");
                break;

        case ("Chicago"): this.province = "Illinois";
                System.out.println("\nState Set to Illinois");
                break;

        case ("Vegas"): this.province = "Nevada";
                System.out.println("\nState Set to Nevada");
                break;


        }

        //Sets country based on Province
        switch(this.province) {

        case ("Alberta"): this.country = "Canada";
                System.out.println("\nCountry Set to Canada");
                break;

        case ("Illinios"): this.country = "USA";
                System.out.println("\nCountry Set to USA");
                break;

        case ("Nevada"): this.country = "USA";
                System.out.println("\nCountry Set to USA");
                break;

        case ("Massachusetts"): this.country = "USA";
                System.out.println("\nCountry Set to USA");
                break;

        }

}

/** A method to allow you to print all a users contact into*/
public void printContactInfo(){
        System.out.println("\nName: " + firstName + " " + lastName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Country: " + country);
        System.out.println("City: " + city);
        System.out.println("Province: " + province);
}



//All setters and Getters are below


/** Setter for FirstName*/
public void setFirstName(String newName){
        firstName = newName;
}

/** Getter for FirstName*/
public String getFirstName(){
        String printedFirstName = new String(firstName);
        return printedFirstName;
}

/** Setter for lastName*/
public void setLastName(String newName){
        lastName = newName;
}

/** Getter for lastName*/
public String getLastName(){
        String printedlastName = new String(lastName);
        return printedlastName;
}

/** Setter for PhoneNumber*/
public void setPhoneNumber(String newPhoneNumber){
        phoneNumber = newPhoneNumber;
}

/** Getter for PhoneNumber*/
public String getPhoneNumber(){
        String printedPhoneNumber = new String(phoneNumber);
        return printedPhoneNumber;
}

/** Setter for Email*/
public void setEmail(String newEmail){
        email = newEmail;
}

/** Getter for Email*/
public String getEmail(){
        String printedEmail = new String(email);
        return printedEmail;
}

/** Setter for City*/
public void setCity(String newCity){
        city = newCity;
}

/** Getter for City*/
public String getCity(){
        String printedCity = new String(city);
        return printedCity;
}

/** Setter for Province*/
public void setProvince(String newProvince){
        province = newProvince;
}

/** Getter for Province*/
public String getProvince(){
        String printedProvince = new String(province);
        return printedProvince;
}

/** Setter for Country*/
public void setCountry(String newCountry){
        country = newCountry;
}

/** Getter for Country*/
public String getCountry(){
        String printedCountry = new String(country);
        return printedCountry;
}

/** Getter for about me*/
public String getAboutMe() {
	String printedAbout = new String(aboutMe);
	return printedAbout;
}

/** Setter for about me*/
public void setAboutMe(String about) {
	aboutMe = about;
}


public Double getGPA(){   //Class will be overridden in student
        return 0.0;
}

public String getDegree(){   //Class will be overridden in student
        return "hello";
}

public String getStudentType(){   //Class will be overridden in student
        return "hello";
}

public String getUniversity(){   //Class will be overridden in student
        return "hello";
}

public String getCompanyName(){   //Class will be overridden in student
        return "hello";
}

public String getOfferingJobs(){   //Class will be overridden in student
        return "hello";
}

public String getDOB() {
        return "hello";
}

}
