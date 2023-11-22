package student;

import java.rmi.Naming;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.IService;
import common.ITutor;

public class StudentClient {
	public static void main(String[] args) {
		 try {
		        // Create a HashMap with Instant keys and values
		        String instantHashMap;

		        // Get the Instant for 1 hour ago
		        Instant oneHourAgo = Instant.now().minusSeconds(3600);

		        // Put the entries in the HashMap
		        instantHashMap=oneHourAgo.toString()+" to "+ Instant.now().toString();
		 IService tubalaa = (IService) Naming.lookup("rmi://localhost/TutorService");
		List t=new ArrayList<ITutor>();
		t=tubalaa.lookTByName("Anis","Bouhamed");
		System.out.println(((ITutor)t.stream().findFirst().get()).getLastname());
		t=tubalaa.lookTByLastName("Bouhamed");
		System.out.println(((ITutor)t.stream().findFirst().get()).getLastname());
		t=tubalaa.lookTByFirstName("Anis");
		System.out.println(((ITutor)t.stream().findFirst().get()).getLastname());
		tubalaa.bookAppointment("Heni", "Mayssa","Bouzid","2023-11-22T10:24:02.670985600Z to 2023-11-22T11:24:02.660999800Z");	 
		System.out.println("aha");
		 }
		 catch (Exception e) {
		 System.out.println("Trouble " + e);
		 }
		 }
}
