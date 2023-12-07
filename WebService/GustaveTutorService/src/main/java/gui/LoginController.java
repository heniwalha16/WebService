package gui;

import java.io.IOException;
import java.net.URL;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.util.ResourceBundle;

import javax.xml.rpc.ServiceException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginController implements Initializable{
	@FXML
	Button loginbtn;
	@FXML
	Button backregister;
	@FXML
	TextField mail;
	@FXML
	TextField fullName;
	@FXML
	Text message;
	String Mail="";
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
    private void Login(ActionEvent event)throws IOException,RemoteException, NotBoundException, ServiceException  {
		try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
            Parent root = loader.load();
            studentController studentController = loader.getController();
            System.out.println(mail.getText());
            System.out.println(fullName.getText());
            studentController.setData(mail.getText(),fullName.getText());
            
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
