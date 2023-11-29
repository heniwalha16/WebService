package serverApp;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerService extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/register.fxml"));
        Parent root = loader.load();

        // Set up the scene
        Scene scene = new Scene(root);

        // Set up the stage
        primaryStage.setTitle("Tutor Mangement Application");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	 public static void main(String[] args) {
	        try {
	            // Create the registry at default port 1099
	            LocateRegistry.createRegistry(1099);
	            List TutorsList = new ArrayList<Tutor>();
	            // Create an instance of the server
	            Service tutorService = new Service(TutorsList);
	            tutorService.register("Mayssa.Bouzid@univ-eiffel.fr", "123", "Mayssa", "Bouzid");
	            tutorService.register("Anis.Bouhamed@univ-eiffel.fr", "123", "Anis", "Bouhamed");
	            tutorService.retrieveElement("Mayssa.Bouzid@univ-eiffel.fr").setRate(2000);
	            tutorService.retrieveElement("Mayssa.Bouzid@univ-eiffel.fr").setRating(4);
	            tutorService.login("Anis.Bouhamed@univ-eiffel.fr", "123");
		        
		        // Put the entries in the HashMap
		        String instantHashMap= "2023-11-29 9:00" +" to "+ "10:00";
		        HashMap<String,String> avt = new HashMap<>();
		        avt.put(instantHashMap,"");
		        tutorService.Tutors.get(0).setAvailability(avt);
		        //tutorService.lookTByFirstName("Anis").get(0).setAvailibality(avt);
	            // Bind the server instance to the RMI registry
		        System.out.println(tutorService.Tutors.get(0).Availability.toString());
	            Naming.rebind("TutorService", tutorService);
	            launch(args);
	            System.out.println("TutorServiceServer is running...");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	
}
