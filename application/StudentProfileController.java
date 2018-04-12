package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import users.Student;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;
import utilityUsers.JohnDoe;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Pos;

import java.util.Optional;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class StudentProfileController {

	/**
	 * controller for the student profile page profilepage.fxml
	 * takes user info from database and displays it here
	 */
	@FXML
	private Label studentName;
	@FXML
	private Label studentUsername;
	@FXML
	private Label studentPassword;
	@FXML
	private Label studentCity;
	@FXML
	private Label studentProvince;
	@FXML
	private Label studentCountry;
	@FXML
	private Label studentUni;
	@FXML
	private Label studentDegree;
	@FXML
	private Label studentYear;
	@FXML
	private Label studentDOB;
	@FXML
	private Label studentID;
	@FXML
	private Label studentEmail;
	@FXML
	private Label studentNumber;
	@FXML
	private Label studentType;


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

	//edits about me 
	@FXML
	private Label aboutMe;
	@FXML
	private Button editAboutMe;


	//loading the file, and grabbing the current student out of it to use
	private FileIO f = new FileIO();
	private Database db = new Database(f.fileLoad());
	//HashMap<String, User> data = db.getDatabase();
	Student tempStudent = (Student)((db.getDatabase()).get(Storage.UID)); //retrieve the student from the hashmap within the database class while casting it
	

	/*
	 * initializes labels with student information from database
	 * called at the beginning of each instance of controller
	 */
	@FXML
	public void initialize() {
		studentName.setText(tempStudent.getFirstName() + " " + tempStudent.getLastName());
		studentCity.setText(tempStudent.getCity() + ", " + tempStudent.getProvince());
		studentCountry.setText(tempStudent.getCountry());
		studentUni.setText(tempStudent.getUniversity());
		studentDegree.setText(tempStudent.getDegree());
		studentID.setText(tempStudent.getUID());
		studentNumber.setText(tempStudent.getPhoneNumber());
		studentEmail.setText(tempStudent.getEmail());
		studentType.setText(tempStudent.getStudentType());
	}
	
	/*
	 * edit the about me label
	 * saves to database
	 */
	public void editAbout(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit About Me");
		dialog.setContentText("About Me:");
		dialog.getEditor().setPrefSize(300, 200);
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		aboutMe.setText(text.get());
	}


	/*
	 * changes pages in main application
	 */
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
