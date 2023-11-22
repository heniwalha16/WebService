package client;

import java.rmi.RemoteException;
import java.time.Instant;
import java.util.HashMap;

import javax.xml.rpc.ServiceException;

import student.ExternalStudent;
import student.ExternalStudentServiceLocator;
import student.ExternalStudentSoapBindingStub;
import student.Tutors; 

public class Client {
	public static void main(String args[])throws RemoteException,ServiceException{
		ExternalStudent service=new ExternalStudentServiceLocator().getExternalStudent();
		((ExternalStudentSoapBindingStub) service).setMaintainSession(true);
		Tutors t=new Tutors();
		t= service.lookTByName("Anis", "Bouhamed");
		 // Create a HashMap with Instant keys and values

		Instant oneHourAgo = Instant.now().minusSeconds(3600);
		t=service.lookTByLastName("Bouhamed");

		t=service.lookTByFirstName("Anis");
		/*
		service.BookAppointement("Heni", "Mayssa","Bouzid",oneHourAgo.toString(),(Instant.now()).toString());	
		System.out.println("ti aya khdemt mabrouk");*/
		System.out.println("ti aya khdemt mabrouk");
	}
}
