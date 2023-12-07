package gui;

import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ResourceBundle;

import javax.xml.rpc.ServiceException;

import common.IService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import student.ExternalStudent;
import student.ExternalStudentServiceLocator;
import student.ExternalStudentSoapBindingStub;

public class FeedbackController implements Initializable{
	@FXML
	Button send;
	@FXML
	Button back_btn;
	@FXML
	TextArea fdbk_text;
	@FXML
	Text message;
	String Mail="";
	String studentMail="";
	String fullName="";
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void sendFeedBack() throws NotBoundException, IOException, ServiceException {
		ExternalStudent service=new ExternalStudentServiceLocator().getExternalStudent();
   		((ExternalStudentSoapBindingStub) service).setMaintainSession(true);
		service.giveFeedback(fdbk_text.getText(), Mail);
		message.setText("FeedBack Sent");
	}
	public void sendData(String Mail,String studentMail,String fullName) {
		this.Mail=Mail;
		this.studentMail=studentMail;
		this.fullName=fullName;
	}
	 @FXML
     public void back(ActionEvent event) throws IOException, ServiceException {
         // Load the new FXML file
         FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
         Parent root = loader.load();
         studentController StudentController = loader.getController();
         StudentController.setData(studentMail,fullName);
      
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
