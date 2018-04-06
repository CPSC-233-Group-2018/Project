package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main extends Application { //main class

	private Stage stage;
	private AnchorPane mainPage;
	private Scene mainScene;

	/**
	 * start method that loads primary stage, sets the scene
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;

		FXMLLoader loader = new FXMLLoader();

		mainPage = loader.load(getClass().getResource("mainpage.fxml")); //connects to mainpage.fxml
		mainScene = new Scene(mainPage, 375, 559);

		Controller controller = loader.getController(); //main controller

        primaryStage.setTitle("Foli-U"); //title of stage
        primaryStage.setScene(mainScene);
        primaryStage.show(); //displays stage/app
	}

	/**
	 * returns primary stage
	 * @return
	 */
	public Stage getPrimaryStage() {
		return stage;
	}

	public Main() {
	}

	/**
	 * main method, launches GUI
	 * @param args
	 */
	public static void main(String[] args) { 
		launch(args);
	}
}
