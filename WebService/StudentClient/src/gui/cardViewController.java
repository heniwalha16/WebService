package gui;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import common.ITutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import student.StudentService;

public class cardViewController implements Initializable{
	@FXML
    private Text mail;
	@FXML
	Button Button_bookApp;
	@FXML
    private Text full_name_txt;
	@FXML
	private ListView<String> List_skills;
	@FXML
	private ListView<String> List_availability;
	@FXML
    private ProgressBar rating_bar;
	@FXML
	Button gfdbk;
	String Mail="";
	String fullName="";
	ITutor t;
	ObservableList<String> timeList = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
	
	public void setData(ITutor t,String Mail,String fullName) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("retrieved cardview:"+Mail);
        System.out.println("retrieved cardview::"+fullName);
		this.t=t;
		this.Mail=Mail;
		this.fullName=fullName;
		 System.out.println("Setted cardview:"+this.Mail);
         System.out.println("Setted cardview :"+fullName);
		full_name_txt.setText(t.getFirstname() + " " + t.getLastname());
		mail.setText(t.getMail());
		// Assuming List_skills is a ListView<String>
		List<String> skillsList = t.getSkills(); 
		ObservableList<String> skillsObservableList = FXCollections.observableArrayList(skillsList);
		List_skills.setItems(skillsObservableList);
		
		
		
		ObservableList<Map.Entry<String, String>> data = FXCollections.observableArrayList(t.getEmptyAvailability().entrySet());
		// Extract the time entries from your data and add them to the ListView
		for (Map.Entry<String, String> entry : data) {
		    timeList.add(entry.getKey());
		}
		// Set the items in your ListView to display the time entries
		List_availability.setItems(timeList);



	  
       double min = 0;
       double max = 5;
       double normalizedValue = (t.getRating() - min) / (max - min);
       rating_bar.setProgress(normalizedValue);

	}
	
	@FXML
    public void passToBook(ActionEvent event) {
        try {
        	StudentService sts = new StudentService();
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BookApp.fxml"));
            Parent root = loader.load();
            BookAppController BookappController = loader.getController();
           
            System.out.println("Pass to book "+Mail);
            System.out.println("Pass to book "+sts.retrieveElementt(Mail).getFullName());
            System.out.println("Pass to book "+sts.retrieveElementt(Mail).getMail());
            String studentName=sts.retrieveElementt(Mail).getFullName()+'<'+sts.retrieveElementt(Mail).getMail()+'>';
            System.out.println("Pass to book "+studentName);
            BookappController.setData(studentName,t.getMail(),timeList,Mail);
            // Set up the scene
            
            Scene scene = new Scene(root);

            // Set up the stage
            Stage stage = new Stage();
            stage.setTitle("Book Appointement");
            stage.setScene(scene);
            
            // Close the current stage
            Stage currentStage = (Stage) Button_bookApp.getScene().getWindow();
            currentStage.close();

            // Show the new stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
	@FXML
    public void passToFeedback(ActionEvent event) {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("feedback.fxml"));
            Parent root = loader.load();
            FeedbackController feedbackC=loader.getController();
            feedbackC.sendData(t.getMail(),Mail);
            // Set up the scene
            Scene scene = new Scene(root);

            // Set up the stage
            Stage stage = new Stage();
            stage.setTitle("Feedback Management");
            stage.setScene(scene);

            // Close the current stage
            Stage currentStage = (Stage) gfdbk.getScene().getWindow();
            currentStage.close();

            // Show the new stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
