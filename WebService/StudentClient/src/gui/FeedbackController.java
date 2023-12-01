package gui;

import java.net.URL;
import java.util.ResourceBundle;

import common.ITutor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FeedbackController implements Initializable{
	@FXML
	Button send;
	@FXML
	TextArea fdbk_text;
	ITutor t;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void sendFeedBack() {
		
	}
	public void sendData(ITutor t) {
		this.t=t;
	}
	

}
