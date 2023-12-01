package gui;

import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.ResourceBundle;

import common.IService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import student.Student;

public class BookAppController  implements Initializable {
	String Student;
	String Mail;
	ObservableList<String> timeList = FXCollections.observableArrayList();
	 @FXML
	 private DatePicker availability_calendar;
	 @FXML
     private ComboBox<String> start;
     @FXML
     private ComboBox<String> end;
     @FXML
     private Button book_btn;
     @FXML
     private ListView<String> list_availability;
     @FXML
     private Text messsage;
     
     @Override
 	public void initialize(URL arg0, ResourceBundle arg1) {
 		// TODO Auto-generated method stub

  		start.getItems().addAll("9:00", "10:00", "11:00", "14:00", "15:00", "16:00");
  		end.getItems().addAll("10:00", "11:00", "12:00", "15:00", "16:00", "17:00");
  		
  		start.getSelectionModel().select("9:00");
  		end.getSelectionModel().select("10:00");
		// Set the items in your ListView to display the time entries
  		list_availability.setItems(timeList);
 	}

     @FXML
 	public void book(ActionEvent event) throws IOException, RemoteException, NotBoundException {
 		IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
 		LocalDate selectedDate = availability_calendar.getValue();
 		String dateString="";
        if (selectedDate != null) {
            // Convert the LocalDate to a string using DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           dateString = selectedDate.format(formatter);
            dateString=dateString+start.getValue()+" to "+end.getValue();}
        messsage.setText(tuts.bookAppointment(Mail, Student, dateString));
         
 	}
     public void setData(String Student,String Mail,ObservableList<String> timeList) {
    	 this.Student=Student;
    	 this.Mail=Mail;
    	 this.timeList=timeList;
    	 list_availability.setItems(timeList);
     }


	
}
