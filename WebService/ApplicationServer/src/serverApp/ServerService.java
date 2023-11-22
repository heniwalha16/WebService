package serverApp;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServerService {
	 public static void main(String[] args) {
	        try {
	            // Create the registry at default port 1099
	            LocateRegistry.createRegistry(1099);
	            List TutorsList = new ArrayList<Tutor>();
	            // Create an instance of the server
	            Service tutorService = new Service(TutorsList);
	            tutorService.register("Mayssa123", "123", "Mayssa", "Bouzid");
	            tutorService.register("Anis123", "123", "Anis", "Bouhamed");
	            tutorService.login("Anis123", "123");
		        // Create a HashMap with Instant keys and values
		        String instantHashMap= Instant.now().toString();

		        // Get the Instant for 1 hour ago
		        Instant oneHourAgo = Instant.now().minusSeconds(3600);		        
		        // Put the entries in the HashMap
		        instantHashMap= oneHourAgo.toString() +" to "+ instantHashMap;
		        HashMap<String,String> avt = new HashMap<>();
		        avt.put(instantHashMap,"");
		        tutorService.Tutors.get(0).setAvailibality(avt);
		        //tutorService.lookTByFirstName("Anis").get(0).setAvailibality(avt);
	            // Bind the server instance to the RMI registry
		        System.out.println(tutorService.Tutors.get(0).Availibality.toString());
	            Naming.rebind("TutorService", tutorService);

	            System.out.println("TutorServiceServer is running...");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
