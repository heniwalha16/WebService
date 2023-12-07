package gui;

import java.io.IOException;
import java.net.URL;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ResourceBundle;

import javax.xml.rpc.ServiceException;

import FxtopAPI.FxtopServicesLocator;
import FxtopAPI.FxtopServicesPortType;
import bank.BankServer;
import bank.BankServerServiceLocator;
import bank.BankServerSoapBindingStub;
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import student.ExternalStudent;
import student.ExternalStudentServiceLocator;
import student.ExternalStudentSoapBindingStub;


public class BookAppController  implements Initializable {
	String Student;
	String Mail;
	String studentMail;
	String fullNameString;
	ObservableList<String> timeList = FXCollections.observableArrayList();
	 @FXML
	 private DatePicker availability_calendar;
	 @FXML
     private ComboBox<String> start;
     @FXML
     private ComboBox<String> end;
     @FXML
     private ComboBox<String> currency;
     @FXML
     private Button book_btn;
     @FXML
     private Button back_btn;
     @FXML
     private ListView<String> list_availability;
     @FXML
     Text rate;
     @FXML
     TextField rib;
     @FXML
     private Text messsage;
     double ratetut;
     
     @Override
 	public void initialize(URL arg0, ResourceBundle arg1) {
 		// TODO Auto-generated method stub

  		start.getItems().addAll("9:00", "10:00", "11:00", "14:00", "15:00", "16:00");
  		end.getItems().addAll("10:00", "11:00", "12:00", "15:00", "16:00", "17:00");
  		currency.getItems().addAll("EUR", "USD", "TND", "JPY", "CAD", "CNY");
  		start.getSelectionModel().select("9:00");
  		end.getSelectionModel().select("10:00");
  		currency.getSelectionModel().select("EUR");
  	
		// Set the items in your ListView to display the time entries
  		list_availability.setItems(timeList);
  		
 	}

     @FXML
 	public void book(ActionEvent event) throws IOException, RemoteException, NotBoundException, ServiceException {
    	 ExternalStudent service=new ExternalStudentServiceLocator().getExternalStudent();
   		((ExternalStudentSoapBindingStub) service).setMaintainSession(true);
   		BankServer Bservice=new BankServerServiceLocator().getBankServer();
		((BankServerSoapBindingStub) Bservice).setMaintainSession(true);
		FxtopServicesPortType serviceER = new FxtopServicesLocator().getFxtopServicesPort();
		
		String CurrencyChosen=currency.getValue();
		double newAmount = Double.parseDouble(serviceER.convert(Double.toString(ratetut), "EUR", CurrencyChosen, "", "", "").getExchangeRate());
		System.out.println(newAmount);
		rate.setText(Double.toString(newAmount*this.ratetut));
 		LocalDate selectedDate = availability_calendar.getValue();
 		String dateString="";
        if (selectedDate != null) {
            // Convert the LocalDate to a string using DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           dateString = selectedDate.format(formatter);
            dateString=dateString+" "+start.getValue()+" to "+end.getValue();}
        System.out.println(dateString);
        System.out.println(Mail);
        System.out.println(Mail+Student+dateString);
        String resultBank=Bservice.pay(rib.getText(), newAmount*this.ratetut);
        if (resultBank.equals("Payement Done.")) {
        messsage.setText(resultBank+" "+service.bookAppointement(Mail, this.Student, dateString));
        messsage.setStyle("-fx-fill: green;");
        }
        else {
        	messsage.setText(resultBank);
        	messsage.setStyle("-fx-fill: red;");

        }
 	}
     public void setData(String Student,String Mail,ObservableList<String> timeList,String studentMail,String fullName,double ratetut) {
    	 this.Student=Student;
    	 this.Mail=Mail;
    	 this.timeList=timeList;
    	 this.studentMail=studentMail;
    	 this.fullNameString=fullName;
    	 this.ratetut=ratetut;
    	 list_availability.setItems(timeList);
    		rate.setText(Double.toString(ratetut));
    	 currency.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
   	        // Perform your desired function here when the currency selection changes
   	        try {
   	            FxtopServicesPortType serviceER = new FxtopServicesLocator().getFxtopServicesPort();
   	            String currencyChosen = currency.getValue();
   	         System.out.println("rate:"+this.ratetut);
   	            double newAmount = Double.parseDouble(serviceER.convert(Double.toString(this.ratetut), "EUR", currencyChosen, "", "", "").getExchangeRate());
   	            System.out.println(newAmount);
   	            rate.setText(Double.toString(newAmount*this.ratetut));
   	        } catch (Exception e) {
   	            e.printStackTrace(); // Handle the exception appropriately
   	        }
   	    });
     }

     @FXML
     public void back(ActionEvent event) throws IOException, ServiceException {
         // Load the new FXML file
         FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
         Parent root = loader.load();
         studentController StudentController = loader.getController();
         StudentController.setData(studentMail,fullNameString);
      
         //Parent root = loader.load();
         // Set up the scene
         Scene scene = new Scene(root);

         // Set up the stage
         Stage stage = new Stage();
         stage.setTitle("Student JavaFX Application");
         stage.setScene(scene);

         // Close the current stage
         Stage currentStage = (Stage) back_btn.getScene().getWindow();
         currentStage.close();

         // Show the new stage
         stage.show();
     }
	
}
