package application;

import java.io.IOException;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.collections.ListChangeListener;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utilityUsers.EmployerJohnDoe;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle; 
import javafx.scene.control.ToggleButton; 
import javafx.scene.control.ToggleGroup;

public class EmployerSearchController {

	/**
	 * controller that controls the searchemployer.fxml
	 * searches for employers in created database, displays information for said employer when selected
	 * can search by first name, last name, and company
	 */
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
	

	//variables for search bar and table that displays searched employers
	@FXML
	private TextField searchBar;
	@FXML
	private TableView<EmployerJohnDoe> employerList;
	@FXML
	private TableColumn<EmployerJohnDoe, String> firstNameColumn;
	@FXML
	private TableColumn<EmployerJohnDoe, String> lastNameColumn;
	@FXML
	private TableColumn<EmployerJohnDoe, String> companyColumn;

	private ObservableList<EmployerJohnDoe> employerData = FXCollections.observableArrayList();
	private ObservableList<EmployerJohnDoe> filteredEmployers = FXCollections.observableArrayList();
	
	@FXML
	private RadioButton searchByName;
	@FXML
	private RadioButton searchByCompany;
	
	@FXML
	private ToggleGroup toggleGroup = new ToggleGroup();

	/**
	 * constructor called at beginning of class instance, currently just adding
	 * randomly generated employers to search from
	 */
	public EmployerSearchController() {
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		employerData.add(new EmployerJohnDoe());
		
		//no filters yet, all employers shown
		filteredEmployers.addAll(employerData);
		
		employerData.addListener(new ListChangeListener<EmployerJohnDoe>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends EmployerJohnDoe> change) {
                updateFilteredEmployers();
            }
        });
		
	}
	
	/**
	 * automatically called
	 * initializes the table with employer information
	 */
	@FXML
	private void initialize() {
        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<EmployerJohnDoe, String>("firstName"));
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<EmployerJohnDoe, String>("lastName"));
        companyColumn.setCellValueFactory(
                new PropertyValueFactory<EmployerJohnDoe, String>("companyName"));

        // adds filtered employers to list of employers shown on table
        employerList.setItems(filteredEmployers);

        // if search bar text field is changed, updates the employers shown
        searchBar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                updateFilteredEmployers();
            }
        });
        
        //when user clicks on an employer object, new window pops up that displays employer information
        employerList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<EmployerJohnDoe>() {
            @Override
            public void changed(ObservableValue<? extends EmployerJohnDoe> observable, EmployerJohnDoe oldValue, EmployerJohnDoe newValue){
                if(newValue!=null){
                		Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Employer Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Name: " + newValue.getFirstName() + newValue.getLastName() + '\n' + 
                    		"Company: " + newValue.getCompanyName() + '\n' + "Offering Jobs: " + newValue.getOfferingJobs() +
                    		'\n' + "Phone Number: " + newValue.getPhoneNumber() + '\n' + "Email Address: " + newValue.getEmail() +
                    		'\n' + "Country: " + newValue.getCountry() + '\n' + "Province: " + newValue.getProvince() + '\n' +
                    		"City: " + newValue.getCity());

                    alert.showAndWait();
                }

            }
        });
	}
	
	/**
	 * updates filtered employers, if search bar text matches employer information
	 * then table changes
	 */
	private void updateFilteredEmployers() {
        filteredEmployers.clear();

        for (EmployerJohnDoe e : employerData) {
            if (matchesSearch(e)) {
                filteredEmployers.add(e);
            }
        }

        // must re-sort table after items changed
        reapplyTableSortOrder();
    }
	
	/**
	 * looks to see if search bar texts matches any emplyoer info
	 * @param employer
	 * @return
	 */
	private boolean matchesSearch(EmployerJohnDoe employer) {
        String filterSearch = searchBar.getText();
        if (filterSearch == null || filterSearch.isEmpty()) {
            // if there is nothing in the search bar, display all employers
            return true;
        }

        String lowerCaseFilterSearch = filterSearch.toLowerCase();
        //makes radio buttons apart of same group so only one can be selected at a time
        searchByName.setToggleGroup(toggleGroup);
        searchByCompany.setToggleGroup(toggleGroup);
        
        //if search by name is selected, then will only display names that match with search text
        if (searchByName.isSelected()) {
        		if (employer.getFirstName().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
                return true;
            } 
        		else if (employer.getLastName().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
                    return true;
                }
        }
        //same thing for company name 
        if (searchByCompany.isSelected()) {
        		if (employer.getCompanyName().toLowerCase().indexOf(lowerCaseFilterSearch) != -1) {
        			return true;
        		}
        }

        return false; //does not match
    }

	/**
	 * clears the table and reupdates it 
	 */
    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<EmployerJohnDoe, ?>> sortOrder = new ArrayList<>(employerList.getSortOrder());
        employerList.getSortOrder().clear();
        employerList.getSortOrder().addAll(sortOrder);
    }


    /**
     * changes pages
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
