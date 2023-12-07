package client;

import java.rmi.RemoteException;
import java.time.Instant;
import java.util.HashMap;

import javax.xml.rpc.ServiceException;


import FxtopAPI.FxtopServicesLocator;
import FxtopAPI.FxtopServicesPortType;
import bank.BankServer;
import bank.BankServerServiceLocator;
import bank.BankServerSoapBindingStub;
import gui.cardViewController;
import gui.studentController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import student.ExternalStudent;
import student.ExternalStudentServiceLocator;
import student.ExternalStudentSoapBindingStub;
import student.Tutors; 

public class Client extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/login.fxml"));
        Parent root = loader.load();
//        studentController StudentController = loader.getController();
//        StudentController.setData("heni.walha", "Heni");
        // Set up the scene
        Scene scene = new Scene(root);

        // Set up the stage
        primaryStage.setTitle("External Student Mangement Application");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	public static void main(String args[])throws RemoteException,ServiceException{
//		ExternalStudent service=new ExternalStudentServiceLocator().getExternalStudent();
//		((ExternalStudentSoapBindingStub) service).setMaintainSession(true);
//		BankServer Bservice=new BankServerServiceLocator().getBankServer();
//		((BankServerSoapBindingStub) Bservice).setMaintainSession(true);
//		FxtopServicesPortType serviceER = new FxtopServicesLocator().getFxtopServicesPort();
//		double rate=12;
//		System.out.println(rate);
//		String CurrencyChosen="USD";
//		double newAmount = Double.parseDouble(serviceER.convert(Double.toString(rate), "EUR", CurrencyChosen, "", "", "").getExchangeRate());
//		System.out.println(newAmount);
//		//Tutors t=new Tutors();
////		t= service.lookTByName("Anis", "Bouhamed");
////		 // Create a HashMap with Instant keys and values
////
////		t=service.lookTByLastName("Bouhamed");
////
////		t=service.lookTByFirstName("Anis");
//		System.out.println(Bservice.pay("Mariam123", newAmount));
//		System.out.println(Bservice.pay("Heni123", newAmount));
//		/*
//		service.BookAppointement("Heni", "Mayssa","Bouzid",oneHourAgo.toString(),(Instant.now()).toString());	
//		System.out.println("ti aya khdemt mabrouk");*/
		System.out.println("ti aya khdemt mabrouk");
		launch(args);
	}
}
