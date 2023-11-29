package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import common.IService;
import common.ITutor;

public class tutorController implements Initializable {
	String mail="";

	@FXML
    private Text tutorText;
	@FXML
    private Button addava;
	

    @FXML
    private DatePicker availability_calendar;

    @FXML
    private ComboBox<String> start;

    @FXML
    private ComboBox<String> end;

    @FXML
    private TableView<Map.Entry<String, String>> table_availability;

    @FXML
    private TableColumn<Map.Entry<String, String>, String> timeColumn;

    @FXML
    private TableColumn<Map.Entry<String, String>, String> studentColumn;

    @FXML
    private TextField skill;

    @FXML
    private Button button_add_skill;

    @FXML
    private ListView<String> list_skills;

    @FXML
    private ListView<String> waiting_list;

    @FXML
    private ProgressBar rate_bar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// Assuming start and end are ComboBox<String>
		start.getItems().addAll("9:00", "10:00", "11:00", "14:00", "15:00", "16:00");
		end.getItems().addAll("10:00", "11:00", "12:00", "15:00", "16:00", "17:00");
		
		// Set default values
		start.setValue("9:00");
		end.setValue("10:00");
		start.getSelectionModel().select("9:00");
		end.getSelectionModel().select("10:00");

	}
	public void setData(ITutor t) throws RemoteException {
		// TODO Auto-generated method stub
		
		this.mail=t.getMail();
		// Assuming list_skills is a ListView<String>
		List<String> skillsList = t.getSkills(); // Assuming getSkills() returns an ArrayList<String>

		// Convert the ArrayList to an ObservableList
		ObservableList<String> skillsObservableList = FXCollections.observableArrayList(skillsList);

		// Set the ObservableList as the items for the ListView
		list_skills.setItems(skillsObservableList);
		// Assuming list_skills is a ListView<String>
		List<String> waitinglist = t.getWaitingList(); // Assuming getSkills() returns an ArrayList<String>

		// Convert the ArrayList to an ObservableList
		ObservableList<String> waitingObservableList = FXCollections.observableArrayList(waitinglist);


	     waiting_list.setItems(waitingObservableList);
	  // Convert the HashMap entries to an ObservableList
	     ObservableList<Map.Entry<String, String>> data = FXCollections.observableArrayList(t.getAvailability().entrySet());

		  table_availability.setItems(data);

	  // Configure the columns to display the data
	  timeColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getKey()));
	  studentColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));
	  // Set the data to the TableView

      // Assuming your scale is from 0 to 5
      double min = 0;
      double max = 5;

      // Normalize the value to fit within [0, 1]
      double normalizedValue = (t.getRating() - min) / (max - min);

      // Set the progress of the ProgressBar
      rate_bar.setProgress(normalizedValue);

	}
	@FXML
	public void addAv(ActionEvent event) throws IOException, RemoteException, NotBoundException {
		IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
        LocalDate selectedDate = availability_calendar.getValue();

        if (selectedDate != null) {
            // Convert the LocalDate to a string using DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateString = selectedDate.format(formatter);
            dateString=dateString+start.getValue()+" to "+end.getValue();
		tuts.retrieveElement(mail).addAvailability(dateString);
		List<String> waitinglist = tuts.retrieveElement(mail).getWaitingList(); // Assuming getSkills() returns an ArrayList<String>
		 ObservableList<Map.Entry<String, String>> data = FXCollections.observableArrayList(tuts.retrieveElement(mail).getAvailability().entrySet());

		  table_availability.setItems(data);

	  // Configure the columns to display the data
	  timeColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getKey()));
	  studentColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));

		// Convert the ArrayList to an ObservableList
		ObservableList<String> waitingObservableList = FXCollections.observableArrayList(waitinglist);


	     waiting_list.setItems(waitingObservableList);
		Naming.rebind("TutorService", tuts);}
	}
	@FXML
	public void addSk(ActionEvent event) throws IOException, RemoteException, NotBoundException {
		IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
        if (skill.getText() != null) {
        List<String> new_l=tuts.retrieveElement(mail).getSkills();
        new_l.add(skill.getText());
		tuts.retrieveElement(mail).setSkills(new_l);

		List<String> skillsList = tuts.retrieveElement(mail).getSkills(); // Assuming getSkills() returns an ArrayList<String>

		// Convert the ArrayList to an ObservableList
		ObservableList<String> skillsObservableList = FXCollections.observableArrayList(skillsList);

		// Set the ObservableList as the items for the ListView
		list_skills.setItems(skillsObservableList);
		Naming.rebind("TutorService", tuts);}
	}
}