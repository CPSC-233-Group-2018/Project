package tests;

import users.Employer;

/**Class to test the Employer class and validate functionality*/
public class EmployerTest {

public EmployerTest() {
        test_Setter_and_Getter_Names_valid();
        test_Setter_and_Getter_Locations_valid();
        test_Setter_and_Getter_Contact_valid();



}

//Tests found Below

/** Test to ensure that the setter and geters for first and last name
   Work for valid inputs*/
public static void test_Setter_and_Getter_Names_valid(){
        Employer nametest = new Employer();
        nametest.setFirstName("John");
        nametest.setLastName("Doe");
        String fName =  nametest.getFirstName();
        String lName = nametest.getLastName();
        assert (fName.equals("John")) : ("First Name Test Failed, Was looking for John and got " + fName);
        assert (lName.equals("Doe")) :  ("Last Name Test Failed, Was looking for Doe and got " + lName);
        System.out.println("All Employer tests for first and last name passed");
}


/** Test to ensure that the setter and geters for City, Country, and province
   Work for valid inputs*/
public static void test_Setter_and_Getter_Locations_valid(){
        Employer LocationsTest = new Employer();
        LocationsTest.setCity("Calgary");
        LocationsTest.setProvince("Alberta");
        LocationsTest.setCountry("Canada");
        String lCi = LocationsTest.getCity();
        String lPr = LocationsTest.getProvince();
        String lCo = LocationsTest.getCountry();
        assert (lCi.equals("Calgary")) : "City Test Failed, Was looking for Calgary and got " + LocationsTest.getCity();
        assert (lPr.equals("Alberta")) : "Province Test Failed, Was looking for Alberta and got " + LocationsTest.getProvince();
        assert (lCo.equals("Canada")) : "Country Test Failed, Was looking for Canada and got " + LocationsTest.getCountry();

        System.out.println("All Employer tests for Locations passed");
}

/** Test to ensure that the setter and geters for email and phone number
   Work for valid inputs*/
public static void test_Setter_and_Getter_Contact_valid(){
        Employer ContactTest = new Employer();
        ContactTest.setEmail("uofc@ucalgary.ca");
        ContactTest.setPhoneNumber("(123)123-1234");
        String em = ContactTest.getEmail();
        String pn = ContactTest.getPhoneNumber();
        assert (em.equals("uofc@ucalgary.ca")) : "Email Test Failed, Was looking for uofc@ucalgary.ca and got " + ContactTest.getEmail();
        assert (pn.equals("(123)123-1234")) : "Phone Number Test Failed, Was looking for (123)123-1234 and got " + ContactTest.getPhoneNumber();
        System.out.println("All Employer tests for Contact Info passed");
}






}
