package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import users.Student;
import users.User;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.ArrayList;
import java.util.*;
import javafx.collections.ObservableList;


public class NewStudentController {

//----------------------------------------
private FileIO f = new FileIO();
private Database db = new Database(f.fileLoad()); //loads the current file each time this controller is used
//Storage locker = new Storage();
//---------------------------------------

	/**
	 * controller that controls all pages that create a new student
	 * will save info and add to database
	 */

	/**
	 * text fields that take in user input
	 * this is all the student info that we will need added to database
	 */
	@FXML
	private TextField enterFirstName;
	@FXML
	private TextField enterLastName;
	@FXML
	private TextField enterUID;
	@FXML
	private TextField enterUsername;
	@FXML
	private TextField enterPassword;
	@FXML
	private TextField confirmPassword;
	@FXML
	private Button continueNewStudent;
	@FXML
	private Button continueNewEmployer;
	@FXML
	private TextField cityName;
	@FXML
	private ComboBox<String> provinceName;
	@FXML
	private ComboBox<String> countryName;

	//continue new student
	@FXML
	private ComboBox<String> universityName;
	@FXML
	private ComboBox<String> degree;
	@FXML
	private ComboBox<String> yearOfStudy;
	@FXML
	private DatePicker dateOfBirth;
	@FXML
	private Button finishNewStudent;
	@FXML
	private RadioButton calculateGPA;
	@FXML
	private RadioButton dontCalculateGPA;
	@FXML
	private ToggleGroup gpaGroup;

	//back buttons
	@FXML
	private Button backToMenu;
	@FXML
	private Button backToNewUser;
	@FXML
	private Button backToStudent;

	@FXML
	private Stack<Scene> pages;
	@FXML
	private Button home;
	@FXML
	private Button settings;
	@FXML
	private Button search;
	@FXML
	private Button myProfile;

	//provinces and states
	@FXML
	private ObservableList<String> provinces = FXCollections.observableArrayList("Alberta", "British Columbia", "Manitoba",
			"New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut");
	@FXML
	private ObservableList<String> states = FXCollections.observableArrayList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
			"Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
			"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska" ,"Nevada" ,"New Hampshire", "New Jersey",
			"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
			"South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

	//universities that are in alberta
	@FXML
	private ObservableList<String> albertaSchools = FXCollections.observableArrayList("University of Calgary", "Mount Royal University", "SAIT", "University of Alberta", "ACAD",
			"University of Alberta", "University of Lethbridge", "MacEwan University");

	//universities in BC
	@FXML
	private ObservableList<String> bcSchools = FXCollections.observableArrayList("University of British Columbia", "University of Victoria",
			"Simon Fraser University", "Douglas College");

	//list of random universities
	@FXML
	private ObservableList<String> otherSchools = FXCollections.observableArrayList("University One", "this is a University", "University of :)", "another University");


	@FXML
	public void initialize() {
		System.out.println("student controller");
	}

	/**
	 * button to continue student creation
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void continueButtonClickedStudent(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
		//will add if statement to make sure username isn't already taken
		//will add if statements to check other fields as well
		//gets the text from user input and checks to make sure it's valid
        if (enterFirstName.getText().isEmpty() || enterLastName.getText().isEmpty() || enterUID.getText().isEmpty() || enterUsername.getText().isEmpty() ||
        		enterPassword.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please fill in all fields!");
        		alert.showAndWait();
        }
				//if the user chooses a username that is too short/long
        else if (enterUsername.getText().length() < 3 || enterUsername.getText().length() > 20) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Your username must be longer than 3 characters!");
        		alert.showAndWait();
        }
				//if the passwords do not match
				else if (!enterPassword.getText().equals(confirmPassword.getText())) {
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("Passwords do not match!");
						alert.showAndWait();
				}
				//continues onto next page
        else {

				//-------------------------------------
				Student tempStudent = new Student();
				tempStudent.setFirstName(enterFirstName.getText());
				tempStudent.setLastName(enterLastName.getText());
				tempStudent.setUID(enterUID.getText());
				(db.getDatabase()).put(tempStudent.getUID(), tempStudent);

				Storage.UID = (tempStudent.getUID());
				System.out.println("UID before:"+ Storage.UID);

				//FileIO saver = new FileIO();
				//saver.fileSave(db.getDatabase());
				f.fileSave(db.getDatabase());
				//------------------------------------------

        		Stage stage;
        		Parent root;
        		stage = (Stage) continueNewStudent.getScene().getWindow();
        		root = FXMLLoader.load(getClass().getResource("continuenewstudent.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

	}

	/*
	 * changes the province/state combobox depending on whether user chooses canada or usa
	 */
	@FXML
	public void changeCountry(ActionEvent event) throws IOException {
		if (countryName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Canada")) {
			provinceName.setItems(provinces);
		}
		if (countryName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("USA")) {
			provinceName.setItems(states);
		}
	}

