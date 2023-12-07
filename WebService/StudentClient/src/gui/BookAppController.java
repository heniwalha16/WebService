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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import student.Student;
import student.StudentService;

public class BookAppController  implements Initializable {
	String Student;
	String Mail;
	String studentMail;
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
     private Button back_btn;
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
            dateString=dateString+" "+start.getValue()+" to "+end.getValue();}
        System.out.println(dateString);
        System.out.println(Mail);
        //System.out.println(tuts.bookAppointment("alice.smith@univ-eiffel.fr", "hiha3", "2023-12-01 9:00 to 10:00"));
        //System.out.println(tuts.bookAppointment(Mail, this.Student, dateString));
        System.out.println(Mail+Student+dateString);
        messsage.setText(tuts.bookAppointment(Mail, this.Student, dateString));
         
 	}
     public void setData(String Student,String Mail,ObservableList<String> timeList,String studentMail) {
    	 this.Student=Student;
    	 this.Mail=Mail;
    	 this.timeList=timeList;
    	 this.studentMail=studentMail;
    	 list_availability.setItems(timeList);
     }

     @FXML
     public void back(ActionEvent event) throws IOException {
    	 StudentService sts = new StudentService();
         // Load the new FXML file
         FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
         Parent root = loader.load();
         studentController StudentController = loader.getController();
         StudentController.setData(studentMail,sts.retrieveElementt(studentMail).getFullName());
      
         //Parent root = loader.load();
         // Set up the scene
         Scene scene = new Scene(root);

         // Set up the stage
         Stage stage = new Stage();
         stage.setTitle("Login JavaFX Application");
         stage.setScene(scene);

         // Close the current stage
         Stage currentStage = (Stage) back_btn.getScene().getWindow();
         currentStage.close();

         // Show the new stage
         stage.show();
     }
	
}
