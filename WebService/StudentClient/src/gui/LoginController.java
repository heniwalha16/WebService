package gui;

import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
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
import student.Student;
import student.StudentService;

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
		StudentService sts = new StudentService();
		System.out.println(sts.login(mail.getText(), pwd.getText()));
		if(sts.login(mail.getText(), pwd.getText()).equals("User Not Found")) {
		message.setText(sts.login(mail.getText(), pwd.getText()));}
		else {
		Mail=mail.getText();
		try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
            
            studentController studentController = loader.getController();
            studentController.setData(Mail,sts.retrieveElementt(Mail).getFullName());
            Parent root = loader.load();
            // Set up the scene
            Scene scene = new Scene(root);

            // Set up the stage
            Stage stage = new Stage();
            stage.setTitle("Login JavaFX Application");
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
