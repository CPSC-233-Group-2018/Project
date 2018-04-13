package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.geometry.Pos;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.TextAlignment;

import java.util.Optional;
import users.Employer;
import users.User;
import utilities.Database;
import utilities.FileIO;
import utilities.Storage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class EmployerProfileController {

	/**
	 * controller that controls the profileemployer.fxml page
	 * will access the database and display user information on this page
	 *
	 */

	//labels that will take info from database and display it on page

	@FXML
	private Label employerName;
	@FXML
	private Label employerUsername;
	@FXML
	private Label employerPassword;
	@FXML
	private Label employerCity;
	@FXML
	private Label employerProvince;
	@FXML
	private Label employerCountry;
	@FXML
	private Label employerCompany;
	@FXML
	private Label employerField;
	@FXML
	private Label employerHiring;
	@FXML
	private Label employerEmail;
	@FXML
	private Label employerNumber;

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

	//edit about me 
	@FXML
	private Label aboutMe;
	@FXML
	private Button editAboutMe;

	//loading the file, and grabbing the current employer out of it to use
	private FileIO f = new FileIO();
	private Database db = new Database(f.fileLoad());
	private Employer tempEmployer = (Employer)((db.getDatabase()).get(Storage.employerName)); 	//retrieve the student from the hashmap within the



	/**
	 * sets the label text to user info
	 */
	@FXML
	public void initialize() {
		employerName.setText(tempEmployer.getFirstName() + " " + tempEmployer.getLastName());
		employerCity.setText(tempEmployer.getCity());
		employerCountry.setText(tempEmployer.getCountry());
		employerCompany.setText(tempEmployer.getCompanyName());
		employerEmail.setText(tempEmployer.getEmail());
		employerNumber.setText(tempEmployer.getPhoneNumber());
		employerHiring.setText(tempEmployer.getOfferingJobs());
		aboutMe.setText(tempEmployer.getAboutMe());
	}

	/*
	 * edits about me
	 * opens new window and gets user input, saves to database
	 */
	public void editAbout(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Edit About Me");
		dialog.setContentText("About Me:");
		dialog.getEditor().setPrefSize(300, 200);
		dialog.getEditor().setAlignment(Pos.TOP_LEFT);
		Optional<String> text = dialog.showAndWait();
		aboutMe.setText(text.get());
		tempEmployer.setAboutMe(text.get());
		
		f.fileSave(db.getDatabase());
	}

	/**
	 * changes page in application
	 * @param event
	 * @throws IOException
	 */
	public void changePage(ActionEvent event) throws IOException {
		//if home button clicked or if no button specified (default home)
		if (event.getTarget() == home || event.getTarget() == null) {
			Stage stage;
			Parent root;
    			stage = (Stage) home.getScene().getWindow();
    			root = FXMLLoader.load(getClass().getResource("homeemployer.fxml"));

    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
		}
		//if search button clicked
		else if (event.getTarget() == search) {
			Stage stage;
			Parent root;
			stage = (Stage) search.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("searchemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		//if settings button clicked
		}
		else if (event.getTarget() == settings) {
			Stage stage;
			Parent root;
			stage = (Stage) settings.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("settingsemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		//if profile button clicked
		else if (event.getTarget() == myProfile) {
			Stage stage;
			Parent root;
			stage = (Stage) myProfile.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("profileemployer.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}


}
