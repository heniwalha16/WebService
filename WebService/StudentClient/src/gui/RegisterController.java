package gui;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.util.ResourceBundle;


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
import student.StudentService;




public class RegisterController implements Initializable{
	
	@FXML
	Button registerbtn;
	@FXML
	Button passtologin;
	@FXML
	TextField mail;
	@FXML
	PasswordField pwd;
	@FXML
	TextField uni;
	@FXML
	TextField fullname;
	@FXML
	Text message;
	String Mail="";
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
    private void Register(ActionEvent event)throws IOException, NotBoundException {
		
		StudentService sts = new StudentService();
		String result=sts.register(mail.getText(), pwd.getText(), fullname.getText(), uni.getText());
		if(result.equals("This account is already existed"))
		{
		message.setText(sts.register(mail.getText(), pwd.getText(), fullname.getText(), uni.getText()));}
		else {
		Mail=mail.getText();
		try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
            Parent root = loader.load();
            studentController StudentController = loader.getController();
            StudentController.setData(sts.retrieveElement(Mail));
            // Set up the scene
            Scene scene = new Scene(root);

            // Set up the stage
            Stage stage = new Stage();
            stage.setTitle("Login JavaFX Application");
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
