package application;

import java.io.IOException;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NewEmployerController {
	
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
	private ChoiceBox<String> provinceName;
	@FXML
	private ChoiceBox<String> countryName;
	
	@FXML
	private TextField companyName;
	@FXML
	private ChoiceBox<String> field;
	@FXML
	private TextField emailAddress;
	@FXML
	private TextField phoneNumber;
	@FXML
	private ChoiceBox<String> lookingToHire;
	@FXML
	private Button finishNewEmployer;
	
	@FXML
	private Button backToMenu;
	@FXML
	private Button backToNewUser;
	@FXML
	private Button backToEmployer;
	
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
	
	@FXML
	public void continueButtonClickedEmployer(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
        if (enterFirstName.getText().isEmpty() || enterUsername.getText().isEmpty() || enterPassword.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Please fill in all fields!");
        		alert.showAndWait();
        }

        else if (enterUsername.getText().length() < 3 || enterUsername.getText().length() > 20) {
    				alert.setTitle("Error");
    				alert.setHeaderText(null);
    				alert.setContentText("Your username must be between 3 and 20 characters!");
    				alert.showAndWait();
    		}
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
	
	@FXML
	public void finishButtonClickedEmployer(ActionEvent event) throws IOException {

		Alert alert = new Alert(AlertType.ERROR);
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
        		root = FXMLLoader.load(getClass().getResource("home.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

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