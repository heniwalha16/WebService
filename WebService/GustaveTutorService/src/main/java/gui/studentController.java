package gui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import common.IService;
import common.IStudent;
import common.ITutor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class studentController implements Initializable{
	

	 String Mail;
	 String FullName;
	 IStudent s;
	 @FXML
	 private GridPane tut_container;
	 @FXML
	 private ComboBox comboBox_criteria;
     @FXML
     private TextField search_tut;
     @FXML
     private Button search_btn;
     URL url;
     ResourceBundle rb;
 	@Override
 	public void initialize(URL arg0, ResourceBundle arg1) {
 		// TODO Auto-generated method stub
 		IService listTutors = null;
		try {
			listTutors = (IService) Naming.lookup("rmi://localhost/TutorService");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
 		comboBox_criteria.getItems().addAll("Full Name","First Name", "Last Name","Skill","ALL");
        comboBox_criteria.getSelectionModel().select("ALL");
        
        List<ITutor> TutList = null;
		try {
			TutList = listTutors.getAllTutors();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < TutList.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("cardView.fxml"));
                Pane cardBox = fxmlLoader.load();
                cardViewController cardController = fxmlLoader.getController();
                ITutor t = TutList.get(i);
                cardController.setData(t,Mail,FullName);

                if (column == 2) {
                    column = 0;
                    ++row;
                }
                tut_container.add(cardBox, column++, row);

            }
        } catch (IOException ex) {
        
        	System.out.println(ex);       
}
 	}

     
     
     
     @FXML
     private void search(ActionEvent event) throws MalformedURLException, RemoteException, NotBoundException {
    	 IService listTutors = (IService) Naming.lookup("rmi://localhost/TutorService");
    	 tut_container.getChildren().clear();
         if (comboBox_criteria.getValue().equals("ALL")) {
             initialize(url, rb);
         } else {
        	    List<ITutor> TutList = listTutors.getAllTutors();
        	    if(comboBox_criteria.getValue().equals("Full Name")) {
        	    	String[] words = search_tut.getText().split(" ");
        	    	TutList=listTutors.lookTByName(words[0], words[1]);
        	    }
        	    else if(comboBox_criteria.getValue().equals("First Name")) {
        	    	TutList=listTutors.lookTByFirstName(search_tut.getText());
        	    }
        	    else if(comboBox_criteria.getValue().equals("Last Name")) {
        	    	TutList=listTutors.lookTByLastName(search_tut.getText());
        	    }
        	    else if(comboBox_criteria.getValue().equals("Skill")) {
        	    	TutList=listTutors.lookTBySkill(search_tut.getText());
        	    }
        	    	
                int column = 0;
                int row = 1;
                try {
                    for (int i = 0; i < TutList.size(); i++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("cardView.fxml"));
                        Pane cardBox = fxmlLoader.load();
                        cardViewController cardController = fxmlLoader.getController();
                        ITutor t  = TutList.get(i);
                        cardController.setData(t,Mail,FullName);

                        if (column == 2) {
                            column = 0;
                            ++row;
               
              
                        }

                        tut_container.add(cardBox, column++, row);
                    }

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
         }
     }
     public void setData(IStudent s) {
    	 this.s=s;
     }




     

}
