package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import users.Employer;
import users.Student;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Stack;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;


public class Controller {

	/**
	 * main controller as of now
	 * almost done splitting it all up into separate smaller controller classes
	 */
	Student demoStudent = new Student();
	Employer demoEmployer = new Employer();


	@FXML
	private AnchorPane root;

	/**
	 * buttons used in controller
	 */
	@FXML
	private Button newUser;
	@FXML
	private Button returningUser;

	//new user page
	@FXML
	private Button newStudent;

	//new employer page
	@FXML
	private Button newEmployer;


	//back buttons
	@FXML
	private Button backToMenu;
	@FXML
	private Button backToNewUser;
	@FXML
	private Button backToStudent;
	@FXML
	private Button backToEmployer;

	//returning user page
	@FXML
	private Button signIn;
	@FXML
	private TextField username;
	@FXML
	private TextField password;

	//in app home, settings, search, and profile page
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
	

	private Main mainApp;
	
	@FXML
	private Boolean isStudent = true;
	

	/**
	 * initialize method, automatically called after all FXML methods have finished running
	 */
    public void initialize() {
        System.out.println("end controller");
    }

    /**
     * contructor method automatically called at the beginning
     */
	public Controller() {
		System.out.println("new controller");
	}

	public void setMain(Main mainApp) {
		this.mainApp = mainApp;
	}


	/**
	 * method that takes user to new user page when "new user" button is clicked
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void newUserClicked(ActionEvent event) throws IOException {
		//sets new stage for the new page
		Stage stage;
		Parent root;
		stage = (Stage) newUser.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newuserpage.fxml")); //new page

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * method that takes user to returning user page
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void returningUserClicked(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) returningUser.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("returninguserpage.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * creates a new student user
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void newStudentClicked(ActionEvent event) throws IOException {
		isStudent = true;
		Stage stage;
		Parent root;
		stage = (Stage) newStudent.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("newstudent.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * creates a new employer user
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void newEmployerClicked(ActionEvent event) throws IOException {
		isStudent = false;
		Stage stage;
		Parent root;
		stage = (Stage) newEmployer.getScene().getWindow();
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


	//sign in button for returning user, brings you into app
	@FXML
	public void signInButtonClicked(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.ERROR);
		//alert popup box		
        if(username.getText().isEmpty() || password.getText().isEmpty()) { //if username and password fields are empty
        		alert.setTitle("Error");
        		alert.setHeaderText(null);
        		alert.setContentText("Incorrect username and/or password!");
        		alert.showAndWait();
        }
        else {
        		Stage stage;
        		Parent root;
        		stage = (Stage) signIn.getScene().getWindow();
        		root = FXMLLoader.load(getClass().getResource("home.fxml"));

        		Scene scene = new Scene(root);
        		stage.setScene(scene);
        		stage.show();
        }

	}

	/**
	 * changes the page in app
	 * @param event
	 * @throws IOException
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
