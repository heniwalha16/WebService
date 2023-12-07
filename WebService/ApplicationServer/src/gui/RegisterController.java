package gui;

import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import common.IService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class RegisterController implements Initializable {
	@FXML
	Button registerbtn;
	@FXML
	Button passtologin;
	@FXML
	TextField mail;
	@FXML
	PasswordField pwd;
	@FXML
	TextField lastname;
	@FXML
	TextField firstname;
	@FXML
	Text message;
	String Mail="";
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
    private void Register(ActionEvent event)throws IOException, RemoteException,NotBoundException  {
		IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
		String result=tuts.register(mail.getText(), pwd.getText(), firstname.getText(), lastname.getText());
		if(result.equals("This account is already existed"))
		{
		message.setText(tuts.register(mail.getText(), pwd.getText(), firstname.getText(), lastname.getText()));}
		else {
		Mail=mail.getText();
		
		Naming.rebind("TutorService", tuts);
		
		try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tutor.fxml"));
            Parent root = loader.load();
            tutorController tutorController = loader.getController();
            tutorController.setData(tuts.retrieveElement(Mail));
            // Set up the scene
            Scene scene = new Scene(root);

            // Set up the stage
            Stage stage = new Stage();
            stage.setTitle("Tutor JavaFX Application");
            stage.setScene(scene);

            // Close the current stage
            Stage currentStage = (Stage) registerbtn.getScene().getWindow();
            currentStage.close();

            // Show the new stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
		}
	}
	 @FXML
	    private void passToLogin(ActionEvent event) {
	        try {
	            // Load the new FXML file
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
	            Parent root = loader.load();
	            
	            // Set up the scene
	            Scene scene = new Scene(root);

	            // Set up the stage
	            Stage stage = new Stage();
	            stage.setTitle("Login JavaFX Application");
	            stage.setScene(scene);

	            // Close the current stage
	            Stage currentStage = (Stage) passtologin.getScene().getWindow();
	            currentStage.close();

	            // Show the new stage
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace(); // Handle the exception appropriately
	        }
	    }

}
