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

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class LoginController implements Initializable{
	@FXML
	Button loginbtn;
	@FXML
	Button backregister;
	@FXML
	TextField mail;
	@FXML
	PasswordField pwd;
	@FXML
	Text message;
	String Mail="";
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
    private void Login(ActionEvent event)throws IOException,RemoteException, NotBoundException  {
		IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
		System.out.println(tuts.login(mail.getText(), pwd.getText()));
		if(tuts.login(mail.getText(), pwd.getText()).equals("User Not Found")) {
		message.setText(tuts.login(mail.getText(), pwd.getText()));}
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
            Stage currentStage = (Stage) loginbtn.getScene().getWindow();
            currentStage.close();

            // Show the new stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
	}
	}
	@FXML
    private void passToRegister(ActionEvent event) {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
            Parent root = loader.load();
            
            // Set up the scene
            Scene scene = new Scene(root);

            // Set up the stage
            Stage stage = new Stage();
            stage.setTitle("Register JavaFX Application");
            stage.setScene(scene);

            // Close the current stage
            Stage currentStage = (Stage) backregister.getScene().getWindow();
            currentStage.close();

            // Show the new stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
