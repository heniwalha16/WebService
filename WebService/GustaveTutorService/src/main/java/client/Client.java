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
import student.ExternalStudent;
import student.ExternalStudentServiceLocator;
import student.ExternalStudentSoapBindingStub;
import student.Tutors; 

public class Client {
	public static void main(String args[])throws RemoteException,ServiceException{
		ExternalStudent service=new ExternalStudentServiceLocator().getExternalStudent();
		((ExternalStudentSoapBindingStub) service).setMaintainSession(true);
		BankServer Bservice=new BankServerServiceLocator().getBankServer();
		((BankServerSoapBindingStub) Bservice).setMaintainSession(true);
		FxtopServicesPortType serviceER = new FxtopServicesLocator().getFxtopServicesPort();
		double rate=12;
		System.out.println(rate);
		String CurrencyChosen="USD";
		double newAmount = Double.parseDouble(serviceER.convert(Double.toString(rate), "EUR", CurrencyChosen, "", "", "").getExchangeRate());
		System.out.println(newAmount);
		Tutors t=new Tutors();
		t= service.lookTByName("Anis", "Bouhamed");
		 // Create a HashMap with Instant keys and values

		t=service.lookTByLastName("Bouhamed");

		t=service.lookTByFirstName("Anis");
		System.out.println(Bservice.pay("Mariam123", newAmount));
		System.out.println(Bservice.pay("Heni123", newAmount));
		/*
		service.BookAppointement("Heni", "Mayssa","Bouzid",oneHourAgo.toString(),(Instant.now()).toString());	
		System.out.println("ti aya khdemt mabrouk");*/
		System.out.println("ti aya khdemt mabrouk");
	}
}
