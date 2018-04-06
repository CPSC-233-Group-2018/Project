package tests;

import users.Student;

public class StudentTest{

public StudentTest() {
  test_Setter_and_Getter_Names_valid();
  test_Setter_and_Getter_Locations_valid();
  test_Setter_and_Getter_Contact_valid();
  test_Setter_and_Getter_GPA_valid();
  test_Setter_and_Getter_degree_valid();


}

//Tests found Below

/** Test to ensure that the setter and geters for first and last name
Work for valid inputs*/
public static void test_Setter_and_Getter_Names_valid(){
    Student nametest = new Student();
    nametest.setFirstName("John");
    nametest.setLastName("Doe");
    String fName =  nametest.getFirstName();
    String lName = nametest.getLastName();
    assert(fName.equals("John")): ("First Name Test Failed, Was looking for John and got " + fName);
    assert(lName.equals("Doe")):  ("Last Name Test Failed, Was looking for Doe and got " + lName);
    System.out.println("All Student tests for first and last name passed");
}


/** Test to ensure that the setter and geters for City, Country, and province
Work for valid inputs*/
public static void test_Setter_and_Getter_Locations_valid(){
    Student LocationsTest = new Student();
    LocationsTest.setCity("Calgary");
    LocationsTest.setProvince("Alberta");
    LocationsTest.setCountry("Canada");
    String lCi = LocationsTest.getCity();
    String lPr = LocationsTest.getProvince();
    String lCo = LocationsTest.getCountry();
    assert(lCi.equals("Calgary")): "City Test Failed, Was looking for Calgary and got " + LocationsTest.getCity();
    assert(lPr.equals("Alberta")): "Province Test Failed, Was looking for Alberta and got " + LocationsTest.getProvince();
    assert(lCo.equals("Canada")): "Country Test Failed, Was looking for Canada and got " + LocationsTest.getCountry();

    System.out.println("All Student tests for Locations passed");
}

/** Test to ensure that the setter and geters for email and phone number
Work for valid inputs*/
public static void test_Setter_and_Getter_Contact_valid(){
    Student ContactTest = new Student();
    ContactTest.setEmail("uofc@ucalgary.ca");
    ContactTest.setPhoneNumber("(123)123-1234");
    String em = ContactTest.getEmail();
    String pn = ContactTest.getPhoneNumber();
    assert(em.equals("uofc@ucalgary.ca")): "Email Test Failed, Was looking for uofc@ucalgary.ca and got " + ContactTest.getEmail();
    assert(pn.equals("(123)123-1234")): "Phone Number Test Failed, Was looking for (123)123-1234 and got " + ContactTest.getPhoneNumber();
    System.out.println("All Student tests for Contact Info passed");
}

/** Test to ensure that the setter and geters for GPA
Work for valid inputs*/
public static void test_Setter_and_Getter_GPA_valid(){
    Student GPATest = new Student();
    GPATest.setGPA(3.6);
    double one = GPATest.getGPA();
    assert(one == 3.6): "GPA Test Failed was looking for 3.6 and got " + GPATest.getGPA();
    GPATest.setGPA(2.9);
    double two = GPATest.getGPA();
    assert(two == 2.9): "GPA Test Failed was looking for 2.9 and got " + GPATest.getGPA();

    System.out.println("All Student tests for GPA passed");
}

/** Test to ensure that the setter and geters for University and degree
Work for valid inputs*/
public static void test_Setter_and_Getter_degree_valid(){
    Student degreeTest = new Student();
    degreeTest.setDegree("BIO");
    String one = degreeTest.getDegree();
    assert(one.equals("BIO")): "degree Test Failed was looking for BIO and got " + degreeTest.getDegree();
    degreeTest.setDegree("ENG");
    String two = degreeTest.getDegree();
    assert(two.equals("ENG")): "degree Test Failed was looking for ENG and got " + degreeTest.getDegree();

    System.out.println("All Student tests for degree passed");
}


}
