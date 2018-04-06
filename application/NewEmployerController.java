package application;

import java.io.IOException;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NewEmployerController {
	
	/**
	 *controller that controls all pages that help create a new employer
	 *will save info entered by user and add it to database
	 */
	
	@FXML
	private TextField enterFirstName;
	@FXML
	private TextField enterLastName;
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
	
	@FXML
	private TextField companyName;
	@FXML
	private ComboBox<String> field;
	@FXML
	private TextField emailAddress;
	@FXML
	private TextField phoneNumber;
	@FXML
	private ComboBox<String> lookingToHire;
	@FXML
	private Button finishNewEmployer;
	
	@FXML
	private Button backToMenu;
	@FXML
	private Button backToNewUser;
	@FXML
	private Button backToEmployer;
	
	//lists for provinces and states that will change depending on country chosen
	@FXML
	private ObservableList<String> provinces = FXCollections.observableArrayList("Alberta", "British Columbia", "Manitoba", 
			"New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut");
	@FXML
	private ObservableList<String> states = FXCollections.observableArrayList("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", 
			"Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", 
			"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska" ,"Nevada" ,"New Hampshire", "New Jersey", 
			"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", 
			"South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

	
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
	
	@FXML
	public void initialize() {
		System.out.println("employer controller");
	}
	
	/**
	 * continue button clicked and continues employer user creation
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void continueButtonClickedEmployer(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
		//makes sure all text fields are filled before user can move onto next page
        if (enterFirstName.getText().isEmpty() || enterUsername.getText().isEmpty() || enterPassword.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please fill in all fields!");
        		alert.showAndWait();
        }

        //makes sure username is correct length
        else if (enterUsername.getText().length() < 3 || enterUsername.getText().length() > 20) {
    				alert.setTitle("Error");
    				alert.setHeaderText(null);
    				alert.setContentText("Your username must be between 3 and 20 characters!");
    				alert.showAndWait();
    		}		//makes sure that password fields match
				else if (!enterPassword.getText().equals(confirmPassword.getText())) {
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("Passwords do not match!");
						alert.showAndWait();
				}
        else {

        		Stage stage;
        		Parent root;
        		stage = (Stage) continueNewEmployer.getScene().getWindow();
        		root = FXMLLoader.load(getClass().getResource("continuenewemployer.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

	}
	
	//when country combobox is changed, updates province/states to correspond
	@FXML
	public void changeCountry(ActionEvent event) throws IOException {
		if (countryName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Canada")) {
			provinceName.setItems(provinces);
		}
		if (countryName.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("USA")) {
			provinceName.setItems(states);
		}
	}
	
	//finishes employer user creation
	@FXML
	public void finishButtonClickedEmployer(ActionEvent event) throws IOException {

		Alert alert = new Alert(AlertType.ERROR);
		//makes sure all fields are filled
        if (cityName.getText().isEmpty() || provinceName.getSelectionModel().isEmpty() || countryName.getSelectionModel().isEmpty() ||
        		companyName.getText().isEmpty() || field.getSelectionModel().isEmpty() || emailAddress.getText().isEmpty() ||
        		phoneNumber.getText().isEmpty() || lookingToHire.getSelectionModel().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please fill in all fields!");
        		alert.showAndWait();
        }
				//checks if email address is in valid format
				//letters/digits followed by @ followed by letters/digits followed by . followed by letters
        else if (!emailAddress.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
		      "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Invalid email address!");
        		alert.showAndWait();
        }
				//checks if phone number is in the right format
				//both 000-000-0000 and 0000000000 work
				else if (!phoneNumber.getText().matches("(\\d{3}-){1,2}\\d{4}")) { //check for phone number. \\d = only digits allowed, {3} == three characters, etc.
          		alert.setTitle("Error");
          		alert.setHeaderText(null);
          		alert.setContentText("Invalid phone number!");
          		alert.showAndWait();
          }
        else {

//        		demoEmployer.setCity(cityName.getText());
//        		demoEmployer.setProvince(provinceName.getSelectionModel().getSelectedItem().toString());
//        		demoEmployer.setCountry(countryName.getSelectionModel().getSelectedItem().toString());
//        		demoEmployer.setCompanyName(companyName.getText());
//        		demoEmployer.setEmail(emailAddress.getText());
//        		demoEmployer.setPhoneNumber(phoneNumber.getText());
//        		demoEmployer.setOfferingJobs(lookingToHire.getSelectionModel().getSelectedItem().toString());
//        		System.out.println(demoEmployer.getCountry());

        		Stage stage;
        		Parent root;
        		stage = (Stage) finishNewEmployer.getScene().getWindow();
        		root = FXMLLoader.load(getClass().getResource("homeemployer.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

	}
	
	//back button, goes back to previous page
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
	public void backButtonClickedEmployer(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) backToEmployer.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newemployer.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//back button after choosing new user
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