	/**
	 * changes university list to match province/state chosen
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void changeProvince(ActionEvent event) throws IOException {
		if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Alberta")) {
			universityName.setItems(albertaSchools);
		}
		if (provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("British Columbia")) {
			universityName.setItems(bcSchools);
		}
		if (!provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("British Columbia") && !provinceName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Alberta")) {
			universityName.setItems(otherSchools);
		}
	}

	//finishes student creation
	@FXML
	public void finishButtonClickedStudent(ActionEvent event) throws IOException {

		Alert alert = new Alert(AlertType.ERROR);
		Alert gpa = new Alert(AlertType.INFORMATION);
				//if user user leaves fields blank
        if (cityName.getText().isEmpty() || provinceName.getSelectionModel().isEmpty() || countryName.getSelectionModel().isEmpty() ||
        		universityName.getSelectionModel().isEmpty() || degree.getSelectionModel().isEmpty() || yearOfStudy.getSelectionModel().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please fill in all fields!");
        		alert.showAndWait();
        }
        else {
//        		demoStudent.setCity(cityName.getText());
//        		demoStudent.setProvince(provinceName.getSelectionModel().getSelectedItem().toString());
//        		demoStudent.setCountry(countryName.getSelectionModel().getSelectedItem().toString());
//        		demoStudent.setUniversity(universityName.getSelectionModel().getSelectedItem().toString());
//			demoStudent.setDegree(degree.getSelectionModel().getSelectedItem().toString());
//			System.out.println(demoStudent.getCountry());
//			System.out.println(demoStudent.getProvince());
//			System.out.println(demoStudent.getUniversity());

						//if user chooses to calculate GPA
        		if (calculateGPA.isSelected()) {
							//add code for calculating GPA later
        			gpa.setTitle("Information Dialog");
        			gpa.setHeaderText("Look, an Information Dialog");
        			gpa.setContentText("GPA Calculator!");
        			gpa.showAndWait();
        		}
						//otherwise, sign up is completed
        		else {

					//saving information from the second page
					//---------------------------------------
					HashMap<String, User> data = db.getDatabase();
					//Student tempStudent = new Student(data.get(Storage.UID));
					Student tempStudent = (Student)data.get(Storage.UID); //?
					tempStudent.setCity(cityName.getText());
					tempStudent.setProvince(provinceName.getSelectionModel().getSelectedItem().toString());
					tempStudent.setCountry(countryName.getSelectionModel().getSelectedItem().toString());
					tempStudent.setUniversity(universityName.getSelectionModel().getSelectedItem().toString());
					tempStudent.setDegree(degree.getSelectionModel().getSelectedItem().toString());
					String year = (yearOfStudy.getSelectionModel().getSelectedItem().toString());
					tempStudent.setProgramYear(Integer.parseInt(year));
					//(db.getDatabase()).put(tempStudent.getUID(), tempStudent);

					//testing....
					System.out.println("The temp student's year:"+tempStudent.getProgramYear());
					System.out.println("The temp student's name:"+tempStudent.getFirstName());
					System.out.println("UID after:"+ Storage.UID);
					//tempStudent.printContactInfo(); //holy grail of tests


					//(db.getDatabase()).put(tempStudent.getUID(), tempStudent); //need to put the student back in??
					//FileIO saver = new FileIO();
					//saver.fileSave(db.getDatabase();
					f.fileSave(db.getDatabase());
					//--------------------------------------


        			Stage stage;
        			Parent root;
        			stage = (Stage) finishNewStudent.getScene().getWindow();
        			root = FXMLLoader.load(getClass().getResource("home.fxml"));

        			Scene scene = new Scene(root);
        			stage.setScene(scene);
        			stage.show();
        		}
        }

	}

	@FXML
	public void backButtonClickedNewUser(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) backToNewUser.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newuserpage.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void backButtonClicked(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) backToMenu.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void backButtonClickedStudent(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) backToStudent.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newstudent.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void changePage(ActionEvent event) throws IOException {
		//if home button clicked or if no button specified (default home)
		if (event.getTarget() == home || event.getTarget() == null) {
			Stage stage;
			Parent root;
    			stage = (Stage) home.getScene().getWindow();
    			root = FXMLLoader.load(getClass().getResource("home.fxml"));

    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
		}
		//if search button clicked
		else if (event.getTarget() == search) {
			Stage stage;
			Parent root;
			stage = (Stage) search.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("searchpage.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		//if settings button clicked
		}
		else if (event.getTarget() == settings) {
			Stage stage;
			Parent root;
			stage = (Stage) settings.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("settingspage.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		//if profile button clicked
		else if (event.getTarget() == myProfile) {
			Stage stage;
			Parent root;
			stage = (Stage) myProfile.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("profilepage.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

}
